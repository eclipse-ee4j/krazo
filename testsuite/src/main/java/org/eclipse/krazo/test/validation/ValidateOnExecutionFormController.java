/*
 * Copyright (c) 2026 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.test.validation;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.binding.BindingResult;
import jakarta.validation.Valid;
import jakarta.validation.executable.ExecutableType;
import jakarta.validation.executable.ValidateOnExecution;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * Same as {@link FormController}, but opts out of the method validation performed by the
 * Jakarta REST runtime. This is required on runtimes where Krazo cannot do that itself because
 * the runtime doesn't expose its validation SPI to applications, like Open Liberty (#398).
 * Krazo still validates the parameters and reports the violations in {@link BindingResult}.
 */
@Path("validate-on-execution-form")
@Produces("text/html")
@RequestScoped
@ValidateOnExecution(type = ExecutableType.NONE)
public class ValidateOnExecutionFormController {

    @Inject
    private BindingResult br;

    @Inject
    private ErrorDataBean error;

    @Inject
    private Models models;

    @GET
    @Path("new")
    @Controller
    public String showForm() {
        models.put("action", "validate-on-execution-form");
        return "form.jsp";
    }

    @POST
    @Controller
    public Response formPost(@Valid @BeanParam FormDataBean form) {
        return FormSubmission.handle(form, br, error, models);
    }

}
