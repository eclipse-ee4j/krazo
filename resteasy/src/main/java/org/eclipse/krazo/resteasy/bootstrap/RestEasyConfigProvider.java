/*
 * Copyright (c) 2018, 2026 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.resteasy.bootstrap;

import org.eclipse.krazo.bootstrap.ConfigProvider;
import org.eclipse.krazo.resteasy.validation.KrazoValidationResolver;

import jakarta.ws.rs.core.FeatureContext;
import java.util.logging.Logger;

/**
 * Implementation of ConfigProvider for the RESTEasy module.
 *
 * @author Christian Kaltepoth
 */
public class RestEasyConfigProvider implements ConfigProvider {

    private static final Logger log = Logger.getLogger(RestEasyConfigProvider.class.getName());

    static final String GENERAL_VALIDATOR_CLASS = "org.jboss.resteasy.spi.validation.GeneralValidator";

    @Override
    public void configure(FeatureContext context) {

        // Some runtimes, like Open Liberty, don't expose the RESTEasy SPI to applications. Registering
        // the resolver there fails with a NoClassDefFoundError, which aborts the initialization of Krazo.
        if (isGeneralValidatorVisible()) {
            context.register(KrazoValidationResolver.class);
        } else {
            log.warning("The RESTEasy validation SPI (" + GENERAL_VALIDATOR_CLASS + ") is not visible "
                    + "to the application, so Eclipse Krazo cannot stop RESTEasy from validating the parameters "
                    + "of controller methods. Constraint violations will then result in a 400 Bad Request "
                    + "response instead of being reported in BindingResult. To let Eclipse Krazo handle "
                    + "validation, annotate the controller classes or methods with "
                    + "@ValidateOnExecution(type = ExecutableType.NONE).");
        }

    }

    static boolean isGeneralValidatorVisible() {
        try {
            Class.forName(GENERAL_VALIDATOR_CLASS, false, RestEasyConfigProvider.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException | LinkageError e) {
            return false;
        }
    }

}
