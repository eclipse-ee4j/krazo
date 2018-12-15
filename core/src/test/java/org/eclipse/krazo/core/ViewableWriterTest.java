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

import org.easymock.EasyMock;
import org.eclipse.krazo.MvcContextImpl;
import org.eclipse.krazo.engine.ViewEngineFinder;
import org.junit.Test;

import javax.enterprise.event.Event;
import javax.mvc.event.MvcEvent;
import javax.ws.rs.core.Configuration;
import org.eclipse.krazo.engine.Viewable;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The JUnit tests for the ViewableWriter class.
 *
 * @author Manfred Riem (manfred.riem at oracle.com)
 */
@SuppressWarnings("unchecked")
public class ViewableWriterTest {

    /**
     * Test isWriteable method.
     */
    @Test
    public void testIsWriteable() {
        ViewableWriter writer = new ViewableWriter();
        assertFalse(writer.isWriteable(null, null, new Annotation[] {}, MediaType.WILDCARD_TYPE));
        assertTrue(writer.isWriteable(Viewable.class, null, new Annotation[] {}, MediaType.WILDCARD_TYPE));
    }

    /**
     * Test getSize method.
     */
    @Test
    public void testGetSize() {
        ViewableWriter writer = new ViewableWriter();
        assertEquals(-1, writer.getSize(null, null, null, new Annotation[] {}, MediaType.WILDCARD_TYPE));
    }

    /**
     * Test writeTo method.
     *
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testWriteTo() throws Exception {
        ViewableWriter writer = new ViewableWriter();

        Field mvcField = writer.getClass().getDeclaredField("mvc");
        mvcField.setAccessible(true);
        mvcField.set(writer, new MvcContextImpl());
        
        ViewEngineFinder finder = EasyMock.createStrictMock(ViewEngineFinder.class);
        Field finderField = writer.getClass().getDeclaredField("engineFinder");
        finderField.setAccessible(true);
        finderField.set(writer, finder);

        HttpServletRequest request = EasyMock.createStrictMock(HttpServletRequest.class);
        Field requestField = writer.getClass().getDeclaredField("injectedRequest");
        requestField.setAccessible(true);
        requestField.set(writer, request);

        Event<MvcEvent> dispatcher = EasyMock.createStrictMock(Event.class);
        Field dispatcherField = writer.getClass().getDeclaredField("dispatcher");
        dispatcherField.setAccessible(true);
        dispatcherField.set(writer, dispatcher);

        ViewEngine viewEngine = EasyMock.createStrictMock(ViewEngine.class);

        HttpServletResponse response = EasyMock.createStrictMock(HttpServletResponse.class);
        Field responseField = writer.getClass().getDeclaredField("injectedResponse");
        responseField.setAccessible(true);
        responseField.set(writer, response);

        Configuration config = EasyMock.createStrictMock(Configuration.class);
        Field configField = writer.getClass().getDeclaredField("config");
        configField.setAccessible(true);
        configField.set(writer, config);

        MultivaluedHashMap map = new MultivaluedHashMap();
        ArrayList<MediaType> contentTypes = new ArrayList<>();
        contentTypes.add(MediaType.TEXT_HTML_TYPE);
        map.put("Content-Type", contentTypes);

        Viewable viewable = new Viewable("myview");
        viewable.setModels(new ModelsImpl());

        expect(finder.find(anyObject())).andReturn(viewEngine);
        viewEngine.processView((ViewEngineContext) anyObject());

        replay(finder, request, viewEngine, response);
        writer.writeTo(viewable, null, null, new Annotation[] {}, MediaType.WILDCARD_TYPE, map, null);
        verify(finder, request, viewEngine, response);
    }
}
