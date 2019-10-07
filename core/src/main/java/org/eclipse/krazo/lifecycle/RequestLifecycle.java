/*
 * Copyright © 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.lifecycle;

import org.eclipse.krazo.MvcContextImpl;
import org.eclipse.krazo.core.RequestAttributes;
import org.eclipse.krazo.jaxrs.JaxRsContext;
import org.eclipse.krazo.locale.LocaleResolverChain;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import java.util.Locale;
import java.util.concurrent.Callable;

/**
 * Implements the lifecycle of MVC requests
 */
@RequestScoped
public class RequestLifecycle {

    @Inject
    private EventDispatcher eventDispatcher;

    @Inject
    private LocaleResolverChain localeResolverChain;

    @Inject
    private MvcContextImpl mvc;

    @Inject
    @JaxRsContext
    private HttpServletRequest request;

    public void beforeAll(ContainerRequestContext context) {

        // initialize request locale
        Locale requestLocale = localeResolverChain.resolve(context);
        mvc.setLocale(requestLocale);

    }

    public Object aroundController(Callable<Object> controllerMethod) throws Exception {

        eventDispatcher.fireBeforeControllerEvent();
        try {
            final Object result = controllerMethod.call();
            request.setAttribute(RequestAttributes.CONTROLLER_EXECUTED.name(), true);
            return result;

        } finally {
            eventDispatcher.fireAfterControllerEvent();
        }

    }

}
