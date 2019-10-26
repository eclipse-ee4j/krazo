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
package org.eclipse.krazo.cdi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.eclipse.krazo.lifecycle.RequestLifecycle;

/**
 * @author Christian Kaltepoth
 */
@Interceptor
@AroundController
@Priority(Interceptor.Priority.PLATFORM_AFTER)
public class AroundControllerInterceptor implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(AroundControllerInterceptor.class.getName());

    private static final long serialVersionUID = -5804986456381504613L;

    @Inject
    private RequestLifecycle requestLifecycle;

    @AroundInvoke
    public Object validateMethodInvocation(InvocationContext ctx) throws Exception {
        LOGGER.log(Level.FINE, "Invoking method: {0}#{1}", new Object[] { ctx.getMethod().getDeclaringClass().getName(), ctx.getMethod().getName() });
        return requestLifecycle.aroundController(ctx.getMethod(), ctx::proceed);
    }

}
