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
package org.eclipse.krazo;

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

        // TODO: Replace with constant from Csrf class after updating spec dependency
        Object value = config.getProperty("javax.mvc.security.CsrfHeaderName");
        if (value != null) {
            return value.toString();
        }

        // TODO: Replace with constant from Csrf class after updating spec dependency
        return "X-CSRF-TOKEN";

    }

    public boolean isStrictViewResolution() {
        final Object value = config.getProperty(Properties.STRICT_VIEW_RESOLUTION);
        if (value != null) {
            return (boolean) value;
        }

        return true;
    }
}
