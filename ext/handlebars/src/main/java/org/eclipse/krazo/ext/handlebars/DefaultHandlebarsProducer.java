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
package org.eclipse.krazo.ext.handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.io.ServletContextTemplateLoader;

import javax.inject.*;
import javax.mvc.engine.ViewEngine;
import javax.servlet.ServletContext;
import org.eclipse.krazo.engine.ViewEngineConfig;
import org.eclipse.krazo.util.*;

import javax.enterprise.inject.Produces;
import javax.ws.rs.core.*;

/**
 * Producer for the Handlebars instance used by HandlebarsViewEngine.
 *
 * @author Christian Kaltepoth
 */
public class DefaultHandlebarsProducer {
    @Context
    private Configuration config;

    @Inject
    private ServletContext servletContext;

    @Produces
    @ViewEngineConfig
    public Handlebars getHandlebars() {
        Handlebars handlebars = new Handlebars();

        // setup TemplateLoader to allow for finding partials
        final String viewFolder = PropertyUtils
            .getProperty(config, ViewEngine.VIEW_FOLDER, ViewEngine.DEFAULT_VIEW_FOLDER);
        handlebars.with(new ServletContextTemplateLoader(servletContext, viewFolder));

        return handlebars;
    }

}
