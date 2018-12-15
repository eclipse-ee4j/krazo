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
package org.eclipse.krazo.resteasy.validation;

import org.jboss.resteasy.plugins.validation.ValidatorContextResolver;
import org.jboss.resteasy.spi.validation.GeneralValidator;

import javax.ws.rs.ext.ContextResolver;

/**
 * This {@link ContextResolver} will resolve our own {@link GeneralValidator} which will ignore
 * all validation requests for MVC controllers.
 *
 * @author Christian Kaltepoth
 */
public class KrazoValidationResolver implements ContextResolver<GeneralValidator> {

    public GeneralValidator getContext(Class<?> aClass) {

        // get the real RESTEasy validator
        GeneralValidator wrapped = new ValidatorContextResolver().getContext(aClass);

        // only delegate to wrapped validator for regular JAX-RS requests
        return new KrazoGeneralValidator(wrapped);

    }

}
