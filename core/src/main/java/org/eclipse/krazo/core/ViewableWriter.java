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

import org.eclipse.krazo.engine.ViewEngineContextImpl;
import org.eclipse.krazo.engine.ViewEngineFinder;
import org.eclipse.krazo.engine.Viewable;
import org.eclipse.krazo.lifecycle.EventDispatcher;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineException;
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
import javax.ws.rs.core.*;
import javax.ws.rs.ext.MessageBodyWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static org.eclipse.krazo.util.HttpUtil.unwrapOriginalRequest;
import static org.eclipse.krazo.util.HttpUtil.unwrapOriginalResponse;

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

    @Inject
    private EventDispatcher eventDispatcher;

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
    public void writeTo(Viewable viewable, Class<?> aClass, Type type, Annotation[] annotations, MediaType resolvedMediaType,
                        MultivaluedMap<String, Object> headers, OutputStream out)
        throws IOException, WebApplicationException {

        // Find engine for this Viewable
        final ViewEngine engine = engineFinder.find(viewable);
        if (engine == null) {
            throw new ServerErrorException(messages.get("NoViewEngine", viewable), INTERNAL_SERVER_ERROR);
        }

        // build the full media type (including the charset) and make sure the response header is set correctly
        MediaType mediaType = buildMediaTypeWithCharset(resolvedMediaType);
        headers.putSingle(HttpHeaders.CONTENT_TYPE, mediaType);

        HttpServletRequest request = unwrapOriginalRequest(injectedRequest);
        HttpServletResponse response = unwrapOriginalResponse(injectedResponse);

        // Create wrapper for response
        final ServletOutputStream responseStream = new DelegatingServletOutputStream(out);
        final HttpServletResponse responseWrapper = new MvcHttpServletResponse(response, responseStream, mediaType, headers);

        // Pass request to view engine
        try {
            // If no models in viewable, inject via CDI
            Models models = viewable.getModels();
            if (models == null) {
                models = modelsInstance.get();
            }

            // Bind EL 'mvc' object in models
            models.put("mvc", mvc);

            // Execute the view engine
            eventDispatcher.fireBeforeProcessViewEvent(engine, viewable);
            try {

                // Process view using selected engine
                engine.processView(new ViewEngineContextImpl(viewable.getView(), models, request, responseWrapper,
                                                             headers, responseStream, mediaType, uriInfo, resourceInfo, config, mvc.getLocale()));

            } finally {
                eventDispatcher.fireAfterProcessViewEvent(engine, viewable);
            }

        } catch (ViewEngineException e) {
            throw new ServerErrorException(INTERNAL_SERVER_ERROR, e);
        } finally {
            responseWrapper.getWriter().flush();
        }
    }

    private static MediaType buildMediaTypeWithCharset(MediaType mediaType) {
        if(mediaType != null) {
            return mediaType.getParameters().get(MediaType.CHARSET_PARAMETER) == null
                ? mediaType.withCharset(StandardCharsets.UTF_8.name())
                : mediaType;
        }
        return MediaType.TEXT_HTML_TYPE.withCharset(StandardCharsets.UTF_8.name());
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
        private final MultivaluedMap<String, Object> responseHeaders;
        private PrintWriter responseWriter;

        public MvcHttpServletResponse(HttpServletResponse response, ServletOutputStream responseStream, MediaType mediaType,
            MultivaluedMap<String, Object> responseHeaders) {

            super(response);
            this.responseStream = responseStream;
            this.responseHeaders = responseHeaders;

            // initialize content-type and character set from JAX-RS header map
            super.setContentType(mediaType.toString());

        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            if (responseWriter != null) {
                throw new IllegalStateException("Calling getOutputStream() after getWriter() is not allowed. ");
            }
            return responseStream;
        }

        @Override
        public void setContentType(String type) {
            super.setContentType(type);

            // update charset in JAX-RS header map
            String charset = MediaType.valueOf(type).getParameters().get(MediaType.CHARSET_PARAMETER);
            if (charset != null) {
                syncCharsetToHeaderMap(charset);
            }

        }

        @Override
        public void setCharacterEncoding(String charset) {

            super.setCharacterEncoding(charset);

            // update charset in JAX-RS header map
            syncCharsetToHeaderMap(charset);

        }

        private void syncCharsetToHeaderMap(String charset) {

            MediaType mediaType = (MediaType) responseHeaders.getFirst(HttpHeaders.CONTENT_TYPE);
            if (mediaType == null) {
                mediaType = MediaType.TEXT_HTML_TYPE;  // should actually never happen
            }

            responseHeaders.putSingle(HttpHeaders.CONTENT_TYPE, mediaType.withCharset(charset));

        }

        @Override
        public PrintWriter getWriter() throws IOException {
            if (responseWriter == null) {
                String characterEncoding = getCharacterEncoding();
                responseWriter = new PrintWriter(new OutputStreamWriter(this.responseStream, characterEncoding));
            }
            return responseWriter;
        }
    }
}
