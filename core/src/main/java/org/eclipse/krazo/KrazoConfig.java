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
package org.eclipse.krazo;

import org.eclipse.krazo.cdi.RedirectScopeManager;
import org.eclipse.krazo.jaxrs.JaxRsContext;
import org.eclipse.krazo.security.CsrfTokenStrategy;
import org.eclipse.krazo.security.SessionCsrfTokenStrategy;

import javax.inject.Inject;
import javax.mvc.security.Csrf;
import javax.ws.rs.core.Configuration;

/**
 * This class encapsulates the effective runtime configuration. All methods
 * will return either the explicitly configured configuration value or the default
 * value.
 *
 * @author Christian Kaltepoth
 */
public class KrazoConfig {

    @Inject
    @JaxRsContext
    private Configuration config;

    public Csrf.CsrfOptions getCsrfOptions() {

        // check for the config property
        final Object value = config.getProperty(Csrf.CSRF_PROTECTION);
        if (value instanceof Csrf.CsrfOptions) {
            return (Csrf.CsrfOptions) value;
        }

        // default as defined in the spec
        return Csrf.CsrfOptions.EXPLICIT;

    }

    public CsrfTokenStrategy getCsrfTokenStrategy() {

        Object value = config.getProperty(Properties.CSRF_TOKEN_STRATEGY);
        if (value instanceof CsrfTokenStrategy) {
            return (CsrfTokenStrategy) value;
        }

        // default
        return new SessionCsrfTokenStrategy.Builder()
            .headerName(getCsrfHeaderName())
            .build();

    }

    public String getDefaultViewFileExtension() {
        Object value = config.getProperty(Properties.DEFAULT_VIEW_FILE_EXTENSION);
        if (value instanceof String) {
            return (String) value;
        }
        return null;
    }

    public String getCsrfHeaderName() {

        Object value = config.getProperty(Csrf.CSRF_HEADER_NAME);
        if (value != null) {
            return value.toString();
        }

        return Csrf.DEFAULT_CSRF_HEADER_NAME;

    }

    public String getRedirectScopeCookieName() {
        Object value = config.getProperty(Properties.REDIRECT_SCOPE_COOKIE_NAME);
        if (value instanceof String) {
            return (String) value;
        }
        return RedirectScopeManager.DEFAULT_COOKIE_NAME;
    }

    public String getRedirectScopeAttributeName() {
        Object value = config.getProperty(Properties.REDIRECT_SCOPE_QUERY_PARAM_NAME);
        if (value instanceof String) {
            return (String) value;
        }
        return RedirectScopeManager.DEFAULT_QUERY_PARAM_NAME;
    }

}
