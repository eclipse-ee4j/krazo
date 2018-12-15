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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Session-based implementation if {@link CsrfTokenStrategy}.
 *
 * @author Christian Kaltepoth
 */
public class CookieCsrfTokenStrategy implements CsrfTokenStrategy {

    private final String headerName;
    private final String paramName;
    private final String cookieName;
    private final int maxAge;
    private final boolean httpOnly;

    private CookieCsrfTokenStrategy(Builder builder) {
        headerName = builder.headerName;
        paramName = builder.paramName;
        cookieName = builder.cookieName;
        maxAge = builder.maxAge;
        httpOnly = builder.httpOnly;
    }

    @Override
    public Optional<CsrfToken> getToken(HttpServletRequest request, HttpServletResponse response, boolean create) {

        for (Cookie cookie : request.getCookies()) {
            if (Objects.equals(cookie.getName(), cookieName)) {
                return Optional.of(new CsrfToken(headerName, paramName, cookie.getValue()));
            }
        }

        if (create) {

            CsrfToken token = new CsrfToken(headerName, paramName, UUID.randomUUID().toString());

            Cookie cookie = new Cookie(cookieName, token.getValue());
            cookie.setSecure(request.isSecure());
            cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
            cookie.setMaxAge(maxAge);
            cookie.setHttpOnly(httpOnly);
            response.addCookie(cookie);

            return Optional.of(token);

        }

        return Optional.empty();

    }


    public static final class Builder {

        private String headerName = "X-XSRF-TOKEN";
        private String paramName = "_csrf";
        private String cookieName = "XSRF-TOKEN";
        private int maxAge = -1;
        private boolean httpOnly = false;

        public Builder headerName(String headerName) {
            this.headerName = headerName;
            return this;
        }

        public Builder paramName(String paramName) {
            this.paramName = paramName;
            return this;
        }

        public Builder cookieName(String cookieName) {
            this.cookieName = cookieName;
            return this;
        }

        public Builder maxAge(int maxAge) {
            this.maxAge = maxAge;
            return this;
        }

        public Builder httpOnly(boolean httpOnly) {
            this.httpOnly = httpOnly;
            return this;
        }

        public CookieCsrfTokenStrategy build() {
            return new CookieCsrfTokenStrategy(this);
        }

    }
}
