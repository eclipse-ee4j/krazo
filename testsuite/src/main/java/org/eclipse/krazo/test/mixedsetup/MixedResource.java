/*
 * Copyright (c) 2018, 2022 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.test.mixedsetup;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.binding.BindingResult;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/mixed")
public class MixedResource {

    @Inject
    TodoHolder holder;

    @Inject
    Models models;

    @Inject
    BindingResult bindingResult;

    @GET
    @Controller
    @Produces(MediaType.TEXT_HTML)
    public String indexMvc() {
        models.put("todos", holder.getTodos());
        return "index.jsp";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response indexApi() {
        return Response.ok(holder.getTodos()).build();
    }

    @POST
    @UriRef("create")
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createMvc(@Valid @BeanParam TodoForm form) {
        if (bindingResult.isFailed()) {
            models.put("validationPerformed", true);
            return "index.jsp";
        }

        holder.addTodo(Todo.fromForm(form));

        return "redirect:/mixed";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createApi(@Valid Todo todo) {

        holder.addTodo(todo);

        return Response.noContent().build();
    }
}
