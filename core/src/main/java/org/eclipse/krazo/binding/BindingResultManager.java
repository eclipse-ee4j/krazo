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
package org.eclipse.krazo.binding;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class manages the lifecycle of BindingResultImpl. Especially it observes the
 * disposal of the current instance so it can warn the user about unconsumed errors.
 *
 * @author Christian Kaltepoth
 */
@RequestScoped
public class BindingResultManager {

    private static final Logger log = Logger.getLogger(BindingResultImpl.class.getName());

    @Inject
    private HttpServletRequest request;

    @Produces
    @RequestScoped
    public BindingResultImpl createBindingResult() {
        return new BindingResultImpl();
    }

    public void destroyBindingResult(@Disposes BindingResultImpl bindingResult) {

        if (bindingResult.hasUnconsumedErrors()) {

            log.log(Level.WARNING,
                "The request [{0}] produced binding or validation errors but BindingResult was not consumed. " +
                    "This usually means that you forgot to check BindingResult for errors.",
                new Object[]{request.getRequestURI()}
            );

        }


    }


}
