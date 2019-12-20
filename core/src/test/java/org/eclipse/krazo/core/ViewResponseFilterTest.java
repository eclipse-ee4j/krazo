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
package org.eclipse.krazo.core;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import javax.enterprise.event.Event;
import javax.mvc.View;
import javax.mvc.event.MvcEvent;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.StatusType;

import org.eclipse.krazo.KrazoConfig;
import org.eclipse.krazo.engine.Viewable;
import org.eclipse.krazo.lifecycle.RequestLifecycle;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for ViewResponseFilter
 *
 * @author Dmytro Maidaniuk
 * @author Jonatan Lemes
 */

public class ViewResponseFilterTest {

    private ViewResponseFilter viewResponseFilter;

    private ContainerResponseContext containerResponseContext;

    private ContainerRequestContext containerRequestContext;

    private ViewPathResolver viewPathResolver;

    private RequestLifecycle requestLifecycle;

    private KrazoConfig krazoConfig;

    private Messages messages;

    private HttpServletRequest request;

    private ResourceInfo resourceInfo;

    private UriInfo uriInfo;

    private Event<MvcEvent> dispatcher;

    private StatusType statusType;

    @Before
    public void before() {
        statusType = createMock(StatusType.class);
        uriInfo = createMock(UriInfo.class);
        resourceInfo = createMock(ResourceInfo.class);
        request = createMock(HttpServletRequest.class);
        dispatcher = createMock(Event.class);
        messages = createMock(Messages.class);
        krazoConfig = createMock(KrazoConfig.class);
        requestLifecycle = createMock(RequestLifecycle.class);
        viewPathResolver = new DefaultViewPathResolver();
        containerResponseContext = createMock(ContainerResponseContext.class);
        containerRequestContext = createMock(ContainerRequestContext.class);
        viewResponseFilter = new ViewResponseFilter(uriInfo, resourceInfo, request, dispatcher, messages, krazoConfig, requestLifecycle, viewPathResolver);
    }

    public static Collection<String[]> data() {
        return Arrays.asList(new String[][] {
                { "main.jsp", "jsp", "main.jsp" },
                { "main", "jsp", "main.jsp" },
                { "main", null, "main" },
                { "main", "", "main" },
                { "redirect:some.jsp", "jsp", "redirect:some.jsp" },
                { "react:some", "jsp", "react:some.jsp" },
                { "main.", "jsp", "main." }
        });
    }

    @Test
    public void testAppendExtensionIfRequired() {
        for (String[] data : data()) {
            String viewName = data[0];
            String defaultExtension = data[1];
            String expectedViewName = data[2];
            String actualViewName = ViewResponseFilter.appendExtensionIfRequired(viewName, defaultExtension);
            assertEquals(expectedViewName, actualViewName);
        }
    }

    private Viewable mockBehaviours(Class<?> clazz, Method method) throws IOException {

        ViewableHolder viewableHolder = new ViewableHolder();

        expect(request.getAttribute(ViewResponseFilter.FILTER_EXECUTED_KEY)).andReturn(null);
        request.setAttribute(anyString(), anyBoolean());
        expect(requestLifecycle.isControllerExecuted()).andReturn(true);
        expect(requestLifecycle.getControllerMethod()).andReturn(method);
        expect(containerResponseContext.getEntity()).andReturn(null);
        expect(statusType.getStatusCode()).andReturn(Response.Status.NO_CONTENT.getStatusCode());
        expect(containerResponseContext.getStatusInfo()).andReturn(statusType);
        expect(resourceInfo.getResourceMethod()).andReturn(method);
        resourceInfo.getResourceClass();
        expectLastCall().andReturn(clazz);

        containerResponseContext.setEntity(anyObject(Viewable.class), anyObject(), anyObject());
        expectLastCall().andAnswer(() -> {
            viewableHolder.viewable = (Viewable) getCurrentArguments()[0];
            return null;
        }).times(1);
        containerResponseContext.setStatusInfo(anyObject());
        expect(containerResponseContext.getEntity()).andReturn(null);
        expect(containerResponseContext.getStatus()).andReturn(200);

        replay(statusType);
        replay(resourceInfo);
        replay(request);
        replay(requestLifecycle);
        replay(containerResponseContext);

        viewResponseFilter.filter(containerRequestContext, containerResponseContext);

        return viewableHolder.viewable;
    }

    @Test
    public void testDefaultBehaviourWithNoException() throws Exception {
        Class<MyTestClass> clazz = MyTestClass.class;
        assertEquals("a.jsp", mockBehaviours(clazz, clazz.getDeclaredMethod("someMethod")).getView());
    }

    @Test(expected = ServerErrorException.class)
    public void testDefaultBehaviourWithException() throws Exception {
        Class<MyTestClass> clazz = MyTestClass.class;
        assertEquals("a.jsp", mockBehaviours(clazz, clazz.getDeclaredMethod("someMethod2")).getView());
    }

    @Test
    public void testDefaultBehaviourWithAnnotedClassWithAnnotation() throws Exception {
        Class<MyTestClass2> clazz = MyTestClass2.class;
        assertEquals("a.jsp", mockBehaviours(clazz, clazz.getDeclaredMethod("someMethod")).getView());
        
    }
    
    @Test
    public void testDefaultBehaviourWithAnnotedClassWithoutAnnotation() throws Exception {
        Class<MyTestClass2> clazz = MyTestClass2.class;
        assertEquals("b.jsp", mockBehaviours(clazz, clazz.getDeclaredMethod("someMethod2")).getView());
    }

    @Test
    public void testDefaultBehaviourWithInheritClassMethod1() throws Exception {
        Class<MyTestClass3> clazz = MyTestClass3.class;
        assertEquals("a.jsp", mockBehaviours(clazz, clazz.getMethod("someMethod")).getView());
    }
    
    @Test
    public void testDefaultBehaviourWithInheritClassMethod2() throws Exception {
        Class<MyTestClass3> clazz = MyTestClass3.class;
        assertEquals("b.jsp", mockBehaviours(clazz, clazz.getMethod("someMethod2")).getView());
    }

    private class ViewableHolder {
        public Viewable viewable;
    }

    private class MyTestClass {

        @View("a.jsp")
        public void someMethod() {

        }

        public void someMethod2() {

        }
    }

    @View("b.jsp")
    private class MyTestClass2 {

        @View("a.jsp")
        public void someMethod() {

        }

        public void someMethod2() {

        }
    }

    private class MyTestClass3 extends MyTestClass2 {

    }

}
