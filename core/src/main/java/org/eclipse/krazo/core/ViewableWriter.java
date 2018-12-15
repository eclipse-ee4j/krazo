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

import org.eclipse.krazo.cdi.KrazoCdiExtension;
import org.eclipse.krazo.engine.ViewEngineContextImpl;
import org.eclipse.krazo.engine.ViewEngineFinder;
import org.eclipse.krazo.engine.Viewable;
import org.eclipse.krazo.event.AfterProcessViewEventImpl;
import org.eclipse.krazo.event.BeforeProcessViewEventImpl;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineException;
import javax.mvc.event.AfterProcessViewEvent;
import javax.mvc.event.BeforeProcessViewEvent;
import javax.mvc.event.MvcEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

/**
 * <p>Body writer for a {@link Viewable} instance. Looks for a
 * {@link javax.mvc.engine.ViewEngine} that is capable of processing the view. If no
 * engine is found, it forwards the request back to the servlet container.</p>
 *
 * <p>If {@link javax.mvc.Models} is available in the viewable, it is used; otherwise,
 * this class is injected via CDI. A view engine in the viewable can also bypass
 * the lookup mechanism.</p>
 *
 * <p>The charset for the response is obtained from the media type, and defaults to
 * UTF-8.</p>
 *
 * @author Santiago Pericas-Geertsen
 */
@Produces(MediaType.WILDCARD)
public class ViewableWriter implements MessageBodyWriter<Viewable> {

    public static final String CONTENT_TYPE = "Content-Type";
    public static final Charset UTF8 = Charset.forName("UTF-8");

    @Inject
    private Instance<Models> modelsInstance;

    @Context
    private HttpServletRequest injectedRequest;

    @Context
    private HttpServletResponse injectedResponse;

    @Context
    private UriInfo uriInfo;

    @Context
    private ResourceInfo resourceInfo;

    @Inject
    private ViewEngineFinder engineFinder;

    @Context
    private Configuration config;

    @Inject
    private Messages messages;

    @Inject
    private Event<MvcEvent> dispatcher;

    @Inject
    private MvcContext mvc;

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return aClass == Viewable.class;
    }

    @Override
    public long getSize(Viewable viewable, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    /**
     * Searches for a suitable {@link javax.mvc.engine.ViewEngine} to process the view. If no engine
     * is found, is forwards the request back to the servlet container.
     */
    @Override
    public void writeTo(Viewable viewable, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> headers, OutputStream out)
            throws IOException, WebApplicationException {

        // Find engine for this Viewable
        final ViewEngine engine = engineFinder.find(viewable);
        if (engine == null) {
            throw new ServerErrorException(messages.get("NoViewEngine", viewable), INTERNAL_SERVER_ERROR);
        }

        // Special hack for WebSphere Liberty
        HttpServletRequest request = unwrap(injectedRequest, HttpServletRequest.class);
        HttpServletResponse response = unwrap(injectedResponse, HttpServletResponse.class);
        
        // Create wrapper for response
        final ServletOutputStream responseStream = new DelegatingServletOutputStream(out);
        final PrintWriter responseWriter = new PrintWriter(new OutputStreamWriter(responseStream, getCharset(headers)));
        final HttpServletResponse responseWrapper = new MvcHttpServletResponse(response, responseStream, responseWriter);

        // Pass request to view engine
        try {
            // If no models in viewable, inject via CDI
            Models models = viewable.getModels();
            if (models == null) {
                models = modelsInstance.get();
            }

            // Bind EL 'mvc' object in models
            models.put("mvc", mvc);

            // Fire BeforeProcessView event
            if (KrazoCdiExtension.isEventObserved(BeforeProcessViewEvent.class)) {
                final BeforeProcessViewEventImpl event = new BeforeProcessViewEventImpl();
                event.setEngine(engine.getClass());
                event.setView(viewable.getView());
                dispatcher.fire(event);
            }

            // Process view using selected engine
            engine.processView(new ViewEngineContextImpl(viewable.getView(), models, request, responseWrapper,
                    headers, responseStream, mediaType, uriInfo, resourceInfo, config, mvc.getLocale()));

            // Fire AfterProcessView event
            if (KrazoCdiExtension.isEventObserved(AfterProcessViewEvent.class)) {
                final AfterProcessViewEventImpl event = new AfterProcessViewEventImpl();
                event.setEngine(engine.getClass());
                event.setView(viewable.getView());
                dispatcher.fire(event);
            }
        } catch (ViewEngineException e) {
            throw new ServerErrorException(INTERNAL_SERVER_ERROR, e);
        } finally {
            responseWriter.flush();
        }
    }

    /**
     * This method is basically a dirty hack to get Eclipse Krazo work on WebSphere Liberty.
     * The primary use case is to unwrap the original request/response from the wrapper we get
     * from CXF. This is required because the wrappers don't use the official wrapper base classes
     * and therefore Liberty fails to forward such requests because unwrapping isn't possible.
     */
    private <T> T unwrap(T obj, Class<T> type) {

        String implName = obj.getClass().getName();

        if (implName.equals("org.apache.cxf.jaxrs.impl.tl.ThreadLocalHttpServletRequest")
                || implName.equals("org.apache.cxf.jaxrs.impl.tl.ThreadLocalHttpServletResponse")) {

            try {
                return type.cast(
                        obj.getClass().getMethod("get").invoke(obj)
                );
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new IllegalStateException("Failed to unwrap", e);
            }

        }

        return obj;

    }

    /**
     * Looks for a character set as part of the Content-Type header. Returns it
     * if specified or {@link #UTF8} if not.
     *
     * @param headers Response headers.
     * @return Character set to use.
     */
    private Charset getCharset(MultivaluedMap<String, Object> headers) {
        final MediaType mt = getMediaTypeFromHeaders(headers);
        final String charset = mt.getParameters().get(MediaType.CHARSET_PARAMETER);
        return charset != null ? Charset.forName(charset) : UTF8;
    }

    /**
     * JAX-RS implementations are using different types for representing the content type.
     */
    private MediaType getMediaTypeFromHeaders(MultivaluedMap<String, Object> headers) {

        Object value = headers.get(CONTENT_TYPE).get(0);

        // Jersey + RESTEasy
        if (value instanceof MediaType) {
            return (MediaType) value;
        }

        // CXF
        if (value instanceof String) {
            return MediaType.valueOf((String) value);
        }

        return null;

    }

    /**
     * Implementation of {@link ServletOutputStream} which delegate all write operations
     * to an underlying {@link OutputStream} provided by JAX-RS.
     */
    private static class DelegatingServletOutputStream extends ServletOutputStream {
        
        private final OutputStream out;

        public DelegatingServletOutputStream(OutputStream out) {
            this.out = out;
        }

        @Override
        public void write(final int b) throws IOException {
            out.write(b);
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    /**
     * Implementation of {@link HttpServletResponseWrapper} which returns custom
     * output streams and writers.
     */
    private static class MvcHttpServletResponse extends HttpServletResponseWrapper {

        private final ServletOutputStream responseStream;
        private final PrintWriter responseWriter;

        public MvcHttpServletResponse(HttpServletResponse response, ServletOutputStream responseStream, PrintWriter responseWriter) {
            super(response);
            this.responseStream = responseStream;
            this.responseWriter = responseWriter;
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return responseStream;
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return responseWriter;
        }
    }
}
