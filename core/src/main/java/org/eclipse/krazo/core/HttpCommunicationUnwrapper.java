/*
 * Copyright (c) 2020 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Defines an SPI which allows the client to unwrap a HTTP request or response
 * into a standard {@link javax.servlet.http.HttpServletRequest} or {@link javax.servlet.http.HttpServletResponse}.
 * <p>
 * This SPI is intended to be used in case a JAX-RS implementation uses its own wrapper classes for HTTP requests and responses.
 */
public interface HttpCommunicationUnwrapper {

    /**
     * Checks if the current implementation supports the unwrapping of the current object.
     *
     * @param obj the object to unwrap into some standard format
     * @return true, if this unwrapper supports the current object type, false if not
     */
    boolean supports(final Object obj);

    /**
     * Unwraps a {@link javax.servlet.http.HttpServletRequest} from a custom wrapper into its original class.
     *
     * @param obj the object to unwrap
     * @param type the target type of the object
     * @return the unwrapped {@link javax.servlet.http.HttpServletRequest}
     */
    HttpServletRequest unwrapRequest(final HttpServletRequest obj, final Class<HttpServletRequest> type);

    /**
     * Unwraps a {@link javax.servlet.http.HttpServletResponse} from a custom wrapper into its original class.
     *
     * @param obj the object to unwrap
     * @param type the target type of the object
     * @return the unwrapped {@link javax.servlet.http.HttpServletResponse}
     */
    HttpServletResponse unwrapResponse(final HttpServletResponse obj, final Class<HttpServletResponse> type);
}
