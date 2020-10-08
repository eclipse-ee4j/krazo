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
package org.eclipse.krazo.test.exceptions;

import org.eclipse.krazo.engine.Viewable;

import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * Tests various exception mapping cases for controllers.
 *
 * @author Santiago Pericas-Geertsen
 */
@Path("exceptions")
@Controller
public class HelloController {

    @GET
    @Path("not_found")
    @View("hello.jsp")
    public void notFound() {
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    @GET
    @Path("not_found_no_view")
    public void notFoundNoView() {
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    @GET
    @Path("internal_error")
    public Response internalError() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("hello.jsp").build();
    }

    @GET
    @Path("internal_error_no_view")
    public Response internalErrorNoView() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
    }

    @GET
    @Path("internal_error_mapped")
    public void internalErrorMapped() {
        throw new ClientErrorException(Response.Status.BAD_REQUEST);
    }

    public static class GlobalExceptionMapper implements ExceptionMapper<ClientErrorException> {
        @Override
        public Response toResponse(ClientErrorException exception) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new Viewable("hello.jsp"))
                .build();
        }
    }
}
