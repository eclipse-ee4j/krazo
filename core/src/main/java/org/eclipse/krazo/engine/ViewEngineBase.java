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
package org.eclipse.krazo.engine;

import org.eclipse.krazo.util.PathUtils;
import org.eclipse.krazo.util.PropertyUtils;

import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.nio.charset.Charset;

/**
 * Base class for view engines that factors out all common logic.
 *
 * @author Santiago Pericas-Geertsen
 */
public abstract class ViewEngineBase implements ViewEngine {

    /**
     * Resolves a view path based on {@link javax.mvc.engine.ViewEngine#VIEW_FOLDER}
     * in the active configuration. If the view is absolute, starts with '/', then
     * it is returned unchanged.
     *
     * @param context view engine context.
     * @return resolved view.
     */
    protected String resolveView(ViewEngineContext context) {
        final String view = context.getView();
        if (!PathUtils.hasStartingSlash(view)) {        // Relative?
            final String viewFolder = PropertyUtils.getProperty(context.getConfiguration(), VIEW_FOLDER, DEFAULT_VIEW_FOLDER);
            return PathUtils.ensureEndingSlash(viewFolder) + view;
        }
        return view;
    }

    /**
     * This methods reads the 'charset' parameter from the media type and falls back to 'UTF-8'
     * if the parameter is missing. It then adds a corresponding 'Content-Type' with the correct
     * encoding to the response headers. Finally it returns the effective character set so that
     * the view engine implementation can use it write the data correctly to the output stream.
     *
     * @param context The context
     * @return the effective charset
     */
    protected Charset resolveCharsetAndSetContentType(ViewEngineContext context) {

        String charset = context.getMediaType().getParameters().get("charset");
        if (charset == null) {
            charset = "UTF-8";
        }

        MediaType mediaType = context.getMediaType().withCharset(charset);

        context.getResponseHeaders().putSingle(HttpHeaders.CONTENT_TYPE, mediaType.toString());

        return Charset.forName(charset);

    }


}
