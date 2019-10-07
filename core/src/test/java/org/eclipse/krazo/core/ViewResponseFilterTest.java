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
package org.eclipse.krazo.core;

import com.sun.xml.internal.ws.client.ResponseContext;
import org.easymock.*;
import org.eclipse.krazo.KrazoConfig;
import org.eclipse.krazo.cdi.KrazoCdiExtension;
import org.eclipse.krazo.engine.Viewable;
import org.eclipse.krazo.event.ControllerRedirectEventImpl;
import org.eclipse.krazo.lifecycle.EventDispatcher;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import sun.security.provider.certpath.OCSPResponse;

import javax.enterprise.event.Event;
import javax.mvc.View;
import javax.mvc.event.ControllerRedirectEvent;
import javax.mvc.event.MvcEvent;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * Test for ViewResponseFilter
 *
 * @author Dmytro Maidaniuk
 */
@RunWith(org.junit.experimental.runners.Enclosed.class)
public class ViewResponseFilterTest {

    public static class ResponseFilterTest extends EasyMockSupport {

        @Rule
        public EasyMockRule easyMockRule = new EasyMockRule(this);

        @Mock(type = MockType.NICE)
        private ContainerRequestContext requestContext;

        @Mock(type = MockType.NICE)
        private ContainerResponseContext responseContext;

        @Mock(type = MockType.NICE)
        private HttpServletRequest request;

        @Mock(type = MockType.NICE)
        private ResourceInfo resourceInfo;

        @Mock(type = MockType.NICE)
        private UriInfo uriInfo;

        @Mock(type = MockType.NICE)
        private Event<MvcEvent> dispatcher;

        @Mock(type = MockType.NICE)
        private KrazoConfig krazoConfig = new KrazoConfig();

        @TestSubject
        private ViewResponseFilter responseFilter = new ViewResponseFilter();

        private Object responseEntity;
        private MultivaluedHashMap<String, Object> responseHeaders;
        private Response.Status responseStatus;

        void mockControllerCall(Object controller, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            final Method method = controller.getClass().getMethod(methodName);
            responseEntity = method.invoke(controller);
            responseStatus = method.getReturnType() == Void.TYPE ? Response.Status.NO_CONTENT : Response.Status.OK;

            expect(resourceInfo.getResourceMethod()).andStubReturn(method);
            expect((Object) resourceInfo.getResourceClass()).andStubReturn(controller.getClass());
            expect(responseContext.getEntity()).andAnswer(() -> responseEntity);
            expect(responseContext.getEntity()).andAnswer(() -> responseEntity);
        }

        @AfterClass
        public static void clearRegisteredEvents() {
            KrazoCdiExtension.clearEventsObserved();
        }

        @Before
        public void setUp() throws Exception {
            expect(request.getAttribute(anyString())).andReturn(null);
            expect(krazoConfig.getDefaultViewFileExtension()).andReturn("jsp");
            expect(uriInfo.getBaseUri()).andStubReturn(new URI("/"));

            responseHeaders = new MultivaluedHashMap<>();
            expect(responseContext.getHeaders()).andStubReturn(responseHeaders);
            expect(responseContext.getHeaderString(anyString())).andStubAnswer(() -> String.valueOf(responseHeaders.getFirst((String) EasyMock.getCurrentArguments()[0])));

            Capture<Object> responseEntityCapture = newCapture();
            responseContext.setEntity(capture(responseEntityCapture), anyObject(), anyObject());
            expectLastCall().andStubAnswer(() -> responseEntity = responseEntityCapture.getValue());

            Capture<Response.Status> responseStatusCapture = newCapture();
            responseContext.setStatusInfo(capture(responseStatusCapture));
            expectLastCall().andStubAnswer(() -> responseStatus = responseStatusCapture.getValue());
            expect(responseContext.getStatusInfo()).andStubAnswer(() -> responseStatus);
            expect(responseContext.getStatus()).andStubAnswer(() -> responseStatus.getStatusCode());
        }

        @Test
        public void testFilteringStringEntities() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            mockControllerCall(new SampleController(), "view");
            replayAll();

            responseFilter.filter(requestContext, responseContext);

            verifyAll();
            assertEquals(responseEntity, new Viewable("helloWorld.jsp"));
        }

        @Test
        public void testFilteringVoidMethodsWithViewAnnotation() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            mockControllerCall(new SampleController(), "annotatedView");
            replayAll();

            responseFilter.filter(requestContext, responseContext);

            verifyAll();
            assertEquals(new Viewable("helloAnnotation.jsp"), responseEntity);
            assertEquals(Response.Status.OK, responseStatus);
        }

        @Test
        public void testFilteringVoidMethodsWithAnnotatedController() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            mockControllerCall(new AnnotatedController(), "view");
            replayAll();

            responseFilter.filter(requestContext, responseContext);

            verifyAll();
            assertEquals(new Viewable("helloWorld.jsp"), responseEntity);
            assertEquals(Response.Status.OK, responseStatus);
        }

        @Test
        public void testFilteringRedirect() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            mockControllerCall(new SampleController(), "redirect");
            replayAll();

            responseFilter.filter(requestContext, responseContext);

            verifyAll();
            assertEquals(new Viewable("redirect:view"), responseEntity);
            assertEquals(Response.Status.SEE_OTHER, responseStatus);
            assertEquals("/view", responseHeaders.getFirst(HttpHeaders.LOCATION));
        }

        @Test
        public void testFiringRedirectEvents() throws Exception {
            KrazoCdiExtension.addObservedEvent(ControllerRedirectEvent.class);

            mockControllerCall(new SampleController(), "redirect");
            final Capture<MvcEvent> mvcEvent = newCapture();
            dispatcher.fire(capture(mvcEvent));
            expectLastCall().once();

            replayAll();

            responseFilter.filter(requestContext, responseContext);

            verifyAll();
            final ControllerRedirectEvent redirectEvent = (ControllerRedirectEvent) mvcEvent.getValue();
            assertEquals(redirectEvent.getLocation(), new URI("/view"));
        }

        @Test
        public void testSimulatedException() throws Exception {
            final Method method = SampleController.class.getMethod("annotatedView");
            expect(resourceInfo.getResourceMethod()).andStubReturn(method);
            expect((Object) resourceInfo.getResourceClass()).andStubReturn(SampleController.class);
            responseStatus = Response.Status.FORBIDDEN;

            replayAll();

            responseFilter.filter(requestContext, responseContext);

            verifyAll();
            assertEquals(responseStatus, Response.Status.FORBIDDEN);
            assertNull(responseEntity);
        }

        private static class SampleController {

            public String view() {
                return "helloWorld";
            }

            @View("helloAnnotation")
            public void annotatedView() {

            }

            public String redirect() {
                return "redirect:view";
            }
        }

        @View("helloWorld.jsp")
        private static class AnnotatedController {

            public void view() {

            }
        }
    }

    @RunWith(value = Parameterized.class)
    public static class AppendExtensionTest {

        private String viewName;
        private String defaultExtension;
        private String expectedViewName;

        public AppendExtensionTest(String viewName,
                                   String defaultExtension,
                                   String expectedViewName) {
            this.viewName = viewName;
            this.defaultExtension = defaultExtension;
            this.expectedViewName = expectedViewName;
        }

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                {"main.jsp", "jsp", "main.jsp"},
                {"main", "jsp", "main.jsp"},
                {"main", null, "main"},
                {"main", "", "main"},
                {"redirect:some.jsp", "jsp", "redirect:some.jsp"},
                {"react:some", "jsp", "react:some.jsp"},
                {"main.", "jsp", "main."}
            });
        }

        @Test
        public void testAppendExtensionIfRequired() {
            String actualViewName = ViewResponseFilter.appendExtensionIfRequired(viewName, defaultExtension);
            assertEquals(expectedViewName, actualViewName);
        }
    }

}
