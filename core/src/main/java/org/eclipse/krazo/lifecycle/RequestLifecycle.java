/*
 * Copyright (c) 2019 Eclipse Krazo committers and contributors
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

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.Callable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;

import org.eclipse.krazo.MvcContextImpl;
import org.eclipse.krazo.locale.LocaleResolverChain;

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

    private boolean controllerExecuted = false;

    private Method controllerMethod;

    public void beforeAll(ContainerRequestContext context) {

        // initialize request locale
        Locale requestLocale = localeResolverChain.resolve(context);
        mvc.setLocale(requestLocale);

    }

    public Object aroundController(final Method method, Callable<Object> invocation) throws Exception {
        this.controllerMethod = method;

        eventDispatcher.fireBeforeControllerEvent();
        try {
            Object result = invocation.call();
            controllerExecuted = true;

            return result;

        } finally {
            eventDispatcher.fireAfterControllerEvent();
        }
    }

    public boolean isControllerExecuted() {
        return controllerExecuted;
    }

    public Method getControllerMethod() {
        return controllerMethod;
    }
}
