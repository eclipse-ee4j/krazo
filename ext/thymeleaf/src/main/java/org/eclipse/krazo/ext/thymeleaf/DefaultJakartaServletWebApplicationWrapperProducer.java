/*
 * Copyright (c) 2022 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.ext.thymeleaf;

import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultJakartaServletWebApplicationWrapperProducer {

    @Inject
    private HttpServletRequest request;

    @Produces
    @ApplicationScoped
    public JakartaServletWebApplicationWrapper getJakartaServletWebApplicationWrapper() {
        return new JakartaServletWebApplicationWrapper() {
            private final JakartaServletWebApplication application = create();

            @Override
            public JakartaServletWebApplication get() {
                return application;
            }

            private JakartaServletWebApplication create() {
                final ServletContext servletContext = request.getServletContext();
                return JakartaServletWebApplication.buildApplication(servletContext);
            }
        };
    }

}
