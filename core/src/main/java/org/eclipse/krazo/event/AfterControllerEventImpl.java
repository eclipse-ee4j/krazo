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
package org.eclipse.krazo.event;

import javax.enterprise.context.Dependent;
import javax.mvc.event.AfterControllerEvent;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.UriInfo;

/**
 * An implementation of {@link javax.mvc.event.AfterControllerEvent}.
 *
 * @author Santiago Pericas-Geertsen
 */
@Dependent
public class AfterControllerEventImpl implements AfterControllerEvent {

    private UriInfo uriInfo;

    private ResourceInfo resourceInfo;

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
