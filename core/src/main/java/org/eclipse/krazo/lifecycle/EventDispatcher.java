/*
 * Copyright © 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.lifecycle;

import org.eclipse.krazo.cdi.KrazoCdiExtension;
import org.eclipse.krazo.event.AfterControllerEventImpl;
import org.eclipse.krazo.event.BeforeControllerEventImpl;
import org.eclipse.krazo.jaxrs.JaxRsContext;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.BeforeControllerEvent;
import javax.mvc.event.MvcEvent;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.UriInfo;

import static org.eclipse.krazo.cdi.KrazoCdiExtension.isEventObserved;

public class EventDispatcher {

    @Inject
    @JaxRsContext
    private UriInfo uriInfo;

    @Inject
    @JaxRsContext
    private ResourceInfo resourceInfo;

    @Inject
    private Event<MvcEvent> mvcEventDispatcher;

    void fireBeforeControllerEvent() {
        if (KrazoCdiExtension.isEventObserved(BeforeControllerEvent.class)) {
            final BeforeControllerEventImpl event = new BeforeControllerEventImpl();
            event.setUriInfo(uriInfo);
            event.setResourceInfo(resourceInfo);
            mvcEventDispatcher.fire(event);
        }
    }


    void fireAfterControllerEvent() {
        if (isEventObserved(AfterControllerEvent.class)) {
            final AfterControllerEventImpl event = new AfterControllerEventImpl();
            event.setUriInfo(uriInfo);
            event.setResourceInfo(resourceInfo);
            mvcEventDispatcher.fire(event);
        }
    }
}
