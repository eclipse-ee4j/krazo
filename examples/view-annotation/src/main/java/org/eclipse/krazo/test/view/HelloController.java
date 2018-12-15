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
package org.eclipse.krazo.test.view;

import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Tests uses of {@code View} annotation with void and non-void methods. If a method
 * decorated with {@code View} returns {@code null}, the value in {@code View} should
 * be used.
 *
 * @author Santiago Pericas-Geertsen
 */
@Path("/")
@Controller
@View("hello.jsp")
public class HelloController {

    /**
     * Void method with @View annotation. View 'hello.jsp' should be rendered.
     */
    @GET
    @Path("void")
    @View("hello.jsp")
    public void voidController() {
    }

    /**
     * Method that overrides the @View annotation. View 'bye.jsp' should be
     * rendered.
     *
     * @return View to render.
     */
    @GET
    @Path("string")
    @View("hello.jsp")
    public String byeController() {
        return "bye.jsp";
    }

    /**
     * Method that returns a null value. View 'hello.jsp' should be rendered.
     *
     * @return View to render.
     */
    @GET
    @Path("null")
    @View("hello.jsp")
    public String nullController() {
        return null;
    }

    /**
     * Void method with @View annotation from class. View 'hello.jsp' should be
     * rendered.
     */
    @GET
    @Path("class/void")
    public void voidControllerClass() {
    }

    /**
     * Method that overrides the @View annotation from class. View 'bye.jsp' should
     * be rendered.
     *
     * @return View to render.
     */
    @GET
    @Path("class/string")
    public String byeControllerClass() {
        return "bye.jsp";
    }

    /**
     * Method that returns a null value. View 'hello.jsp' from class should be rendered.
     *
     * @return View to render.
     */
    @GET
    @Path("class/null")
    public String nullControllerClass() {
        return null;
    }

    /**
     * Void method that throws a ForbiddenException. View 'hello.jsp' should be rendered.
     */
    @GET
    @Path("void/forbidden")
    @View("hello.jsp")
    public void voidForbiddenException() {
        throw new ForbiddenException();
    }

    /**
     * Void method that throws a IllegalArgumentException. Error page defined in web.xml should be rendered.
     */
    @GET
    @Path("void/illegal-argument")
    @View("hello.jsp")
    public void voidIllegalArgumentException() {
        throw new IllegalArgumentException("the general error page should be displayed");
    }

    /**
     * Method that throws a ForbiddenException. View 'hello.jsp' should be rendered.
     */
    @GET
    @Path("string/forbidden")
    @View("hello.jsp")
    public String stringForbiddenException() {
        throw new ForbiddenException();
    }

    /**
     * Method that throws a IllegalArgumentException. Error page defined in web.xml should be rendered.
     */
    @GET
    @Path("string/illegal-argument")
    @View("hello.jsp")
    public String stringIllegalArgumentException() {
        throw new IllegalArgumentException("the general error page should be displayed");
    }

}
