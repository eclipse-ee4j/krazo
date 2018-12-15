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
package org.eclipse.krazo.ext.stringtemplate;

import org.eclipse.krazo.engine.ViewEngineBase;
import org.stringtemplate.v4.*;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.engine.*;
import javax.servlet.ServletContext;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

/**
 * Class StringTemplateViewEngine.
 *
 * @author Rodrigo Turini
 */
@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class StringTemplateViewEngine extends ViewEngineBase {

	@Inject
	private ServletContext servletContext;

    @Override
    public boolean supports(String view) {
        return view.endsWith(".st");
    }

	@Override
	public void processView(ViewEngineContext context) throws ViewEngineException {
		ST stringTemplate = getStringTemplate(resolveView(context));
		context.getModels().asMap().forEach((key, value) -> add(key, value, stringTemplate));
		Charset charset = resolveCharsetAndSetContentType(context);
		try(Writer writer = new OutputStreamWriter(context.getOutputStream(), charset)) {
			stringTemplate.write(new AutoIndentWriter(writer));
			stringTemplate.render();
		} catch (Exception e) {
			throw new ViewEngineException(e);
		}
	}

	private void add(String key, Object value, ST template) {
		if (template.getAttributes().containsKey(key)) template.add(key, value);
	}

	public ST getStringTemplate(String resolvedView) throws ViewEngineException {
		Matcher matcher = compile("(.+)/(.+)\\.st").matcher(resolvedView);
		if (matcher.find()) {
			String viewFolder = servletContext.getRealPath(matcher.group(1));
			String viewName = matcher.group(2);
			STGroup stGroup = new STGroupDir(viewFolder, '$', '$');
			stGroup.registerRenderer(String.class, new StringRenderer());
			ST template = stGroup.getInstanceOf(viewName);
			if (template != null) return template;
		}
		throw new ViewEngineException("Couldn't find view " + resolvedView);
	}
}
