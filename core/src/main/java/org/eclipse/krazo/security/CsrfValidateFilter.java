/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, 2019 Eclipse Krazo committers and contributors
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

import static org.eclipse.krazo.util.AnnotationUtils.hasAnnotation;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.security.CsrfProtected;
import javax.mvc.security.CsrfValidationException;
import javax.ws.rs.DELETE;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.eclipse.krazo.KrazoConfig;
import org.eclipse.krazo.core.Messages;
import org.eclipse.krazo.util.ServiceLoaders;

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
 * <p>If validation succeeds, it calls the next interceptor in the chain. Default
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
    private Messages messages;

    private FormEntityProvider formEntityProvider;

    public CsrfValidateFilter() {
        this.formEntityProvider = ServiceLoaders.list(FormEntityProvider.class).get(0);
    }

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
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
            if (!isSupportedMediaType(contentType) || !context.hasEntity()) {
                throw new CsrfValidationException(messages.get("UnableValidateCsrf", context.getMediaType()));
            }

            // Validate CSRF
            final Form form = formEntityProvider.getForm(context);
            final List<String> tokenValues = form.asMap().get(token.getParamName());
            if (tokenValues == null || tokenValues.isEmpty()) {
                throw new CsrfValidationException(messages.get("CsrfFailed", "missing field"));
            }

            if (!token.getValue().equals(tokenValues.get(0))) {
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
    private boolean needsValidation(final Method controller) {
        if (controller == null || !performsWriteAccess(controller)) {
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

    /**
     * Check if the controller wants to perform a write access. This means, in HTTP verbs, it wants
     * to perform a {@link POST}, {@link PUT}, {@link PATCH} or {@link DELETE} annotated method.
     *
     * Because the {@link org.eclipse.krazo.forms.HiddenMethodFilter} enables us to use this methods in forms, we
     * need to validate a Csrf token for them too, because the HTTP POST method is overwritten before this filter is entered.
     *
     * @param controller the controller method to check for write access
     * @return true, if the controller method wants to perform a write access, false if not
     */
    private boolean performsWriteAccess(final Method controller) {
        return hasAnnotation(controller, POST.class) || hasAnnotation(controller, PATCH.class) ||
            hasAnnotation(controller, PUT.class) || hasAnnotation(controller, DELETE.class);
    }

}
