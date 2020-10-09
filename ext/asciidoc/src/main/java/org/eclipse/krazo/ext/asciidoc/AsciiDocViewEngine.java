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
package org.eclipse.krazo.ext.asciidoc;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Asciidoctor.Factory;
import org.asciidoctor.Options;
import org.eclipse.krazo.engine.ViewEngineBase;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.engine.ViewEngine;
import jakarta.mvc.engine.ViewEngineContext;
import jakarta.mvc.engine.ViewEngineException;
import jakarta.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Class AsciiDocViewEngine.
 *
 * @author Ricardo Arguello
 */
@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class AsciiDocViewEngine extends ViewEngineBase {

    private final Asciidoctor asciidoctor;

    @Inject
    private ServletContext servletContext;

    public AsciiDocViewEngine() {
        asciidoctor = Factory.create();
    }

    @Override
    public boolean supports(String view) {
        return view.endsWith(".adoc") || view.endsWith(".asciidoc");
    }

    @Override
    public void processView(ViewEngineContext context) throws ViewEngineException {
        Charset charset = resolveCharsetAndSetContentType(context);
        try (Writer writer = new OutputStreamWriter(context.getOutputStream(), charset);
             InputStream is = servletContext.getResourceAsStream(resolveView(context));
             InputStreamReader isr = new InputStreamReader(is, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {

            Options options = new Options();
            options.setAttributes(new HashMap<>(context.getModels().asMap()));

            asciidoctor.convert(reader, writer, options);
        } catch (IOException e) {
            throw new ViewEngineException(e);
        }
    }
}
