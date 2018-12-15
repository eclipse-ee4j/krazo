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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test for EncodersImpl.
 *
 * @author Santiago Pericas-Geertsen
 */
public class EncodersImplTest {

    private final EncodersImpl encoders = new EncodersImpl();

    @Test
    public void testEncoderJs() {
        assertEquals("\\b \\t \\n \\f \\r", encoders.js("\b \t \n \f \r"));
        assertEquals("\\/ \\\\ \\x22 \\x26 \\x27", encoders.js("/ \\ \" & '"));
        assertEquals("\\x00 \\x0f \\x10 \\x1f", encoders.js("\u0000 \u000f \u0010 \u001f"));
        assertEquals("\\tfunction() { return \\x27Hello World\\x27; }",
                     encoders.js("\tfunction() { return 'Hello World'; }"));
        assertNull(encoders.js(null));
    }

    @Test
    public void testEncoderHtml() {
        assertEquals("&amp; &lt; &gt; &#39; &#34;", encoders.html("& < > ' \""));
        assertEquals("&lt;html&gt;&lt;div id=&#34;foo&#34;&gt;&amp;&amp;&lt;/div&gt;&lt;/html&gt;",
                     encoders.html("<html><div id=\"foo\">&&</div></html>"));
        assertNull(encoders.html(null));
    }
}
