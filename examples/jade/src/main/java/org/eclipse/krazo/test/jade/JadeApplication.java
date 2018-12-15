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
package org.eclipse.krazo.test.jade;

import org.eclipse.krazo.ext.jade.JadeKrazoConfiguration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Florian Hirsch
 */
@ApplicationPath("/jade")
public class JadeApplication extends Application {

    private final Set<Class<?>> classes;

    public JadeApplication() {
        classes = new HashSet<>();
        classes.add(JadeController.class);
        // Register a filter to test if configuration via SystemProperties works
        String filterName = String.format("%s.%s", JadeKrazoConfiguration.FILTER_QUALIFIER, "systemProperties");
        System.setProperty(filterName, DummyFilter.class.getName());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
