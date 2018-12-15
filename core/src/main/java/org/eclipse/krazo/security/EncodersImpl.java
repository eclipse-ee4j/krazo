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

import javax.enterprise.context.ApplicationScoped;
import javax.mvc.security.Encoders;

/**
 * Utility bean that provides encoders to <em>escape</em> code in JavaScript, HTML,
 * CSS, etc. Encoding data that may be mis-interpreted in a client (e.g., a browser)
 * can prevent XSS attacks. Injectable bean that is also accessible in EL via
 * the {@link javax.mvc.MvcContext} object as {@code mvc.encoders}.
 *
 * @author Santiago Pericas-Geertsen
 */
@ApplicationScoped
public class EncodersImpl implements Encoders {

    public String js(String s) {
        if (s == null) {
            return null;
        }
        final int l = s.length();
        final StringBuffer sb = new StringBuffer(l);
        for (int i = 0; i < l; i++) {
            final char ch = s.charAt(i);
            switch (ch) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\"':
                    sb.append("\\x22");
                    break;
                case '&':
                    sb.append("\\x26");
                    break;
                case '\'':
                    sb.append("\\x27");
                    break;
                default:
                    if (ch >= '\u0000' && ch <= '\u001F') {
                        sb.append("\\x").append(ch <= '\u000F' ? "0" : "").append(Integer.toHexString((int) ch));
                    } else {
                        sb.append(ch);
                    }
            }
        }
        return sb.toString();
    }

    public String html(String s) {
        if (s == null) {
            return null;
        }
        final int l = s.length();
        final StringBuffer sb = new StringBuffer(l);
        for (int i = 0; i < l; i++) {
            final char ch = s.charAt(i);
            switch (ch) {
                case '&':
                    sb.append("&amp;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '"':
                    sb.append("&#34;");
                    break;
                case '\'':
                    sb.append("&#39;");
                    break;
                default:
                    sb.append(ch);
            }
        }
        return sb.toString();
    }
}
