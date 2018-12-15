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
package org.eclipse.krazo.ext.velocity;

import org.eclipse.krazo.engine.ViewEngineConfig;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.view.WebappResourceLoader;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletContext;

/**
 * Producer for the VelocityEngine used by VelocityViewEngine.
 *
 * @author Christian Kaltepoth
 */
public class DefaultVelocityEngineProducer {

    @Inject
    private ServletContext servletContext;

    @Produces
    @ViewEngineConfig
    public VelocityEngine getVelocityEngine() {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("resource.loader", "webapp");
        velocityEngine.setProperty("webapp.resource.loader.class", WebappResourceLoader.class.getCanonicalName());
        velocityEngine.setApplicationAttribute("javax.servlet.ServletContext", servletContext);
        velocityEngine.init();
        return velocityEngine;
    }

}
