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

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.mvc.event.AfterControllerEvent;
import jakarta.mvc.event.AfterProcessViewEvent;
import jakarta.mvc.event.BeforeControllerEvent;
import jakarta.mvc.event.BeforeProcessViewEvent;

/**
 * Class EventBean.
 *
 * @author Santiago Pericas-Geertsen
 */
@Named("bean")
@RequestScoped
public class EventBean {

    private BeforeControllerEvent beforeControllerEvent;

    private AfterControllerEvent afterControllerEvent;

    private BeforeProcessViewEvent beforeProcessViewEvent;

    private AfterProcessViewEvent afterProcessViewEvent;

    public BeforeControllerEvent getBeforeControllerEvent() {
        return beforeControllerEvent;
    }

    public void setBeforeControllerEvent(BeforeControllerEvent beforeControllerEvent) {
        this.beforeControllerEvent = beforeControllerEvent;
    }

    public AfterControllerEvent getAfterControllerEvent() {
        return afterControllerEvent;
    }

    public void setAfterControllerEvent(AfterControllerEvent afterControllerEvent) {
        this.afterControllerEvent = afterControllerEvent;
    }

    public BeforeProcessViewEvent getBeforeProcessViewEvent() {
        return beforeProcessViewEvent;
    }

    public void setBeforeProcessViewEvent(BeforeProcessViewEvent beforeProcessViewEvent) {
        this.beforeProcessViewEvent = beforeProcessViewEvent;
    }
}
