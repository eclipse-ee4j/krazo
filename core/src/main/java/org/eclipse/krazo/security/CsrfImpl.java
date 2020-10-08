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

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.security.Csrf;

/**
 * CSRF bean in request scope available for injection and in EL via the {@link
 * jakarta.mvc.MvcContext} object as {@code mvc.csrf}. Provides access to the CSRF
 * header name (a constant) and the CSRF token value (retrieved from CsrfTokenManager).
 *
 * @author Santiago Pericas-Geertsen
 * @author Christian Kaltepoth
 */
@RequestScoped
public class CsrfImpl implements Csrf {

    @Inject
    private CsrfTokenManager csrfTokenManager;

    public String getName() {
        return csrfTokenManager.getOrCreateToken().getParamName();
    }

    public String getToken() {
        return csrfTokenManager.getOrCreateToken().getValue();
    }

}
