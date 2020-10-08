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
package org.eclipse.krazo.test.csrf.methods;

import jakarta.mvc.Controller;
import jakarta.mvc.UriRef;
import jakarta.mvc.View;
import jakarta.mvc.security.CsrfProtected;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path("csrf-methods")
@Controller
public class CsrfHiddenMethodController {

    @GET
    @Path("exception-delete")
    public String getExceptionDeleteForm() {
        return "csrf-exception-delete.jsp";
    }

    @GET
    @Path("exception-patch")
    public String getExceptionPatchForm() {
        return "csrf-exception-patch.jsp";
    }

    @GET
    @Path("exception-post")
    public String getExceptionPostForm() {
        return "csrf-exception-post.jsp";
    }

    @GET
    @Path("exception-put")
    public String getExceptionPutForm() {
        return "csrf-exception-put.jsp";
    }

    @GET
    @Path("ok-delete")
    public String getOkDeleteForm() {
        return "csrf-ok-delete.jsp";
    }

    @GET
    @Path("ok-patch")
    public String getOkPatchForm() {
        return "csrf-ok-patch.jsp";
    }

    @GET
    @Path("ok-post")
    public String getOkPostForm() {
        return "csrf-ok-post.jsp";
    }

    @GET
    @Path("ok-put")
    public String getOkPutForm() {
        return "csrf-ok-put.jsp";
    }

    @GET
    @Path("ok")
    @View("ok.jsp")
    public void getOk() {
    }

    @POST
    @CsrfProtected
    @UriRef("doPost")
    public String doPost() {
        return "redirect:/csrf-methods/ok";
    }

    @PUT
    @CsrfProtected
    @UriRef("doPut")
    public String doPut() {
        return "redirect:/csrf-methods/ok";
    }

    @PATCH
    @CsrfProtected
    @UriRef("doPatch")
    public String doPatch() {
        return "redirect:/csrf-methods/ok";
    }

    @DELETE
    @CsrfProtected
    @UriRef("doDelete")
    public String doDelete() {
        return "redirect:/csrf-methods/ok";
    }
}
