/*
 * Copyright (c) 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.forms;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import org.eclipse.krazo.security.FormEntityProvider;
import org.eclipse.krazo.util.ServiceLoaders;

/**
 * <p>
 * Filter to replace the method of HTML forms with some that is not covered by the HTML
 * specification (which may be PUT, PATCH or DELETE).
 * </p>
 *
 * <p>
 * To replace the form's method, you need to add an hidden input field named <i>_method</i> to your
 * form and provide the alternative method as value (as shown in the example below).
 * </p>
 *
 * <p>
 * Example:
 * </p>
 *
 * <pre>
 * {@code
 *    <form action="/example" method="post">
 *       <input name="_method" type="hidden" value="PUT">
 *       <input type="submit" name="submit" value="Submit"/>
 *    </form>
 * }
 * </pre>
 *
 * @author Tobias Erdle
 */
@Provider
@PreMatching
@Priority(Priorities.HEADER_DECORATOR)
public class HiddenMethodFilter implements ContainerRequestFilter {

  private static final String HIDDEN_METHOD_NAME = "_method";

  private final FormEntityProvider formEntityProvider;

  public HiddenMethodFilter() {
    formEntityProvider = ServiceLoaders.list(FormEntityProvider.class).get(0);
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {

    if (isFormData(requestContext)) {
      final Form form = formEntityProvider.getForm(requestContext);
      final String hiddenMethod = getHiddenMethod(form);

      if (hiddenMethod != null && !hiddenMethod.isEmpty()) {
        requestContext.setMethod(hiddenMethod);
      }
    }
  }

  private boolean isFormData(ContainerRequestContext requestContext) {
    return MediaType.APPLICATION_FORM_URLENCODED_TYPE
        .isCompatible(requestContext.getMediaType());
  }

  private String getHiddenMethod(final Form form) {
    String hiddenMethod = null;
    final List<String> hiddenFieldValues = form.asMap().getOrDefault(HIDDEN_METHOD_NAME, Collections
        .emptyList());

    if (!hiddenFieldValues.isEmpty()) {
      hiddenMethod = hiddenFieldValues.get(0);
    }

    return hiddenMethod;
  }
}
