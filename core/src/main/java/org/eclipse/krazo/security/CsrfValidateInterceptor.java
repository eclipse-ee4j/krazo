/*
 * Copyright © 2017, 2018 Ivar Grimstad
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.eclipse.krazo.security;

import org.eclipse.krazo.KrazoConfig;
import org.eclipse.krazo.core.Messages;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.security.CsrfProtected;
import javax.mvc.security.CsrfValidationException;
import javax.ws.rs.POST;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import static org.eclipse.krazo.util.AnnotationUtils.hasAnnotation;

/**
 * <p>Reader interceptor that checks for the CSRF header and token. If not available as
 * an HTTP header, it looks for it as a form parameter in which case the media type must be
 * {@link javax.ws.rs.core.MediaType#APPLICATION_FORM_URLENCODED_TYPE}. If validation
 * fails, a 403 error is returned.
 * </p>
 *
 * <p>Because this interceptor is bound by name and not globally, it does not check
 * the HTTP method (note that CSRF validation should only apply to non-idempotent
 * requests).</p>
 *
 * <p>Stream buffering is required to restore the entity for the next interceptor.
 * If validation succeeds, it calls the next interceptor in the chain. Default
 * character encoding is utf-8. Even though none of the main browsers send a
 * charset param on a form post, we still check it to decode the entity.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @see <a href="http://www.w3.org/TR/html40/appendix/notes.html#non-ascii-chars">HTML 4.0 Appendix</a>
 */
@Controller
@Priority(Priorities.HEADER_DECORATOR)
public class CsrfValidateInterceptor implements ReaderInterceptor {

    private static final int BUFFER_SIZE = 4096;
    private static final String DEFAULT_CHARSET = "UTF-8";

    @Inject
    private CsrfTokenManager csrfTokenManager;

    @Inject
    private KrazoConfig krazoConfig;

    @Context
    private ResourceInfo resourceInfo;

    @Inject
    private Messages messages;

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        // Validate if name bound or if CSRF property enabled and a POST
        final Method controller = resourceInfo.getResourceMethod();
        if (needsValidation(controller)) {

            CsrfToken token = csrfTokenManager.getToken()
                    .orElseThrow(() -> new CsrfValidationException(messages.get("CsrfFailed", "missing token")));

            // First check if CSRF token is in header
            final String csrfToken = context.getHeaders().getFirst(token.getHeaderName());
            if (token.getValue().equals(csrfToken)) {
                return context.proceed();
            }

            // Otherwise, it must be a form parameter
            final MediaType contentType = context.getMediaType();
            if (!isSupportedMediaType(contentType)) {
                throw new CsrfValidationException(messages.get("UnableValidateCsrf", context.getMediaType()));
            }

            // Ensure stream can be restored for next interceptor
            ByteArrayInputStream bais;
            final InputStream is = context.getInputStream();
            if (is instanceof ByteArrayInputStream) {
                bais = (ByteArrayInputStream) is;
            } else {
                bais = copyStream(is);
            }

            // Validate CSRF
            boolean validated = false;
            final String charset = contentType.getParameters().get("charset");
            final String entity = toString(bais, charset != null ? charset : DEFAULT_CHARSET);
            final String[] pairs = entity.split("\\&");
            for (int i = 0; i < pairs.length; i++) {
                final String[] fields = pairs[i].split("=");
                final String nn = URLDecoder.decode(fields[0], DEFAULT_CHARSET);
                // Is this the CSRF field?
                if (token.getParamName().equals(nn)) {
                    final String vv = URLDecoder.decode(fields[1], DEFAULT_CHARSET);
                    // If so then check the token
                    if (token.getValue().equals(vv)) {
                        validated = true;
                        break;
                    }
                    throw new CsrfValidationException(messages.get("CsrfFailed", "mismatching tokens"));
                }
            }
            if (!validated) {
                throw new CsrfValidationException(messages.get("CsrfFailed", "missing field"));
            }

            // Restore stream and proceed
            bais.reset();
            context.setInputStream(bais);
        }
        return context.proceed();
    }

    protected static boolean isSupportedMediaType(MediaType contentType) {
        return contentType != null &&
            contentType.isCompatible(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
    }

    private ByteArrayInputStream copyStream(InputStream is) throws IOException {
        int n;
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            final byte[] buffer = new byte[BUFFER_SIZE];
            while ((n = is.read(buffer)) >= 0) {
                baos.write(buffer, 0, n);
            }
            return new ByteArrayInputStream(baos.toByteArray());
        }
    }

    private String toString(ByteArrayInputStream bais, String encoding) throws UnsupportedEncodingException {
        int n = 0;
        final byte[] bb = new byte[bais.available()];
        while ((n = bais.read(bb, n, bb.length - n)) >= 0); // NOPMD ignore empty while block
        bais.reset();
        return new String(bb, encoding);
    }

    /**
     * Determines if a controller method needs CSRF validation based on the config options.
     *
     * @param controller controller to inspect.
     * @return outcome of test.
     */
    private boolean needsValidation(Method controller) {
        if (controller == null || !hasAnnotation(controller, POST.class)) {
            return false;
        }
        switch (krazoConfig.getCsrfOptions()) {
            case OFF:
                return false;
            case IMPLICIT:
                return true;
            case EXPLICIT:
                return hasAnnotation(controller, CsrfProtected.class)
                        || hasAnnotation(controller.getDeclaringClass(), CsrfProtected.class);
        }
        return false;
    }
}
