/*
 * Copyright (c) 2021 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.ext.jinja2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.RenderResult;
import com.hubspot.jinjava.interpret.TemplateError;

import org.eclipse.krazo.engine.ViewEngineBase;
import org.eclipse.krazo.engine.ViewEngineConfig;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.engine.ViewEngine;
import jakarta.mvc.engine.ViewEngineContext;
import jakarta.mvc.engine.ViewEngineException;
import jakarta.servlet.ServletContext;

@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class Jinja2ViewEngine extends ViewEngineBase {

    @Inject
    @ViewEngineConfig
    private Jinjava jinjava;

    @Inject
    private ServletContext servletContext;

    @Override
    public boolean supports(String view) {
        return view.endsWith(".j2") || view.endsWith(".jinja") || view.endsWith(".jinja2");
    }

    @Override
    public void processView(ViewEngineContext context) throws ViewEngineException {

        Charset charset = resolveCharsetAndSetContentType(context);
        try (Writer writer = new OutputStreamWriter(context.getOutputStream(), charset);
             InputStream is = servletContext.getResourceAsStream(resolveView(context));
             InputStreamReader isr = new InputStreamReader(is, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
                 
            RenderResult result = jinjava.renderForResult(
                reader.lines().collect(Collectors.joining()), 
                new HashMap<>(context.getModels().asMap())
            );
            if (result.hasErrors()) {
                throw new ViewEngineException(formatTemplateErrors(result.getErrors()));
            }
            
            writer.write(result.getOutput());
        } catch (IOException e) {
            throw new ViewEngineException(e);
        }
    }

    private String formatTemplateErrors(List<TemplateError> errors) {
        StringBuilder builder = new StringBuilder("Errors rendering Jinja2 Template:\n");
        for (TemplateError error : errors) {
            builder.append("Severity: ");
            builder.append(error.getSeverity());

            builder.append("; Line number: ");
            builder.append(error.getLineno());

            builder.append("; Message: ");
            builder.append(error.getMessage());
            builder.append("\n");
        }
        return builder.toString();
    }
}
