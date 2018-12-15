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

import javax.annotation.Priority;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Implementation of the JSP view engine. Uses a method in its base class to forward
 * a request back to the servlet container.
 *
 * @author Santiago Pericas-Geertsen
 * @see ViewEngineBase#resolveView(javax.mvc.engine.ViewEngineContext)
 */
@Priority(ViewEngine.PRIORITY_BUILTIN)
public class JspViewEngine extends ServletViewEngine {

    /**
     * Assumes that any view that ends with {@code .jsp} or {@code .jspx} is a JSP.
     *
     * @param view the name of the view.
     * @return {@code true} if supported or {@code false} if not.
     */
    @Override
    public boolean supports(String view) {
        return view.endsWith(".jsp") || view.endsWith(".jspx");
    }

    /**
     * Forwards request to servlet container.
     *
     * @param context view engine context.
     * @throws ViewEngineException if any error occurs.
     */
    @Override
    public void processView(ViewEngineContext context) throws ViewEngineException {
        try {
            forwardRequest(context, "*.jsp", "*.jspx");
        } catch (ServletException | IOException e) {
            throw new ViewEngineException(e);
        }
    }
}
