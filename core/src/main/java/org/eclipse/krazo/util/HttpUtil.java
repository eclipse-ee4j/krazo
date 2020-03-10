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

package org.eclipse.krazo.util;

import org.eclipse.krazo.core.HttpCommunicationUnwrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Utility class containing helper methods for HTTP related tasks.
 */
public final class HttpUtil {

    /**
     * Unwrap the original {@link HttpServletRequest} from a wrapper, so someone can access the original values.
     *
     * @param currentRequest the request provided by the runtime. Might be a wrapper around the original request.
     * @return the origin {@link HttpServletRequest}
     */
    public static HttpServletRequest unwrapOriginalRequest(final HttpServletRequest currentRequest) {
        return ServiceLoaders.list(HttpCommunicationUnwrapper.class).stream()
            .filter(unwrapper -> unwrapper.supports(currentRequest))
            .findFirst()
            .map(unwrapper -> unwrapper.unwrapRequest(currentRequest, HttpServletRequest.class))
            .orElseThrow(() -> new IllegalStateException("no HttpCommunicationUnwrapper found for " + currentRequest));
    }

    /**
     * Unwrap the original {@link javax.servlet.http.HttpServletResponse} from a wrapper, so someone can access the original values.
     *
     * @param currentResponse the request provided by the runtime. Might be a wrapper around the original response.
     * @return the origin {@link HttpServletRequest}
     */
    public static HttpServletResponse unwrapOriginalResponse(final HttpServletResponse currentResponse) {
        return ServiceLoaders.list(HttpCommunicationUnwrapper.class).stream()
            .filter(unwrapper -> unwrapper.supports(currentResponse))
            .findFirst()
            .map(unwrapper -> unwrapper.unwrapResponse(currentResponse, HttpServletResponse.class))
            .orElseThrow(() -> new IllegalStateException("no HttpCommunicationUnwrapper found for " + currentResponse));
    }

    private HttpUtil() {
    }
}
