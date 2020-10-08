/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.servlet;

import org.eclipse.krazo.util.AnnotationUtils;

import jakarta.mvc.Controller;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;
import jakarta.ws.rs.Path;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Performs some basic initialization work before CDI and JAX-RS are bootstrapped.
 *
 * @author Santiago Pericas-Geertsen
 * @author Dmytro Maidaniuk
 * @author Christian Kaltepoth
 */
@HandlesTypes({Path.class})
public class KrazoContainerInitializer implements ServletContainerInitializer {

    public static final String CONTROLLER_CLASSES = KrazoContainerInitializer.class.getName() + ".CONTROLLER_CLASSES";

    private static final Logger LOG = Logger.getLogger(KrazoContainerInitializer.class.getName());

    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) {

        if (classes == null || classes.isEmpty()) {
            return;
        }

        LOG.log(Level.INFO, "Eclipse Krazo version {0} started", getClass().getPackage().getImplementationVersion());

        Set<Class> controllerClasses = new LinkedHashSet<>();

        for (Class<?> clazz : classes) {

            // collect all controllers
            if (AnnotationUtils.hasAnnotationOnClassOrMethod(clazz, Path.class)
                    && AnnotationUtils.hasAnnotationOnClassOrMethod(clazz, Controller.class)) {
                controllerClasses.add(clazz);
            }
        }

        servletContext.setAttribute(CONTROLLER_CLASSES, Collections.unmodifiableSet(controllerClasses));

    }
}
