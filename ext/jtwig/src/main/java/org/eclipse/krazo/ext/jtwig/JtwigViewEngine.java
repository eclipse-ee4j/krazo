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
package org.eclipse.krazo.ext.jtwig;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jtwig.web.servlet.JtwigRenderer;
import org.eclipse.krazo.engine.ViewEngineBase;

/**
 * @author Daniel Dias
 */
@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class JtwigViewEngine extends ViewEngineBase {

    private JtwigRenderer jtwigRenderer;

    @PostConstruct
    public void init() {
        jtwigRenderer = JtwigRenderer.defaultRenderer();
    }

    public boolean supports(String view) {
        return view.endsWith(".twig.html") || view.endsWith(".twig");
	}

    public void processView(ViewEngineContext context) throws ViewEngineException {

        try {

            Map<String, Object> model = new HashMap<>(context.getModels().asMap());
            model.put("request", context.getRequest(HttpServletRequest.class));

            HttpServletRequest request = context.getRequest(HttpServletRequest.class);
            HttpServletResponse response = context.getResponse(HttpServletResponse.class);

            jtwigRenderer.dispatcherFor(resolveView(context)).with(model).render(request,response);

        } catch (ServletException | IOException e) {
            throw new ViewEngineException(e);
		}
    }
}