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

import org.eclipse.krazo.engine.ViewEngineBase;
import org.eclipse.krazo.engine.ViewEngineConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import jakarta.mvc.engine.ViewEngine;
import jakarta.mvc.engine.ViewEngineContext;
import jakarta.mvc.engine.ViewEngineException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Thymeleaf ViewEngine.
 *
 * @author Rodrigo Turini
 * @author Gregor Tudan
 */
@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class ThymeleafViewEngine extends ViewEngineBase {

    @Inject
    private JakartaServletWebApplicationWrapper applicationWrapper;

    @Inject
    private BeanManager beanManager;

    @Inject
    @ViewEngineConfig
    private TemplateEngine engine;

    @Override
    public boolean supports(String view) {
        return view.endsWith(".html");
    }

    @Override
    public void processView(ViewEngineContext context) throws ViewEngineException {
        try {
            HttpServletRequest request = context.getRequest(HttpServletRequest.class);
            HttpServletResponse response = context.getResponse(HttpServletResponse.class);

            JakartaServletWebApplication servletApplication = applicationWrapper.get();
            IWebExchange exchange = servletApplication.buildExchange(request, response);

            CDIWebContext ctx = new CDIWebContext(beanManager, exchange, context.getLocale());

            Map<String, Object> model = new HashMap<>(context.getModels().asMap());
            model.put("request", request);
            ctx.setVariables(model);

            try {
                engine.process(resolveView(context), ctx, response.getWriter());
                response.flushBuffer();
            } finally {
                ctx.close();
            }
        } catch (IOException e) {
            throw new ViewEngineException(e);
        }
    }

}
