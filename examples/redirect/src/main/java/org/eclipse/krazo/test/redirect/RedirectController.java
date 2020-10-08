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
package org.eclipse.krazo.test.redirect;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.mvc.Controller;
import jakarta.mvc.event.ControllerRedirectEvent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.net.URI;

/**
 * RedirectController test.
 *
 * @author Santiago Pericas-Geertsen
 */
@Path("redirect")
@Controller
@ApplicationScoped
public class RedirectController {

    private boolean eventReceived;

    @GET
    @Path("string")
    public String getString() {
        eventReceived = false;
        return "redirect:/redirect/here";
    }

    @GET
    @Path("response1")
    public Response getResponse1() {
        eventReceived = false;
        return Response.seeOther(URI.create("redirect/here")).build();
    }

    @GET
    @Path("response2")
    public Response getResponse2() {
        eventReceived = false;
        return Response.status(Response.Status.FOUND)
                .header("Location", "redirect/here")
                .build();
    }

    @GET
    @Path("here")
    @Produces("text/html")
    public String getSub() {
        return eventReceived ? "redirect.jsp" : "error.jsp";
    }

    public void beforeControllerEvent(@Observes ControllerRedirectEvent event) {
        eventReceived = true;
    }
}
