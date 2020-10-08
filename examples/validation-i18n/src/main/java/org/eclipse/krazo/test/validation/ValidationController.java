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
import jakarta.mvc.Models;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Christian Kaltepoth
 */
@Controller
@Path("validation")
public class ValidationController {

    @Inject
    private Models models;

    @Inject
    private BindingResult bindingResult;

    @GET
    public String get() {
        return "form.jsp";
    }

    @POST
    public String post(@Valid @BeanParam FormBean form) {

        if (bindingResult.isFailed()) {

            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(ParamError::getMessage)
                    .collect(Collectors.toList());

            models.put("errors", errors);

        }

        return "form.jsp";

    }

}
