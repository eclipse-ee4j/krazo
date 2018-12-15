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
package org.eclipse.krazo.engine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriInfo;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.eclipse.krazo.core.ModelsImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The JUnit test for the ViewEngineContext class.
 *
 * @author Manfred Riem (manfred.riem at oracle.com)
 */
public class ViewEngineContextImplTest {

    /**
     * Test getView method.
     */
    @Test
    public void testGetView() {
        ViewEngineContextImpl context = new ViewEngineContextImpl("view", null, null, null, null, null, null, null, null, null, null);
        assertEquals("view", context.getView());
    }

    /**
     * Test getModels method.
     */
    @Test
    public void testGetModels() {
        ViewEngineContextImpl context = new ViewEngineContextImpl(null, null, null, null, null, null, null, null, null, null, null);
        assertNull(context.getModels());
        context = new ViewEngineContextImpl(null, new ModelsImpl(), null, null, null, null, null, null, null, null, null);
        assertNotNull(context.getModels());
    }

    /**
     * Test getRequest method.
     */
    @Test
    public void testGetRequest() {
        ViewEngineContextImpl context = new ViewEngineContextImpl(null, null, null, null, null, null, null, null, null, null, null);
        assertNull(context.getRequest(Object.class));
        HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
        replay(request);
        context = new ViewEngineContextImpl(null, null, request, null, null, null, null, null, null, null, null);
        assertNotNull(context.getRequest(Object.class));
        verify(request);
    }

    /**
     * Test getResponse method.
     */
    @Test
    public void testGetResponse() {
        ViewEngineContextImpl context = new ViewEngineContextImpl(null, null, null, null, null, null, null, null, null, null, null);
        assertNull(context.getResponse(Object.class));
        HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
        replay(response);
        context = new ViewEngineContextImpl(null, null, null, response, null, null, null, null, null, null, null);
        assertNotNull(context.getResponse(Object.class));
        verify(response);
    }

    /**
     * Test getUriInfo method.
     */
    @Test
    public void testGetUriInfo() {
        ViewEngineContextImpl context = new ViewEngineContextImpl(null, null, null, null, null, null, null, null, null, null, null);
        assertNull(context.getUriInfo());
        UriInfo uriInfo = EasyMock.createMock(UriInfo.class);
        replay(uriInfo);
        context = new ViewEngineContextImpl(null, null, null, null, null, null, null, uriInfo, null, null, null);
        assertNotNull(context.getUriInfo());
        verify(uriInfo);
    }

    /**
     * Test getResourceInfo method.
     */
    @Test
    public void testGetResourceInfo() {
        ViewEngineContextImpl context = new ViewEngineContextImpl(null, null, null, null, null, null, null, null, null, null, null);
        assertNull(context.getResourceInfo());
        ResourceInfo resourceInfo = EasyMock.createMock(ResourceInfo.class);
        replay(resourceInfo);
        context = new ViewEngineContextImpl(null, null, null, null, null, null, null, null, resourceInfo, null, null);
        assertNotNull(context.getResourceInfo());
        verify(resourceInfo);
    }

    /**
     * Test getConfiguration method.
     */
    @Test
    public void testGetConfiguration() {
        ViewEngineContextImpl context = new ViewEngineContextImpl(null, null, null, null, null, null, null, null, null, null, null);
        assertNull(context.getConfiguration());
        Configuration config = EasyMock.createMock(Configuration.class);
        replay(config);
        context = new ViewEngineContextImpl(null, null, null, null, null, null, null, null, null, config, null);
        assertNotNull(context.getConfiguration());
        verify(config);
    }
}
