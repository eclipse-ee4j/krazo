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
package org.eclipse.krazo.test.csrfproperty;

import jakarta.inject.Inject;
import jakarta.mvc.Models;
import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

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
