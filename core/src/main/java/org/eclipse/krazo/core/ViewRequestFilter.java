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

import org.eclipse.krazo.event.BeforeControllerEventImpl;
import org.eclipse.krazo.cdi.KrazoCdiExtension;

import javax.annotation.Priority;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.event.BeforeControllerEvent;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

/**
 * <p>A JAX-RS request filter that fires a {@link javax.mvc.event.BeforeControllerEvent}
 * after the controller has been matched but before it is called.</p>
 *
 * <p>Given that this filter is annotated with {@link Controller},
 * it will be called before a controller is called. Priority is set to
 * {@link javax.ws.rs.Priorities#ENTITY_CODER} which means it will be executed
 * right before user-defined request filters.</p>
 *
 * @author Santiago Pericas-Geertsen
 */
@Controller
@Priority(Priorities.ENTITY_CODER)
public class ViewRequestFilter implements ContainerRequestFilter {

    @Context
    private UriInfo uriInfo;

    @Context
    private ResourceInfo resourceInfo;

    @Inject
    private Event<BeforeControllerEvent> dispatcher;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Fire BeforeControllerEvent event
        if (KrazoCdiExtension.isEventObserved(BeforeControllerEvent.class)) {
            final BeforeControllerEventImpl event = new BeforeControllerEventImpl();
            event.setUriInfo(uriInfo);
            event.setResourceInfo(resourceInfo);
            event.setContainerRequestContext(requestContext);
            dispatcher.fire(event);
        }
    }
}
