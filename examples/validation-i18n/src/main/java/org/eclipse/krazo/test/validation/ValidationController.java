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

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.binding.BindingResult;
import javax.mvc.binding.ParamError;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
