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
package org.eclipse.krazo.servlet;

import org.easymock.EasyMock;
import org.junit.Test;

import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.singletonList;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class KrazoServletContextListenerTest {

    private static class TestController { }


    @Test(expected = IllegalArgumentException.class)
    public void failIfControllerIsNoCdiBean() {

        BeanManager beanManager = createMock(BeanManager.class);
        ServletContextEvent event = createMock(ServletContextEvent.class);
        ServletContext context = createMock(ServletContext.class);

        KrazoServletContextListener listener = new KrazoServletContextListener(beanManager);
        Set<Class<?>> controllers = new HashSet<>(singletonList(TestController.class));

        expect(event.getServletContext()).andStubReturn(context);
        expect(context.getAttribute(KrazoContainerInitializer.CONTROLLER_CLASSES)).andStubReturn(controllers);
        expect(beanManager.getBeans(TestController.class)).andStubReturn(new HashSet<>());

        EasyMock.replay(event, context, beanManager);

        listener.contextInitialized(event);
    }

}
