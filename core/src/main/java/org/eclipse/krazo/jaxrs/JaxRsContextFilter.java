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
package org.eclipse.krazo.jaxrs;

import org.eclipse.krazo.util.CdiUtils;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

/**
 * This filter is used to get the JAX-RS context objects and feed them to the corresponding
 * CDI producer.
 * <p>
 * This class must not be a CDI bean, because CXF/OWB fails to process <code>@Context</code> in this case.
 *
 * @author Christian Kaltepoth
 */
@PreMatching
@Priority(0) // very early
public class JaxRsContextFilter implements ContainerRequestFilter {

    @Context
    private Configuration configuration;

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @Context
    private Application application;

    @Context
    private UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        /*
         * Please note that we CANNOT inject JaxRsContextProducer here, because this will
         * fail on TomEE/CXF/OWB because processing @Context fails for some reason.
         */
        CdiUtils.getApplicationBean(JaxRsContextProducer.class)
                .orElseThrow(() -> new IllegalStateException("Cannot find CDI managed JaxRsContextProducer"))
                .populate(configuration, request, response, application, uriInfo);

    }

}
