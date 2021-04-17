/*
 * Copyright (c) 2019 Eclipse Krazo committers and contributors
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

import jakarta.annotation.Priority;
import jakarta.mvc.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

/**
 * Post-Matching ContainerRequestFilter
 *
 * @author Christian Kaltepoth
 */
@Controller
@Priority(0) // very early
public class PostMatchingRequestFilter implements ContainerRequestFilter {

    @Context
    private Configuration configuration;

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @Context
    private Application application;

    @Context
    private UriInfo uriInfo;

    @Context
    private ResourceInfo resourceInfo;

    @Context
    private JaxRsContextProducer contextProducer;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        // store JAX-RS context objects so we can produce them via CDI
        contextProducer.setConfiguration(configuration);
        contextProducer.setRequest(request);
        contextProducer.setResponse(response);
        contextProducer.setApplication(application);
        contextProducer.setUriInfo(uriInfo);
        contextProducer.setResourceInfo(resourceInfo);

    }

}
