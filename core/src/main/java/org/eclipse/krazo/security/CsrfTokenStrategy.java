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
import java.util.Optional;

/**
 * SPI to support different ways to store the CSRF token
 *
 * @author Christian Kaltepoth
 */
public interface CsrfTokenStrategy {

    /**
     * @param request  The current request
     * @param response The current response
     * @param create   Whether to create a token if there is none
     * @return The token
     */
    Optional<CsrfToken> getToken(HttpServletRequest request, HttpServletResponse response, boolean create);

}
