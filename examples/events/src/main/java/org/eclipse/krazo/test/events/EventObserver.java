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
package org.eclipse.krazo.test.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.AfterProcessViewEvent;
import javax.mvc.event.BeforeControllerEvent;
import javax.mvc.event.BeforeProcessViewEvent;
import javax.ws.rs.WebApplicationException;

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
