/*
 * Copyright © 2019 Eclipse Krazo committers and contributors
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

package org.eclipse.krazo.ext.velocity;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.apache.velocity.util.ExtProperties;

import jakarta.servlet.ServletContext;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * Simple implementation of {@link ResourceLoader} for loading resources from {@link ServletContext}
 *
 * @author Christian Kaltepoth
 */
public class ServletContextResourceLoader extends ResourceLoader {

    private ServletContext servletContext;

    @Override
    public void init(ExtProperties configuration) {
        servletContext = (ServletContext) rsvc.getApplicationAttribute(ServletContext.class.getName());
    }

    @Override
    public Reader getResourceReader(String source, String encoding) throws ResourceNotFoundException {
        try {

            InputStream stream = servletContext.getResourceAsStream(source);
            if (stream != null) {
                return new InputStreamReader(stream, encoding);
            }
            return null;

        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean isSourceModified(Resource resource) {
        return false;
    }

    @Override
    public long getLastModified(Resource resource) {
        return 0;
    }

}
