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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;

/**
 * Session-based implementation if {@link CsrfTokenStrategy}.
 *
 * @author Christian Kaltepoth
 */
public class SessionCsrfTokenStrategy implements CsrfTokenStrategy {

    private static final String SESSION_KEY = SessionCsrfTokenStrategy.class.getName() + ".TOKEN";

    private final String headerName;
    private final String paramName;

    private SessionCsrfTokenStrategy(Builder builder) {
        headerName = builder.headerName;
        paramName = builder.paramName;
    }

    @Override
    public Optional<CsrfToken> getToken(HttpServletRequest request, HttpServletResponse response, boolean create) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            Object value = session.getAttribute(SESSION_KEY);
            if (value instanceof CsrfToken) {
                return Optional.of((CsrfToken) value);
            }
        }

        if (create) {
            CsrfToken token = new CsrfToken(headerName, paramName, UUID.randomUUID().toString());
            request.getSession(true).setAttribute(SESSION_KEY, token);
            return Optional.of(token);
        }

        return Optional.empty();

    }

    public static final class Builder {

        private String headerName = "X-CSRF-TOKEN";
        private String paramName = "_csrf";

        public Builder headerName(String headerName) {
            this.headerName = headerName;
            return this;
        }

        public Builder paramName(String paramName) {
            this.paramName = paramName;
            return this;
        }

        public SessionCsrfTokenStrategy build() {
            return new SessionCsrfTokenStrategy(this);
        }

    }
}
