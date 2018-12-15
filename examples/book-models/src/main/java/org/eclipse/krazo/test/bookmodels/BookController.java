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
package org.eclipse.krazo.test.bookmodels;

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
public class BookController {

    /**
     * MVC Framework class used to bind models by name.
     */
    @Inject
    private Models models;

    /**
     * MVC controller to render a book in HTML. Uses the models map to
     * bind a book instance.
     *
     * @param id ID of the book given in URI.
     * @return JSP page used for rendering.
     */
    @GET
    @Controller
    @Produces("text/html")
    @Path("view1/{id}")
    public String view1(@PathParam("id") String id) {
        final Book book = new Book();
        book.setId(id);
        book.setAuthor("Some author");
        book.setTitle("Some title");
        book.setIsbn("Some ISBN");
        models.put("book", book);
        return "book.jsp";      // JSP to render a book
    }

    /**
     * MVC controller to render a book in HTML. Uses the models map to
     * bind a book instance and @View to specify path to view.
     *
     * @param id ID of the book given in URI.
     */
    @GET
    @Controller
    @Produces("text/html")
    @Path("view2/{id}")
    @View("book.jsp")
    public void view2(@PathParam("id") String id) {
        final Book book = new Book();
        book.setId(id);
        book.setAuthor("Some author");
        book.setTitle("Some title");
        book.setIsbn("Some ISBN");
        models.put("book", book);
    }
}
