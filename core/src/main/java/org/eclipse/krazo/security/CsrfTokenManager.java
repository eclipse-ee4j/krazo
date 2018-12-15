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
import org.eclipse.krazo.jaxrs.JaxRsContext;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Central class for managing CSRF tokens
 *
 * @author Christian Kaltepoth
 */
@ApplicationScoped
public class CsrfTokenManager {

    private static final Logger log = Logger.getLogger(CsrfTokenManager.class.getName());

    private CsrfTokenStrategy tokenStrategy;

    @Inject
    @JaxRsContext
    private HttpServletRequest request;

    @Inject
    @JaxRsContext
    private HttpServletResponse response;

    @Inject
    private KrazoConfig krazoConfig;

    @PostConstruct
    public void init() {

        this.tokenStrategy = krazoConfig.getCsrfTokenStrategy();

        log.log(Level.FINE, "Configured strategy for CSRF tokens: {0}", new Object[]{
                this.tokenStrategy.getClass().getName()
        });

    }

    public Optional<CsrfToken> getToken() {
        return tokenStrategy.getToken(request, response, false);
    }

    public CsrfToken getOrCreateToken() {
        return tokenStrategy.getToken(request, response, true)
                .orElseThrow(() -> new IllegalStateException("Strategy did not create a token"));
    }

}
