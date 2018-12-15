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
package org.eclipse.krazo.test.annotations;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("annotations")
public class AnnotationsController extends BaseController implements BaseInterface {

    /**
     * Should inherit @GET, @Controller and @Path("no_view") from BaseController.
     */
    @Override
    public String method() {
        return "success.jsp";
    }

    /**
     * Should inherit @GET @Controller @Path("view") @View("success.jsp")
     * from BaseController.
     */
    @Override
    public void methodWithView() {
    }

    /**
     * Should inherit @GET @Controller @Path("view_interface") @View("success.jsp")
     * from BaseInterface.
     */
    @Override
    public void methodWithViewInterface() {
    }

    /**
     * Should not inherit @View because it defines JAX-RS annotations.
     */
    @GET
    @Path("no_override_jaxrs")
    @Override
    public void methodNoOverrideJaxrs() {
    }

    /**
     * Should not inherit @View because it defines MVC annotations.
     */
    @Controller
    @Override
    public void methodNoOverrideMvc() {
    }
}
