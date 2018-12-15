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
package org.eclipse.krazo.test.csrfproperty;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Class ForbiddenExceptionMapper.
 *
 * @author Santiago Pericas-Geertsen
 */
public class ForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {

    @Inject
    private Models models;

    @Override
    public Response toResponse(ForbiddenException exception) {
        models.put("message", exception.getMessage());
        return Response.status(Response.Status.FORBIDDEN).type(MediaType.TEXT_HTML_TYPE).entity("error.jsp").build();
    }
}
