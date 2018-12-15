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
package org.eclipse.krazo.test.validation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.binding.BindingResult;
import javax.mvc.binding.ParamError;
import javax.mvc.binding.ValidationError;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * FormController class. Defines BindingResult as injectable field.
 *
 * @author Santiago Pericas-Geertsen
 */
@Path("form")
@Produces("text/html")
@RequestScoped
public class FormController {

    @Inject
    private BindingResult br;

    @Inject
    private ErrorDataBean error;

    @POST
    @Controller
    public Response formPost(@Valid @BeanParam FormDataBean form) {
        if (br.isFailed()) {
            ValidationError validationError = (ValidationError) br.getAllErrors().iterator().next();
            final ConstraintViolation<?> cv = validationError.getViolation();
            final String property = cv.getPropertyPath().toString();
            error.setProperty(property.substring(property.lastIndexOf('.') + 1));
            error.setValue(cv.getInvalidValue());
            error.setMessage(cv.getMessage());
            error.setParam(validationError.getParamName());
            return Response.status(BAD_REQUEST).entity("error.jsp").build();
        }
        return Response.status(OK).entity("data.jsp").build();
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
