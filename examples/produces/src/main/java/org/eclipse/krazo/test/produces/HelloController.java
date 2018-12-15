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
package org.eclipse.krazo.test.produces;

import org.eclipse.krazo.engine.Viewable;

import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Locale;

/**
 * HelloController test.
 *
 * @author Santiago Pericas-Geertsen
 */
@Path("/")
@Controller
public class HelloController {

    /**
     * Default content type should be text/html.
     */
    @GET
    @Path("no_produces1")
    public String noProduces1() {
        return "hello.jsp";
    }

    /**
     * Default content type should be text/html when using @View.
     */
    @GET
    @Path("no_produces2")
    @View("hello.jsp")
    public void noProduces2() {
    }

    /**
     * If HTML and XHTML are equally preferred, the latter should be chosen
     * given the lower qs on the former.
     */
    @GET
    @Produces({"text/html;qs=0.9", "application/xhtml+xml"})
    @Path("multiple_produces1")
    public String multipleProduces1() {
        return "hello.jsp";
    }

    /**
     * If HTML and XHTML are equally preferred, the latter should be chosen
     * given the lower qs on the former when using @View.
     */
    @GET
    @Produces({"text/html;qs=0.9", "application/xhtml+xml"})
    @Path("multiple_produces2")
    @View("hello.jsp")
    public void multipleProduces2() {
    }

    /**
     * XHTML type should override static HTML one in @Produces in this case.
     */
    @GET
    @Path("other_produces1")
    @Produces("text/html")      // overridden below
    public Response otherProduces1() {
        return Response.ok(new Viewable("hello.jsp"), "application/xhtml+xml").build();
    }

    /**
     * XHTML type should override static HTML one in @Produces in this case
     * when using @View.
     */
    @GET
    @Path("other_produces2")
    @Produces("text/html")      // overridden below
    @View("hello.jsp")
    public Response otherProduces2() {
        return Response.ok(new Viewable("hello.jsp"), "application/xhtml+xml").build();
    }

    /**
     * Sets language to "es".
     */
    @GET
    @Path("language1")
    @Produces("text/html")      // overridden below
    public Response language1() {
        return Response.ok(new Viewable("hello.jsp"), "application/xhtml+xml").language("es").build();
    }

    /**
     * Sets language to "es" when using @View.
     */
    @GET
    @Path("language2")
    @Produces("text/html")      // overridden below
    @View("hello.jsp")
    public Response language2() {
        return Response.ok(new Viewable("hello.jsp"), "application/xhtml+xml").language("es").build();
    }

    /**
     * Sets locale to UK.
     */
    @GET
    @Path("locale1")
    @Produces("text/html")      // overridden below
    public Response locale1() {
        return Response.ok(new Viewable("hello.jsp"), "application/xhtml+xml").language(Locale.UK).build();
    }

    /**
     * Sets locale to UK when using @View.
     */
    @GET
    @Path("locale2")
    @Produces("text/html")      // overridden below
    @View("hello.jsp")
    public Response locale2() {
        return Response.ok(new Viewable("hello.jsp"), "application/xhtml+xml").language(Locale.UK).build();
    }
}
