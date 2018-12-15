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
package org.eclipse.krazo.ext.pebble;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.eclipse.krazo.engine.ViewEngineBase;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.krazo.engine.ViewEngineConfig;

/**
 * @see <a href="http://www.mitchellbosecke.com/pebble/home">Pebble</a>
 */
@ApplicationScoped
@Priority(ViewEngine.PRIORITY_FRAMEWORK)
public class PebbleViewEngine extends ViewEngineBase {

  private PebbleEngine pebbleEngine;

  @Inject
  public PebbleViewEngine(@ViewEngineConfig PebbleEngine pebbleEngine) {
    this.pebbleEngine = pebbleEngine;
  }

  @Override
  public boolean supports(String view) {
    return view.endsWith(".peb");
  }

  @Override
  public void processView(ViewEngineContext context) throws ViewEngineException {

    Charset charset = resolveCharsetAndSetContentType(context);
    
    try(Writer writer = new OutputStreamWriter(context.getOutputStream(), charset)) {

      PebbleTemplate template = pebbleEngine.getTemplate(resolveView(context));
      
      Map<String, Object> model = new HashMap<>(context.getModels().asMap());
      model.put("request", context.getRequest(HttpServletRequest.class));
      
      template.evaluate(writer, model);
      
    } catch (PebbleException | IOException ex) {
      throw new ViewEngineException(String.format("Could not process view %s.", context.getView()), ex);
    }
  }
}
