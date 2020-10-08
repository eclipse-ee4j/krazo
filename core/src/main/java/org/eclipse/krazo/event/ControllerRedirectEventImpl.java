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
package org.eclipse.krazo.event;

import jakarta.enterprise.context.Dependent;
import jakarta.mvc.event.ControllerRedirectEvent;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * An implementation of {@link jakarta.mvc.event.ControllerRedirectEvent}.
 *
 * @author Santiago Pericas-Geertsen
 */
@Dependent
public class ControllerRedirectEventImpl implements ControllerRedirectEvent {

    private UriInfo uriInfo;

    private ResourceInfo resourceInfo;

    private URI location;

    private ContainerRequestContext requestContext;

    private ContainerResponseContext responseContext;

    @Override
    public UriInfo getUriInfo() {
        return uriInfo;
    }

    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    @Override
    public ResourceInfo getResourceInfo() {
        return resourceInfo;
    }

    public void setResourceInfo(ResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override
    public URI getLocation() {
        return location;
    }

    public void setLocation(URI location) {
        this.location = location;
    }

    public ContainerRequestContext getContainerRequestContext() {
        return requestContext;
    }

    public void setContainerRequestContext(ContainerRequestContext requestContext) {
        this.requestContext = requestContext;
    }

    public ContainerResponseContext getContainerResponseContext() {
        return responseContext;
    }

    public void setContainerResponseContext(ContainerResponseContext responseContext) {
        this.responseContext = responseContext;
    }
}
