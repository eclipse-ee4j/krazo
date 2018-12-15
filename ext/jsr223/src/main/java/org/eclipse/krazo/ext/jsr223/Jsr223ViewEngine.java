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
package org.eclipse.krazo.ext.jsr223;

import org.eclipse.krazo.engine.ViewEngineBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;

/**
 * The JSR-223 ViewEngine.
 *
 * @author Manfred Riem (manfred.riem@oracle.com)
 */
@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class Jsr223ViewEngine extends ViewEngineBase {

    /**
     * Stores our global ScriptEngineManager.
     */
    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

    /**
     * Servlet context so we can load load the script
     */
    @Inject
    private ServletContext servletContext;

    /**
     * What extensions does the view engine support.
     *
     * @param view the view.
     * @return if we support the extension or not.
     */
    @Override
    public boolean supports(String view) {
        return getScriptEngine(view) != null;
    }

    /**
     * Get the script engine by extension.
     *
     * @param view the view.
     * @return the script engine, or null if not found.
     */
    private ScriptEngine getScriptEngine(String view) {
        if (view.contains(".")) {
            String extension = view.substring(view.lastIndexOf(".") + 1);
            return scriptEngineManager.getEngineByExtension(extension);
        }
        return null;
    }

    /**
     * Process the view.
     *
     * @param context the context.
     * @throws ViewEngineException when the view engine experienced an error.
     */
    @Override
    public void processView(ViewEngineContext context) throws ViewEngineException {

        ScriptEngine scriptEngine = getScriptEngine(context.getView());
        Object responseObject;
        try {
            InputStream inputStream = servletContext.getResourceAsStream(resolveView(context));
            InputStreamReader reader = new InputStreamReader(inputStream);
            Bindings bindings = scriptEngine.createBindings();
            bindings.put("models", context.getModels().asMap());
            responseObject = scriptEngine.eval(reader, bindings);
        } catch (ScriptException exception) {
            throw new ViewEngineException("Unable to execute script", exception);
        }

        Charset charset = resolveCharsetAndSetContentType(context);
        try (Writer writer = new OutputStreamWriter(context.getOutputStream(), charset)) {
            writer.write(responseObject.toString());
        } catch (IOException exception) {
            throw new ViewEngineException("Unable to write response", exception);
        }
    }
}
