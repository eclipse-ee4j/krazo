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

import org.easymock.EasyMock;
import org.eclipse.krazo.MvcContextImpl;
import org.eclipse.krazo.engine.ViewEngineFinder;
import org.eclipse.krazo.lifecycle.EventDispatcher;
import org.junit.Test;

import jakarta.enterprise.event.Event;
import jakarta.mvc.event.MvcEvent;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.CacheControl;
import jakarta.ws.rs.core.HttpHeaders;
import org.eclipse.krazo.engine.Viewable;
import jakarta.mvc.engine.ViewEngine;
import jakarta.mvc.engine.ViewEngineContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.ext.RuntimeDelegate;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
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

        EventDispatcher eventDispatcher = EasyMock.createMock(EventDispatcher.class);
        Field eventDispatcherField = writer.getClass().getDeclaredField("eventDispatcher");
        eventDispatcherField.setAccessible(true);
        eventDispatcherField.set(writer, eventDispatcher);

        ViewEngine viewEngine = EasyMock.createStrictMock(ViewEngine.class);
        List<String> responseContentTypes = new ArrayList<>();

        HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
        response.setContentType(anyString());
        expectLastCall().andAnswer(() -> {
            responseContentTypes.add((String) EasyMock.getCurrentArguments()[0]);
            return null;
        }).times(2);
        expect(response.getContentType()).andReturn("text/html;charset=UTF-8");
        response.setHeader(anyString(), anyString());
        expectLastCall().anyTimes();
        expect(response.getCharacterEncoding()).andReturn("UTF-8").anyTimes();
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
        writer.writeTo(viewable, null, null, new Annotation[] {}, MediaType.TEXT_HTML_TYPE, map, null);
        verify(finder, request, viewEngine, response);
        assertEquals(2, responseContentTypes.size());
        assertEquals("text/html;charset=UTF-8", responseContentTypes.get(0));
        assertEquals("text/html;charset=UTF-8", responseContentTypes.get(1));
    }

    @Test
    public void testWriteToCopiesControllerHeadersToServletResponse() throws Exception {
        ViewableWriter writer = new ViewableWriter();

        ViewEngineFinder finder = configureWriter(writer);
        ViewEngine viewEngine = EasyMock.createStrictMock(ViewEngine.class);
        Map<String, String> copiedHeaders = new HashMap<>();

        MultivaluedHashMap<String, Object> map = new MultivaluedHashMap<>();
        map.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_TYPE);
        map.putSingle("X-Controller-Header", "Foobar");
        CacheControl cacheControl = new CacheControl();
        cacheControl.setPrivate(true);
        map.putSingle(HttpHeaders.CACHE_CONTROL, cacheControl);
        Date lastModified = new Date(0L);
        map.putSingle(HttpHeaders.LAST_MODIFIED, lastModified);

        HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
        EasyMock.checkOrder(response, false);
        List<String> contentTypes = new ArrayList<>();
        response.setContentType(anyString());
        expectLastCall().andAnswer(() -> {
            contentTypes.add((String) EasyMock.getCurrentArguments()[0]);
            return null;
        }).anyTimes();
        expect(response.getContentType()).andReturn("text/html;charset=UTF-8");
        response.setHeader(anyString(), anyString());
        expectLastCall().andAnswer(() -> {
            copiedHeaders.put((String) EasyMock.getCurrentArguments()[0], (String) EasyMock.getCurrentArguments()[1]);
            return null;
        }).anyTimes();
        expect(response.getCharacterEncoding()).andReturn("UTF-8").anyTimes();
        setField(writer, "injectedResponse", response);

        Viewable viewable = new Viewable("myview");
        viewable.setModels(new ModelsImpl());

        expect(finder.find(anyObject())).andReturn(viewEngine);
        viewEngine.processView((ViewEngineContext) anyObject());

        replay(finder, viewEngine, response);
        writer.writeTo(viewable, null, null, new Annotation[] {}, MediaType.TEXT_HTML_TYPE, map, null);
        verify(finder, viewEngine, response);
        assertTrue(contentTypes.contains("text/html;charset=UTF-8"));
        assertEquals("Foobar", copiedHeaders.get("X-Controller-Header"));
        assertEquals(cacheControl.toString(), copiedHeaders.get(HttpHeaders.CACHE_CONTROL));
        assertEquals(RuntimeDelegate.getInstance().createHeaderDelegate(Date.class).toString(lastModified),
                copiedHeaders.get(HttpHeaders.LAST_MODIFIED));
    }

    @Test
    public void testWriteToPreservesExplicitControllerMediaType() throws Exception {
        ViewableWriter writer = new ViewableWriter();

        ViewEngineFinder finder = configureWriter(writer);
        ViewEngine viewEngine = EasyMock.createStrictMock(ViewEngine.class);

        HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
        List<String> contentTypes = new ArrayList<>();
        response.setContentType(anyString());
        expectLastCall().andAnswer(() -> {
            contentTypes.add((String) EasyMock.getCurrentArguments()[0]);
            return null;
        }).times(2);
        expect(response.getContentType()).andReturn("text/plain;charset=UTF-8");
        response.setHeader(anyString(), anyString());
        expectLastCall().anyTimes();
        expect(response.getCharacterEncoding()).andReturn("UTF-8").anyTimes();
        setField(writer, "injectedResponse", response);

        MultivaluedHashMap<String, Object> map = new MultivaluedHashMap<>();
        map.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_TYPE);

        Viewable viewable = new Viewable("myview");
        viewable.setModels(new ModelsImpl());

        expect(finder.find(anyObject())).andReturn(viewEngine);
        viewEngine.processView((ViewEngineContext) anyObject());
        expectLastCall().andAnswer(() -> {
            ViewEngineContext context = (ViewEngineContext) EasyMock.getCurrentArguments()[0];
            context.getResponse(HttpServletResponse.class).setContentType("text/html");
            return null;
        });

        replay(finder, viewEngine, response);
        writer.writeTo(viewable, null, null, new Annotation[] {}, MediaType.TEXT_PLAIN_TYPE, map, null);
        verify(finder, viewEngine, response);

        assertEquals(2, contentTypes.size());
        assertEquals("text/plain;charset=UTF-8", contentTypes.get(0));
        assertEquals("text/plain;charset=UTF-8", contentTypes.get(1));
        assertEquals("text/plain;charset=UTF-8", map.getFirst(HttpHeaders.CONTENT_TYPE).toString());
    }

    @Test
    public void testWriteToIgnoresJspContentTypeHeaderOverride() throws Exception {
        ViewableWriter writer = new ViewableWriter();

        ViewEngineFinder finder = configureWriter(writer);
        ViewEngine viewEngine = EasyMock.createStrictMock(ViewEngine.class);

        HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
        List<String> contentTypes = new ArrayList<>();
        response.setContentType(anyString());
        expectLastCall().andAnswer(() -> {
            contentTypes.add((String) EasyMock.getCurrentArguments()[0]);
            return null;
        }).times(2);
        expect(response.getContentType()).andReturn("text/plain;charset=UTF-8");
        response.setHeader(anyString(), anyString());
        expectLastCall().anyTimes();
        expect(response.getCharacterEncoding()).andReturn("UTF-8").anyTimes();
        setField(writer, "injectedResponse", response);

        MultivaluedHashMap<String, Object> map = new MultivaluedHashMap<>();
        map.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_TYPE);

        Viewable viewable = new Viewable("myview");
        viewable.setModels(new ModelsImpl());

        expect(finder.find(anyObject())).andReturn(viewEngine);
        viewEngine.processView((ViewEngineContext) anyObject());
        expectLastCall().andAnswer(() -> {
            ViewEngineContext context = (ViewEngineContext) EasyMock.getCurrentArguments()[0];
            context.getResponse(HttpServletResponse.class).setHeader(HttpHeaders.CONTENT_TYPE, "text/html");
            return null;
        });

        replay(finder, viewEngine, response);
        writer.writeTo(viewable, null, null, new Annotation[] {}, MediaType.TEXT_PLAIN_TYPE, map, null);
        verify(finder, viewEngine, response);

        assertEquals(2, contentTypes.size());
        assertEquals("text/plain;charset=UTF-8", contentTypes.get(0));
        assertEquals("text/plain;charset=UTF-8", contentTypes.get(1));
        assertEquals("text/plain;charset=UTF-8", map.getFirst(HttpHeaders.CONTENT_TYPE).toString());
    }

    @Test
    public void testWriteToIgnoresJspContentTypeAddHeaderOverride() throws Exception {
        ViewableWriter writer = new ViewableWriter();

        ViewEngineFinder finder = configureWriter(writer);
        ViewEngine viewEngine = EasyMock.createStrictMock(ViewEngine.class);

        HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
        List<String> contentTypes = new ArrayList<>();
        response.setContentType(anyString());
        expectLastCall().andAnswer(() -> {
            contentTypes.add((String) EasyMock.getCurrentArguments()[0]);
            return null;
        }).times(2);
        expect(response.getContentType()).andReturn("text/plain;charset=UTF-8");
        response.setHeader(anyString(), anyString());
        expectLastCall().anyTimes();
        expect(response.getCharacterEncoding()).andReturn("UTF-8").anyTimes();
        setField(writer, "injectedResponse", response);

        MultivaluedHashMap<String, Object> map = new MultivaluedHashMap<>();
        map.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_TYPE);

        Viewable viewable = new Viewable("myview");
        viewable.setModels(new ModelsImpl());

        expect(finder.find(anyObject())).andReturn(viewEngine);
        viewEngine.processView((ViewEngineContext) anyObject());
        expectLastCall().andAnswer(() -> {
            ViewEngineContext context = (ViewEngineContext) EasyMock.getCurrentArguments()[0];
            context.getResponse(HttpServletResponse.class).addHeader(HttpHeaders.CONTENT_TYPE, "text/html");
            return null;
        });

        replay(finder, viewEngine, response);
        writer.writeTo(viewable, null, null, new Annotation[] {}, MediaType.TEXT_PLAIN_TYPE, map, null);
        verify(finder, viewEngine, response);

        assertEquals(2, contentTypes.size());
        assertEquals("text/plain;charset=UTF-8", contentTypes.get(0));
        assertEquals("text/plain;charset=UTF-8", contentTypes.get(1));
        assertEquals("text/plain;charset=UTF-8", map.getFirst(HttpHeaders.CONTENT_TYPE).toString());
    }

    private ViewEngineFinder configureWriter(ViewableWriter writer) throws Exception {
        setField(writer, "mvc", new MvcContextImpl());
        setField(writer, "injectedRequest", EasyMock.createNiceMock(HttpServletRequest.class));
        setField(writer, "dispatcher", EasyMock.createNiceMock(Event.class));
        setField(writer, "eventDispatcher", EasyMock.createNiceMock(EventDispatcher.class));
        setField(writer, "config", EasyMock.createNiceMock(Configuration.class));

        ViewEngineFinder finder = EasyMock.createStrictMock(ViewEngineFinder.class);
        setField(writer, "engineFinder", finder);
        return finder;
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
