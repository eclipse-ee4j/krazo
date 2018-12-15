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
package org.eclipse.krazo.ext.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.eclipse.krazo.engine.ViewEngineBase;
import org.eclipse.krazo.engine.ViewEngineConfig;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Class VelocityViewEngine.
 *
 * @author Rodrigo Turini
 */
@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class VelocityViewEngine extends ViewEngineBase {

    @Inject
    @ViewEngineConfig
    private VelocityEngine velocityEngine;

    @Override
    public boolean supports(String view) {
        return view.endsWith(".vm") || view.endsWith(".vhtml");
    }

    @Override
    public void processView(ViewEngineContext context) throws ViewEngineException {
        
        Charset charset = resolveCharsetAndSetContentType(context);
        
        try (Writer writer = new OutputStreamWriter(context.getOutputStream(), charset)) {
            
            Template template = velocityEngine.getTemplate(resolveView(context));

            Map<String, Object> model = new HashMap<>(context.getModels().asMap());
            model.put("request", context.getRequest(HttpServletRequest.class));
            VelocityContext velocityContext = new VelocityContext(model);
            
            template.merge(velocityContext, writer);
            
        } catch (IOException e) {
            throw new ViewEngineException(e);
        }
    }
}
