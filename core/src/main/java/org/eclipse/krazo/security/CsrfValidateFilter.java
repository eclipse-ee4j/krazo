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
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Method;

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
public class CsrfValidateFilter implements ContainerRequestFilter {

    @Inject
    private CsrfTokenManager csrfTokenManager;

    @Inject
    private KrazoConfig krazoConfig;

    @Context
    private ResourceInfo resourceInfo;

    @Inject
    private HttpServletRequest request;

    @Inject
    private Messages messages;

    @Override
    public void filter(ContainerRequestContext context) {
        // Validate if name bound or if CSRF property enabled and a POST
        final Method controller = resourceInfo.getResourceMethod();
        if (needsValidation(controller)) {

            CsrfToken token = csrfTokenManager.getToken()
                    .orElseThrow(() -> new CsrfValidationException(messages.get("CsrfFailed", "missing token")));

            // First check if CSRF token is in header
            final String csrfToken = context.getHeaders().getFirst(token.getHeaderName());
            if (token.getValue().equals(csrfToken)) {
                return;
            }

            // Otherwise, it must be a form parameter
            final MediaType contentType = context.getMediaType();
            if (!isSupportedMediaType(contentType)) {
                throw new CsrfValidationException(messages.get("UnableValidateCsrf", context.getMediaType()));
            }

            // Validate CSRF
            final String[] tokenValues = request.getParameterMap().get(token.getParamName());

            if (tokenValues == null) {
                throw new CsrfValidationException(messages.get("CsrfFailed", "missing field"));
            }

            if (!token.getValue().equals(tokenValues[0])) {
                throw new CsrfValidationException(messages.get("CsrfFailed", "mismatching tokens"));
            }
        }
    }

    protected static boolean isSupportedMediaType(MediaType contentType) {
        return contentType != null &&
            contentType.isCompatible(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
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
