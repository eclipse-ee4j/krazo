/*
 * Copyright © 2019 Eclipse Krazo committers and contributors
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

package org.eclipse.krazo.test.mapper;

import org.eclipse.krazo.core.ModelsImpl;
import org.eclipse.krazo.engine.Viewable;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MvcViewExceptionMapper implements ExceptionMapper<MvcViewException> {

    @Override
    public Response toResponse(MvcViewException exception) {

        ModelsImpl models = new ModelsImpl();
        models.put("error", exception.getMessage());
        Viewable viewable = new Viewable("mvc-error.jsp", models);

        return Response.status(492)
            .type(MediaType.TEXT_HTML_TYPE)
            .entity(viewable)
            .build();
    }

}
