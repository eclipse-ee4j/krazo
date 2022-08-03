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
package org.eclipse.krazo.jaxrs;

import jakarta.inject.Inject;
import jakarta.interceptor.Interceptor;
import org.eclipse.krazo.lifecycle.RequestLifecycle;
import org.eclipse.krazo.util.CdiUtils;

import jakarta.annotation.Priority;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

/**
 * Pre-Matching ContainerRequestFilter
 *
 * @author Christian Kaltepoth
 */
@PreMatching
@Priority(Interceptor.Priority.PLATFORM_BEFORE) // very early
public class PreMatchingRequestFilter implements ContainerRequestFilter {

    @Context
    private Configuration configuration;

    @Inject
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @Context
    private Application application;

    @Context
    private UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        final JaxRsContextProducer contextProducer = CdiUtils.getApplicationBean(JaxRsContextProducer.class)
                .orElseThrow(() -> new IllegalStateException("Cannot find CDI managed JaxRsContextProducer"));

        // store JAX-RS context objects so we can produce them via CDI
        contextProducer.setConfiguration(configuration);
        contextProducer.setResponse(response);
        contextProducer.setApplication(application);
        contextProducer.setUriInfo(uriInfo);

        // notify RequestLifecycle
        CdiUtils.getApplicationBean(RequestLifecycle.class)
                .orElseThrow(() -> new IllegalStateException("Failed to lookup RequestLifecycle"))
                .beforeAll(requestContext);

    }

}
