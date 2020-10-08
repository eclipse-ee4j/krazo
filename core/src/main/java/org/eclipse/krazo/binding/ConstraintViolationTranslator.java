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
package org.eclipse.krazo.binding;

import org.eclipse.krazo.cdi.Internal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.metadata.ConstraintDescriptor;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Helper class to get a human readable errors message for a {@link ConstraintViolation}
 * for a specific target locale.
 *
 * @author Christian Kaltepoth
 */
@ApplicationScoped
public class ConstraintViolationTranslator {

    private static final Logger log = Logger.getLogger(ConstraintViolationTranslator.class.getName());

    @Inject
    @Internal
    private ValidatorFactory validatorFactory;

    /**
     * Returns the human readable error message for a given {@link ConstraintViolation}.
     *
     * @param violation The violation to get the message for
     * @param locale    The desired target locale
     * @return the localized message
     */
    public String translate(ConstraintViolation<?> violation, Locale locale) {

        SimpleMessageInterpolatorContext context = new SimpleMessageInterpolatorContext(violation);

        MessageInterpolator interpolator = validatorFactory.getMessageInterpolator();

        return interpolator.interpolate(violation.getMessageTemplate(), context, locale);

    }

    /**
     * Simple implementation of {@link jakarta.validation.MessageInterpolator.Context} wrapping
     * a {@link ConstraintViolation}.
     */
    private static class SimpleMessageInterpolatorContext implements MessageInterpolator.Context {

        private final ConstraintViolation<?> violation;

        public SimpleMessageInterpolatorContext(ConstraintViolation<?> violation) {
            this.violation = violation;
        }

        @Override
        public ConstraintDescriptor<?> getConstraintDescriptor() {
            return violation.getConstraintDescriptor();
        }

        @Override
        public Object getValidatedValue() {
            return violation.getInvalidValue();
        }

        @Override
        public <T> T unwrap(Class<T> type) {
            throw new UnsupportedOperationException();
        }
    }

}
