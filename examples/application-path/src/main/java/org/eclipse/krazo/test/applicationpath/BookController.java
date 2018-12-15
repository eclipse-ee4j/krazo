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
package org.eclipse.krazo.test.applicationpath;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * BookController test.
 *
 * @author Santiago Pericas-Geertsen
 */
@Path("book")
@Controller
public class BookController {

    @Inject
    private Catalog catalog;

    @Inject
    private Models models;

    @GET
    @Produces("text/html")
    @Path("view1/{id}")
    public String view1(@PathParam("id") String id) {
        models.put("book", catalog.getBook(id));
        return "book.xhtml";
    }

    @GET
    @Produces("text/html")
    @Path("view2/{id}")
    @View("book.xhtml")
    public void view2(@PathParam("id") String id) {
        models.put("book", catalog.getBook(id));
    }

    @GET
    @Produces("text/html")
    @Path("view3/{id}")
    public String view3(@PathParam("id") String id) {
        models.put("book", catalog.getBook(id));
        return "book.jsp";
    }

    @GET
    @Produces("text/html")
    @Path("view4/{id}")
    @View("book.jsp")
    public void view4(@PathParam("id") String id) {
        models.put("book", catalog.getBook(id));
    }
}
