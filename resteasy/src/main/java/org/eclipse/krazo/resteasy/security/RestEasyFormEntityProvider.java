/*
 * Copyright (c) 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.resteasy.security;


import org.eclipse.krazo.security.FormEntityProvider;
import org.eclipse.krazo.util.CdiUtils;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Form;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Reads the form from the Servlet-API using {@link HttpServletRequest#getParameterMap()}
 *
 * <p>RestEasy does not allow resetting the request entity stream using
 * {@link ContainerRequestContext#setEntityStream(InputStream)}. This is a known issue
 * documented in RESTEASY-567</p>*
 *
 * @author Gregor Tudan
 */
@Priority(1000)
public class RestEasyFormEntityProvider implements FormEntityProvider {

    public Form getForm(ContainerRequestContext ctx) {
        final Form form = new Form();

        CdiUtils.getApplicationBean(HttpServletRequest.class).ifPresent(request ->
            request.getParameterMap().forEach((name, values) ->
                Arrays.stream(values).forEach(value -> form.param(name, value))
            ));
        return form;
    }
}
