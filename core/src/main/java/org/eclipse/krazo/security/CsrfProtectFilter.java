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

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.security.Csrf;
import javax.mvc.security.CsrfProtected;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 * <p>Response filter that adds the CSRF header with a unique token value. When CSRF
 * is enabled, clients must submit this header or a form field of name
 * {@link javax.mvc.security.Csrf#getName()} with the same token value for validation
 * to succeed.</p>
 *
 * <p>CSRF can be enabled by setting the property {@link javax.mvc.security.Csrf#CSRF_PROTECTION}
 * to {@link javax.mvc.security.Csrf.CsrfOptions#IMPLICIT}, to by setting it to
 * {@link javax.mvc.security.Csrf.CsrfOptions#EXPLICIT} and annotating the desired
 * controllers with {@link CsrfProtected}. Note that validation only
 * applies to controllers also annotated by {@link javax.ws.rs.POST}.</p>
 *
 * @author Santiago Pericas-Geertsen
 */
@Controller
@Priority(Priorities.HEADER_DECORATOR)
public class CsrfProtectFilter implements ContainerResponseFilter {

    @Inject
    private CsrfTokenManager csrfTokenManager;

    @Inject
    private KrazoConfig krazoConfig;

    /**
     * Inject CSRF header if enabled in the application.
     *
     * @param requestContext the request context.
     * @param responseContext the response context.
     * @throws IOException if a problem occurs writing a response.
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        if (isCsrfEnabled()) {
            final CsrfToken token = csrfTokenManager.getOrCreateToken();
            final MultivaluedMap<String, Object> headers = responseContext.getHeaders();
            if (!headers.containsKey(token.getHeaderName())) {
                headers.putSingle(token.getHeaderName(), token.getValue());
            }
        }
    }

    /**
     * Determines if CSRF is enabled in the application.
     *
     * @return outcome of test.
     */
    private boolean isCsrfEnabled() {
        return krazoConfig.getCsrfOptions() != Csrf.CsrfOptions.OFF;
    }
}
