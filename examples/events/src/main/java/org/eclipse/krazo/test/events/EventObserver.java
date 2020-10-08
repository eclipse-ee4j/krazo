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
package org.eclipse.krazo.test.events;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.mvc.event.AfterControllerEvent;
import jakarta.mvc.event.AfterProcessViewEvent;
import jakarta.mvc.event.BeforeControllerEvent;
import jakarta.mvc.event.BeforeProcessViewEvent;
import jakarta.ws.rs.WebApplicationException;

/**
 * Class EventObserver.
 *
 * @author Santiago Pericas-Geertsen
 */
@ApplicationScoped
public class EventObserver {

    @Inject
    private EventBean eventBean;

    public void beforeControllerEvent(@Observes BeforeControllerEvent event) {
        eventBean.setBeforeControllerEvent(event);
    }

    public void afterControllerEvent(@Observes AfterControllerEvent event) {
        if (eventBean.getBeforeControllerEvent() == null) {
            throw new WebApplicationException("BeforeController event not fired?");
        }
        eventBean.setAfterControllerEvent(event);
    }

    public void beforeProcessViewEvent(@Observes BeforeProcessViewEvent event) {
        if (eventBean.getAfterControllerEvent() == null) {
            throw new WebApplicationException("AfterController event not fired?");
        }
        eventBean.setBeforeProcessViewEvent(event);
    }

    public void afterProcessViewEvent(@Observes AfterProcessViewEvent event) {
        if (eventBean.getBeforeProcessViewEvent() == null) {
            throw new WebApplicationException("AfterController event not fired?");
        }
        // Too late for view to render this event
    }
}
