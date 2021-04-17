/*
 * Copyright (c) 2018, 2021 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.bootstrap;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.ConstrainedTo;
import jakarta.ws.rs.RuntimeType;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.ext.Provider;
import java.util.logging.Logger;

/**
 * JAX-RS feature to initialize Krazo. Please note that automatic initialization will
 * only work if the application class doesn't specify instances and singletons explicitly.
 *
 * @author Christian Kaltepoth
 */
@Provider
@ConstrainedTo(RuntimeType.SERVER)
public class CoreFeature implements Feature {

    private static final Logger log = Logger.getLogger(CoreFeature.class.getName());

    @Context
    private ServletContext servletContext;

    @Override
    public boolean configure(FeatureContext context) {

        // RESTEasy seems to ignore @ConstrainedTo in some cases
        if (context.getConfiguration().getRuntimeType() == RuntimeType.SERVER) {

            Initializer.initialize(context, servletContext);
            return true;

        }
        return false;

    }

}
