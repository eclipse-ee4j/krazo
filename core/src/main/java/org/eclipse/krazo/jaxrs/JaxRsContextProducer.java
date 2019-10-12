/*
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
package org.eclipse.krazo.jaxrs;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriInfo;
import java.util.Objects;

/**
 * CDI producer for JAX-RS context objects
 *
 * @author Christian Kaltepoth
 */
@RequestScoped
public class JaxRsContextProducer {

    private Configuration configuration;

    private HttpServletRequest request;

    private HttpServletResponse response;

    private Application application;

    private UriInfo uriInfo;

    private ResourceInfo resourceInfo;

    @Produces
    @JaxRsContext
    @RequestScoped
    public Configuration produceConfiguration() {
        return Objects.requireNonNull(configuration, "Cannot produce Configuration");
    }

    @Produces
    @JaxRsContext
    @RequestScoped
    public HttpServletRequest produceHttpServletRequest() {
        return Objects.requireNonNull(request, "Cannot produce HttpServletRequest");
    }

    @Produces
    @JaxRsContext
    @RequestScoped
    public HttpServletResponse produceHttpServletResponse() {
        return Objects.requireNonNull(response, "Cannot produce HttpServletResponse");
    }

    @Produces
    @JaxRsContext
    @RequestScoped
    public Application produceApplication() {
        return Objects.requireNonNull(application, "Cannot produce Application");
    }

    @Produces
    @JaxRsContext
    @RequestScoped
    public UriInfo produceUriInfo() {
        return Objects.requireNonNull(uriInfo, "Cannot produce UriInfo");
    }

    @Produces
    @JaxRsContext
    @RequestScoped
    public ResourceInfo produceResourceInfo() {
        return Objects.requireNonNull(resourceInfo, "Cannot produce ResourceInfo");
    }

    void setConfiguration(Configuration configuration) {
        this.configuration = Objects.requireNonNull(configuration, "Configuration must not be null");
    }

    void setRequest(HttpServletRequest request) {
        this.request = Objects.requireNonNull(request, "Request must not be null");
    }

    void setResponse(HttpServletResponse response) {
        this.response = Objects.requireNonNull(response, "Response must not be null");
    }

    void setApplication(Application application) {
        this.application = Objects.requireNonNull(application, "Application must not be null");
    }

    void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = Objects.requireNonNull(uriInfo, "UriInfo must not be null");
    }

    void setResourceInfo(ResourceInfo resourceInfo) {
        this.resourceInfo = Objects.requireNonNull(resourceInfo, "ResourceInfo must not be null");
    }
    
}
