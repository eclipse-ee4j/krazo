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
package org.eclipse.krazo.test.annotations;

import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * Class BaseInterface.
 *
 * @author Santiago Pericas-Geertsen
 */
public interface BaseInterface {

    @GET
    @Controller
    @Path("view")
    @View("error.jsp")
    public void methodWithView();

    @GET
    @Controller
    @Path("no_override")
    @View("error.jsp")
    public void methodNoOverrideJaxrs();

    @GET
    @Controller
    @Path("no_override")
    @View("error.jsp")
    public void methodNoOverrideMvc();

    @GET
    @Controller
    @Path("view_interface")
    @View("success.jsp")
    public void methodWithViewInterface();
}
