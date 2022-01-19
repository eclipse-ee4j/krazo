/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, 2022 Eclipse Krazo committers and contributors
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

import org.eclipse.krazo.engine.ViewEngineConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.IServletWebApplication;
import org.thymeleaf.templateresolver.ITemplateResolver;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

/**
 * Producer for the TemplateEngine used by ThymeleafViewEngine.
 *
 * @author Christian Kaltepoth
 * @author Eddú Meléndez
 */
public class DefaultTemplateEngineProducer {

    @Inject
    private JakartaServletWebApplicationWrapper applicationWrapper;

    @Produces
    @ViewEngineConfig
    public TemplateEngine getTemplateEngine() {

        IServletWebApplication servletApplication = applicationWrapper.get();
        ITemplateResolver resolver = new WebApplicationTemplateResolver(servletApplication);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        return engine;

    }

}
