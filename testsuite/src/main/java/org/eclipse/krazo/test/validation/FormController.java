/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, 2026 Eclipse Krazo committers and contributors
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
import jakarta.mvc.binding.ParamError;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

/**
 * FormController class. Defines BindingResult as an injectable field.
 *
 * @author Santiago Pericas-Geertsen
 * @author Maarten Mulders
 */
@Path("form")
@Produces("text/html")
@RequestScoped
public class FormController {

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
        models.put("action", "form");
        return "form.jsp";
    }

    @POST
    @Controller
    public Response formPost(@Valid @BeanParam FormDataBean form) {
        return FormSubmission.handle(form, br, error, models);
    }

    @GET
    @Controller
    public Response get(@QueryParam("n") @DefaultValue("25") int n) {
        if (br.isFailed()) {
            final ParamError be = br.getErrors("n").iterator().next();
            error.setProperty(be.getParamName());
            error.setMessage(be.getMessage());
            return Response.ok("binderror.jsp").build();
        }
        return Response.ok(Integer.toString(n)).build();
    }
}
