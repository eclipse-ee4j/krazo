/*
 * Copyright (c) 2026 Eclipse Krazo committers and contributors
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

import jakarta.ws.rs.core.MediaType;
import org.junit.Test;

import static org.eclipse.krazo.core.ViewResponseFilter.defaultMediaTypeIfRequired;
import static org.junit.Assert.assertEquals;

public class ViewResponseFilterMediaTypeTest {

    @Test
    public void fallbackMediaTypesDefaultToTextHtmlWithoutProduces() {
        assertEquals(MediaType.TEXT_HTML_TYPE, defaultMediaTypeIfRequired(null, false));
        assertEquals(MediaType.TEXT_HTML_TYPE, defaultMediaTypeIfRequired(MediaType.WILDCARD_TYPE, false));
        assertEquals(MediaType.TEXT_HTML_TYPE, defaultMediaTypeIfRequired(MediaType.valueOf("text/*"), false));
        assertEquals(MediaType.TEXT_HTML_TYPE, defaultMediaTypeIfRequired(MediaType.APPLICATION_OCTET_STREAM_TYPE, false));
        assertEquals(MediaType.TEXT_HTML_TYPE,
                defaultMediaTypeIfRequired(MediaType.APPLICATION_OCTET_STREAM_TYPE.withCharset("UTF-8"), false));
    }

    @Test
    public void explicitMediaTypeIsKeptWithoutProduces() {
        assertEquals(MediaType.TEXT_PLAIN_TYPE, defaultMediaTypeIfRequired(MediaType.TEXT_PLAIN_TYPE, false));
        assertEquals(MediaType.TEXT_HTML_TYPE, defaultMediaTypeIfRequired(MediaType.TEXT_HTML_TYPE, false));
    }

    @Test
    public void mediaTypeIsKeptWithProduces() {
        assertEquals(MediaType.APPLICATION_OCTET_STREAM_TYPE,
                defaultMediaTypeIfRequired(MediaType.APPLICATION_OCTET_STREAM_TYPE, true));
        assertEquals(null, defaultMediaTypeIfRequired(null, true));
    }

}
