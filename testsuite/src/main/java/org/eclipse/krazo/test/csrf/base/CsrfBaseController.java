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
package org.eclipse.krazo.test.csrf.base;

import javax.mvc.Controller;
import javax.mvc.security.CsrfProtected;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * CsrfController test.
 *
 * @author Santiago Pericas-Geertsen
 */
@Path("csrf")
@Controller
public class CsrfBaseController {

    @GET
    public String getForm() {
        return "csrf.jsp";
    }

    @POST
    @CsrfProtected
    public String postForm(@FormParam("greeting") String greeting) {
        return "redirect:/csrf/ok";
    }

    @GET
    @Path("ok")
    @View("ok.jsp")
    public void getOk() {
    }
}
