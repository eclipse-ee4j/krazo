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
package org.eclipse.krazo.ext.handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.eclipse.krazo.engine.ViewEngineBase;
import org.eclipse.krazo.engine.ViewEngineConfig;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class HandlebarsViewEngine
 *
 * @author Rahman Usta
 */
@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class HandlebarsViewEngine extends ViewEngineBase {

    @Inject
    private ServletContext servletContext;

    @Inject
    @ViewEngineConfig
    private Handlebars handlebars;

    @Override
    public boolean supports(String view) {
        return view.endsWith(".hbs") || view.endsWith(".handlebars");
    }

    @Override
    public void processView(ViewEngineContext context) throws ViewEngineException {

        Map<String, Object> model = new HashMap<>(context.getModels().asMap());
        model.put("request", context.getRequest(HttpServletRequest.class));
        
        Charset charset = resolveCharsetAndSetContentType(context);

        try (Writer writer = new OutputStreamWriter(context.getOutputStream(), charset);
             
            InputStream resourceAsStream = servletContext.getResourceAsStream(resolveView(context));
            InputStreamReader in = new InputStreamReader(resourceAsStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(in);) {

            String viewContent = bufferedReader.lines().collect(Collectors.joining());

            Template template = handlebars.compileInline(viewContent);
            template.apply(model, writer);
            
        } catch (IOException e) {
            throw new ViewEngineException(e);
        }
    }
}
