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
package org.eclipse.krazo.security;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Form;
import java.io.IOException;

/**
 * Service Provider Interface for parsing the request content during
 * CSRF-Token validation.
 *
 * @author Gregor Tudan
 */
public interface FormEntityProvider {

    /**
     * Tries to parse the request as url-encoded form.
     * <p>The request entity must be restored to a readable state after parsing it!</p>
     *
     * @param ctx the request context
     * @return the values parsed from the request context.
     * @throws IOException if the entity body cannot be read.
     */
    Form getForm(ContainerRequestContext ctx) throws IOException;
}
