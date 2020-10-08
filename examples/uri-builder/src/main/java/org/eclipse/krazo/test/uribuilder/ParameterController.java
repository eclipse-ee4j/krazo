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
package org.eclipse.krazo.test.uribuilder;

import jakarta.mvc.Controller;
import jakarta.mvc.UriRef;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

/**
 * @author Florian Hirsch
 */
@Controller
@Path("parameters")
public class ParameterController {

    @GET
    @Path("path/{p1}/{p2}")
    @UriRef("path-params")
    public String pathParams(@PathParam("p1") String p1, @PathParam("p2") long p2) {
        return "uri-builder.jsp";
    }

    @GET
    @Path("query")
    @UriRef("query-params")
    public String queryParams(@QueryParam("q1") String q1, @QueryParam("q2") long q2) {
        return "uri-builder.jsp";
    }

    @GET
    @Path("matrix")
    @UriRef("matrix-params")
    public String matrixParams(@MatrixParam("m1") String m1, @MatrixParam("m2") long m2) {
        return "uri-builder.jsp";
    }

    @GET
    @Path("bean/{p}")
    @UriRef("bean-params")
    public String beanParams(@BeanParam BeanParams params) {
        return "uri-builder.jsp";
    }

    static class BeanParams {

        @PathParam("p")
        private String p;

        @QueryParam("q")
        private String q;

        @MatrixParam("m")
        private long m;

    }

}
