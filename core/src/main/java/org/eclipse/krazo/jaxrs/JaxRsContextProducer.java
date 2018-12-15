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
package org.eclipse.krazo.jaxrs;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    protected void populate(Configuration configuration, HttpServletRequest request, HttpServletResponse response, Application application, UriInfo uriInfo) {
        this.configuration = Objects.requireNonNull(configuration, "Configuration is required");
        this.request = Objects.requireNonNull(request, "HttpServletRequest is required");
        this.response = Objects.requireNonNull(response, "Configuration is required");
        this.application = Objects.requireNonNull(application, "Application is required");
        this.uriInfo = Objects.requireNonNull(uriInfo, "UriInfo is required");
    }

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

}
