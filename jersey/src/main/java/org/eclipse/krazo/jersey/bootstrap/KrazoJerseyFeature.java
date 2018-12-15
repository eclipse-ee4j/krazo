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
package org.eclipse.krazo.jersey.bootstrap;

import org.glassfish.jersey.internal.spi.AutoDiscoverable;
import org.glassfish.jersey.internal.spi.ForcedAutoDiscoverable;
import org.eclipse.krazo.bootstrap.Initializer;

import javax.annotation.Priority;
import javax.servlet.ServletContext;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.FeatureContext;

/**
 * This class uses the Jersey specific ForcedAutoDiscoverable SPI to trigger the Krazo initialization
 * process. Please not that this will work even if the Application subclass explicitly specifies
 * singletons and instances.
 *
 * @author Christian Kaltepoth
 */
@ConstrainedTo(RuntimeType.SERVER)
@Priority(AutoDiscoverable.DEFAULT_PRIORITY)
public class KrazoJerseyFeature implements ForcedAutoDiscoverable {

    @Context
    private ServletContext servletContext;

    @Override
    public void configure(FeatureContext context) {
        Initializer.initialize(context, servletContext);
    }

}
