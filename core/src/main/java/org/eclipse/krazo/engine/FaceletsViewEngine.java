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
package org.eclipse.krazo.engine;

import jakarta.annotation.Priority;
import jakarta.mvc.engine.ViewEngine;
import jakarta.mvc.engine.ViewEngineContext;
import jakarta.mvc.engine.ViewEngineException;
import jakarta.servlet.ServletException;
import java.io.IOException;

/**
 * Implementation of the JSF Facelets engine. Uses a method in its base class to forward
 * a request back to the servlet container.
 *
 * @author Manfred Riem
 * @author Santiago Pericas-Geertsen
 * @see ViewEngineBase#resolveView(jakarta.mvc.engine.ViewEngineContext)
 */
@Priority(ViewEngine.PRIORITY_BUILTIN)
public class FaceletsViewEngine extends ServletViewEngine {

    /**
     * Assumes that any view that ends with {@code .xhtml} is a facelet.
     *
     * @param view the name of the view.
     * @return {@code true} if supported or {@code false} if not.
     */
    @Override
    public boolean supports(String view) {
        return view.endsWith(".xhtml");
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
            forwardRequest(context, "*.xhtml");
        } catch (ServletException | IOException e) {
            throw new ViewEngineException(e);
        }
    }
}
