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
package org.eclipse.krazo.ext.thymeleaf;

import org.eclipse.krazo.engine.ViewEngineBase;
import org.eclipse.krazo.engine.ViewEngineConfig;
import org.thymeleaf.TemplateEngine;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private ServletContext servletContext;

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

            CDIWebContext ctx = new CDIWebContext(beanManager, request, response, servletContext, context.getLocale());

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
