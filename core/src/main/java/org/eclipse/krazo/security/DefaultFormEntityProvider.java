/*
 * Copyright (c) 2019 Eclipse Krazo committers and contributors
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

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.net.URLDecoder;

/**
 * Default implementation for the {@link FormEntityProvider} SPI.
 *
 * <p>This will parse the request content as url encoded form and return its values.
 * If the request entity stream cannot be reset, the content will be buffered the
 * entity stream from the request context will be replaced with the buffer.</p>
 *
 * <p>This does not work on all containers, so there are alternative implementations for
 * different JAX-RS providers.</p>
 *
 * @author Gregor Tudan
 */
public class DefaultFormEntityProvider implements FormEntityProvider {

    private static final String DEFAULT_CHARSET = "UTF-8";

    @Override
    public Form getForm(ContainerRequestContext context) throws IOException {
        final InputStream is = context.getEntityStream();

        // Ensure stream can be restored for next interceptor
        InputStream bufferedStream;
        if (is.markSupported()) {
            bufferedStream = is;
        } else {
            bufferedStream = new BufferedInputStream(is);
        }
        bufferedStream.mark(Integer.MAX_VALUE);

        final MediaType contentType = context.getMediaType();

        final String charset = contentType.getParameters().get("charset");
        final String entity = toString(bufferedStream, charset != null ? charset : DEFAULT_CHARSET);

        final Form form = parseForm(entity);

        bufferedStream.reset();
        context.setEntityStream(bufferedStream);

        return form;

    }

    private static Form parseForm(String entity) throws UnsupportedEncodingException {
        final Form form = new Form();

        final String[] pairs = entity.split("&");
        for (String pair : pairs) {
            final int position = pair.indexOf("=");
            if (position == -1) {
                // This parser tolerates invalid input as it is only looking for the CSRF-Tokens
                // If it is reading garbage the CSRF-Validator will get an empty
                // form and throw an exception since the token is missing.
                continue;
            }
            final String nn = URLDecoder.decode(pair.substring(0, position), DEFAULT_CHARSET);
            final String vv = URLDecoder.decode(pair.substring(position + 1), DEFAULT_CHARSET);
            form.param(nn, vv);
        }
        return form;
    }

    private static String toString(InputStream bais, String encoding) throws IOException {
        final StringBuilder out = new StringBuilder();

        final InputStreamReader reader = new InputStreamReader(bais, encoding);
        int character;
        while ((character = reader.read()) != -1) {
            out.append((char) character);
        }

        return out.toString();
    }
}
