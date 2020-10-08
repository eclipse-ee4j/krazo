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
package org.eclipse.krazo.test.ext.jade;

import jakarta.inject.Inject;
import jakarta.mvc.Models;
import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

/**
 * @author Florian Hirsch
 */
@Path("/")
@Controller
public class JadeController {

    @Inject
    private Models models;

    @GET
    @Controller
    @View("main.jade")
    public void get(@QueryParam("user") String user) {
        models.put("user", user);
        models.put("pageName", "Hello Jade");
    }

    @GET
    @Path("/markdown")
    @Controller
    @View("markdown.jade")
    public void getMarkdownd(@QueryParam("article") String article) {
        models.put("pageName", "Markdown Introduction");
    }

    @GET
    @Path("/config")
    @Controller
    @View("config.jade")
    public void getCofig(@QueryParam("article") String article) {
        models.put("pageName", "Configuration");
    }

    @GET
    @Path("/helper")
    @Controller
    @View("helper.jade")
    public void getCofig() {
        models.put("pageName", "Helper");
    }
}
