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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Default implementation of the {@link HttpCommunicationUnwrapper}. This class is just a fallback
 * in case no unwrapping is necessary, which is hopefully the case for the most JAX-RS implementations.
 */
public class DefaultHttpCommunicationUnwrapper implements HttpCommunicationUnwrapper {

    @Override
    public boolean supports(final Object obj) {
        return true;
    }

    @Override
    public HttpServletRequest unwrapRequest(final HttpServletRequest obj, final Class<HttpServletRequest> type) {
        return obj;
    }

    @Override
    public HttpServletResponse unwrapResponse(final HttpServletResponse obj, final Class<HttpServletResponse> type) {
        return obj;
    }
}
