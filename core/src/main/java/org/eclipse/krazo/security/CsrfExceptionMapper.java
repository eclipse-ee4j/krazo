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
package org.eclipse.krazo.security;

import javax.mvc.security.CsrfValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Default mapper for {@link CsrfValidationException}.
 *
 * @author Christian Kaltepoth
 */
public class CsrfExceptionMapper implements ExceptionMapper<CsrfValidationException> {

    @Override
    public Response toResponse(CsrfValidationException e) {

        CsrfValidationStatusType status = new CsrfValidationStatusType(e.getMessage());

        return Response.status(status).build();

    }

    /**
     * Custom implementation of {@link javax.ws.rs.core.Response.StatusType} that allows
     * to customize the response phrase.
     */
    private static class CsrfValidationStatusType implements Response.StatusType {

        private final Response.StatusType status = Response.Status.FORBIDDEN;

        private final String phrase;

        public CsrfValidationStatusType(String phrase) {
            this.phrase = phrase;
        }

        @Override
        public int getStatusCode() {
            return status.getStatusCode();
        }

        @Override
        public Response.Status.Family getFamily() {
            return status.getFamily();
        }

        @Override
        public String getReasonPhrase() {
            return phrase;
        }

    }

}
