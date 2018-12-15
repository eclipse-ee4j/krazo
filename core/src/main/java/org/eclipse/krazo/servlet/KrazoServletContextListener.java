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
package org.eclipse.krazo.servlet;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.util.Set;
import java.util.logging.Logger;

import static org.eclipse.krazo.servlet.KrazoContainerInitializer.CONTROLLER_CLASSES;

/**
 * Performs some sanity checks for controllers during startup
 */
@WebListener
public class KrazoServletContextListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(KrazoServletContextListener.class.getName());

    @Inject
    private BeanManager beanManager;

    public KrazoServletContextListener() { }

    public KrazoServletContextListener(BeanManager beanManager) {
        this.beanManager = beanManager;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();
        Set<Class<?>> controllerClasses = (Set<Class<?>>) servletContext.getAttribute(CONTROLLER_CLASSES);

        if (controllerClasses == null || controllerClasses.isEmpty()) {
            return;
        }

        for (Class<?> controllerClass : controllerClasses) {
            failIfNoCdiBean(controllerClass);
            warnIfAnnotatedWithNamed(controllerClass);
        }
    }

    /**
     * Throws an exception if the passed controller class is not present in the CDI BeanManager.
     * For example, this can happen with glassfish / Jersey if the application is using CDI discovery mode "annotated"
     * and the controller class is not annotated with any scope annotation.
     * Unlike in JAX-RS resources, MVC controllers are required to be CDI-managed beans.
     */
    private void failIfNoCdiBean(Class<?> controllerClass) {
        Set<Bean<?>> controllerBeans = beanManager.getBeans(controllerClass);
        if (controllerBeans == null || controllerBeans.isEmpty()) {
            String message = String.format("The controller %s is not a managed CDI bean. Maybe the controller class is " +
                    "missing a scope annotation (e.g. @RequestScoped).", controllerClass.getName());
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Logs a warning if the passed controller class is annotated with {@link Named}.
     */
    private void warnIfAnnotatedWithNamed(Class<?> controllerClass) {
        Named namedAnnotation = controllerClass.getAnnotation(Named.class);
        if (namedAnnotation != null) {
            String message = String.format("Controller class %s is annotated with @Named. Typically this should not be " +
                    "required, because you should never access the controller directly from a view.", controllerClass.getName());
            log.warning(message);
        }
    }

}

