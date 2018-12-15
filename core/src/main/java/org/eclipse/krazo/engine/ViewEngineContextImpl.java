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

import javax.mvc.Models;
import javax.mvc.engine.ViewEngineContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.io.OutputStream;
import java.util.Locale;

/**
 * Implementation of {@link javax.mvc.engine.ViewEngineContext}. Provides all the information
 * needed for a view engine to process a view.
 *
 * @author Santiago Pericas-Geertsen
 */
public class ViewEngineContextImpl implements ViewEngineContext {

    private final String view;

    private final Models models;

    private final Object request;

    private final Object response;

    private final MultivaluedMap<String, Object> responseHeaders;

    private final OutputStream outputStream;

    private final MediaType mediaType;

    private final UriInfo uriInfo;

    private final ResourceInfo resourceInfo;

    private final Configuration configuration;

    private final Locale locale;

    /**
     * Constructor for view engine contexts.
     *
     * @param view Name of view.
     * @param models Instance of models.
     * @param request HTTP servlet request.
     * @param response HTTP servlet response.
     * @param responseHeaders The response responseHeaders
     * @param outputStream The response stream
     * @param mediaType The media type
     * @param uriInfo URI info about the request.
     * @param resourceInfo Resource matched info.
     * @param configuration the configuration.
     * @param locale the request locale
     */
    public ViewEngineContextImpl(String view, Models models, Object request, Object response,
                                 MultivaluedMap<String, Object> responseHeaders, OutputStream outputStream,
                                 MediaType mediaType, UriInfo uriInfo, ResourceInfo resourceInfo,
                                 Configuration configuration, Locale locale) {
        this.view = view;
        this.models = models;
        this.request = request;
        this.response = response;
        this.responseHeaders = responseHeaders;
        this.outputStream = outputStream;
        this.mediaType = mediaType;
        this.uriInfo = uriInfo;
        this.resourceInfo = resourceInfo;
        this.configuration = configuration;
        this.locale = locale;
    }

    @Override
    public String getView() {
        return view;
    }

    @Override
    public Models getModels() {
        return models;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public <T> T getRequest(Class<T> type) {
        return type.cast(request);
    }

    @Override
    public <T> T getResponse(Class<T> type) {
        return type.cast(response);
    }

    @Override
    public MultivaluedMap<String, Object> getResponseHeaders() {
        return responseHeaders;
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public MediaType getMediaType() {
        return mediaType;
    }

    @Override
    public UriInfo getUriInfo() {
        return uriInfo;
    }

    @Override
    public ResourceInfo getResourceInfo() {
        return resourceInfo;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
