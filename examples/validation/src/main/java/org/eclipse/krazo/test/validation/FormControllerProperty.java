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
package org.eclipse.krazo.test.validation;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ValidationError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.OK;

/**
 * FormController class. Defines ValidationResult as a property inherited
 * from a base class.
 *
 * @author Santiago Pericas-Geertsen
 */
@Controller
@Path("formprop")
@Produces("text/html")
public class FormControllerProperty extends FormControllerBase {

    @Inject
    private ErrorDataBean error;

    @POST
    public Response formPost(@Valid @BeanParam FormDataBean form) {
        final BindingResult vr = getVr();
        if (vr.isFailed()) {
            ValidationError validationError = (ValidationError) vr.getAllErrors().iterator().next();
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
}
