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
package org.eclipse.krazo.test.encoding;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Florian Hirsch
 */
@Controller
@Path("encoding")
public class EncodingController {

    @GET
    @Path("jsp/iso-8859-15")
    public String jsp_iso_8859_15() {
        return "iso-8859-15.jsp";
    }

    @GET
    @Path("jsp/iso-8859-15-text-html")
    @Produces("text/html")
    public String jsp_iso_8859_15_text_html() {
        return "iso-8859-15.jsp";
    }

    @GET
    @Path("jsp/iso-8859-15-text-html-charset-utf-8")
    @Produces("text/html; charset=utf-8")
    public String jsp_iso_8859_15_text_html_charset_utf_8() {
        return "iso-8859-15.jsp";
    }

    @GET
    @Path("facelets/iso-8859-15")
    public String facelets_iso_8859_15() {
        return "iso-8859-15.xhtml";
    }

    @GET
    @Path("facelets/iso-8859-15-text-html")
    @Produces("text/html")
    public String facelets_iso_8859_15_text_html() {
        return "iso-8859-15.xhtml";
    }

    @GET
    @Path("facelets/iso-8859-15-text-html-charset-utf-8")
    @Produces("text/html; charset=utf-8")
    public String facelets_iso_8859_15_text_html_charset_utf_8() {
        return "iso-8859-15.xhtml";
    }
}
