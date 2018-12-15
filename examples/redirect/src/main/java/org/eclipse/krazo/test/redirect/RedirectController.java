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
package org.eclipse.krazo.test.redirect;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.mvc.Controller;
import javax.mvc.event.ControllerRedirectEvent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
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
