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
package org.eclipse.krazo.binding;

import org.eclipse.krazo.cdi.Internal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Produces Bean Validation validation objects. Will try to get the default ones provided by the
 * Java EE contrainer and falls back to build a custom ones.
 *
 * @author Christian Kaltepoth
 */
@ApplicationScoped
public class BeanValidationProducer {

    private static final Logger log = Logger.getLogger(BeanValidationProducer.class.getName());

    /**
     * The ValidatorFactory should be available for injection as defined here:
     * http://beanvalidation.org/1.1/spec/#d0e11327
     */
    @Inject
    private Instance<ValidatorFactory> validatorFactoryInstance;

    /**
     * The actual ValidatorFactory to use
     */
    private ValidatorFactory validatorFactory;

    /**
     * We should be able to get a ValidatorFactory from the container in an Java EE environment.
     * However, if we don't get the factory, we will will use a default one. This is especially
     * useful for non Java EE environments and in the CDI tests
     */
    @PostConstruct
    public void init() {

        // Prefer the ValidatorFactory provided by the container
        Iterator<ValidatorFactory> iterator = validatorFactoryInstance.iterator();
        if (iterator.hasNext()) {
            this.validatorFactory = iterator.next();
        }

        // create a default factory if we didn't get one
        else {
            log.warning("Creating a ValidatorFactory because the container didn't provide one!");
            this.validatorFactory = Validation.buildDefaultValidatorFactory();
        }

    }

    @Produces
    @Internal
    @ApplicationScoped
    public ValidatorFactory produceValidationFactory() {
        return validatorFactory;
    }

}
