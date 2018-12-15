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
package org.eclipse.krazo.bootstrap;

import javax.servlet.ServletContext;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
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

            // https://issues.apache.org/jira/browse/CXF-7501
            // https://issues.apache.org/jira/browse/TOMEE-2122
            if (servletContext == null) {
                log.warning("The ServletContext wasn't injected into the JAX-RS Feature class");
            }

            Initializer.initialize(context, servletContext);
            return true;

        }
        return false;

    }

}
