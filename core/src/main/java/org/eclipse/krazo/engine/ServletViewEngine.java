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
package org.eclipse.krazo.engine;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.engine.ViewEngineContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * Base class for servlet-based view engines like JSPs and Facelets. Implements
 * a forward mechanism that attempts to avoid the standard servlet matching by
 * first looking at servlets that handle the specified extensions directly.
 *
 * @author Santiago Pericas-Geertsen
 */
public abstract class ServletViewEngine extends ViewEngineBase {

    @Inject
    protected ServletContext servletContext;

    /**
     * <p>Forwards request to servlet container. Search for a servlet by matching
     * the supplied extensions; if that fails, execute a normal forward via
     * servlet matching.</p>
     *
     * <p>Note that if the MVC application overrides the root context by setting the
     * application path to "/" or "/*", then a forward will result in an infinite
     * recursion because the servlet container will forward the request back to MVC
     * (or JAX-RS). Thus, it is important to try to find the servlet using extensions
     * first instead of matching.</p>
     *
     * @param context view engine context.
     * @param extensions list of extensions that need to match.
     * @throws ServletException if there is an error with the forward.
     * @throws IOException if there is an I/O error.
     */
    protected void forwardRequest(ViewEngineContext context, String... extensions)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        HttpServletRequest request = context.getRequest(HttpServletRequest.class);
        final HttpServletResponse response = context.getResponse(HttpServletResponse.class);

        // Set attributes in request before forward
        final Models models = context.getModels();
        for (String name : models) {
            request.setAttribute(name, models.get(name));
        }

        // Find request dispatcher based on extensions
        for (Map.Entry<String, ? extends ServletRegistration> e : servletContext.getServletRegistrations().entrySet()) {
            final Collection<String> mappings = e.getValue().getMappings();
            // the 'mappings' collection may be null on Liberty (see #200)
            if (mappings != null && mappings.containsAll(Arrays.asList(extensions))) {
                rd = servletContext.getNamedDispatcher(e.getKey());     // by servlet name

                // Need new request with updated URI and extension matching semantics
                request = new HttpServletRequestWrapper(context.getRequest(HttpServletRequest.class)) {
                    @Override
                    public String getRequestURI() {
                        return resolveView(context);
                    }

                    @Override
                    public String getServletPath() {
                        return resolveView(context);
                    }

                    @Override
                    public String getPathInfo() {
                        return null;
                    }

                    @Override
                    public StringBuffer getRequestURL() {
                        return new StringBuffer(getRequestURI());
                    }
                };
                break;
            }
        }

        // If none found, go through servlet mapping
        if (rd == null) {
            rd = servletContext.getRequestDispatcher(resolveView(context));
        }

        /*
         * The RequestDispatcher contract requires us to pass in the original request/response
         * instances or standard wrapper classes. As we get the request/response from JAX-RS,
         * we cannot assume that we get the "original" request/response. So we use wrapper classes
         * for the forward.
         */
        rd.forward(new HttpServletRequestWrapper(request), new HttpServletResponseWrapper(response));
        
    }
}
