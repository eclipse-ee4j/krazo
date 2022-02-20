/*
 * Copyright (c) 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.binding.convert.impl;

import org.eclipse.krazo.binding.convert.ConverterResult;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

/**
 * Converter for double primitive or wrapper types.
 *
 * @author Christian Kaltepoth
 */
public class BigDecimalConverter extends NumberConverter<BigDecimal> {

    @Override
    public boolean supports(Class<BigDecimal> rawType, Annotation[] annotations) {
        return BigDecimal.class.equals(rawType);
    }

    @Override
    public ConverterResult<BigDecimal> convert(String value, Class<BigDecimal> rawType, Annotation[] annotations, Locale locale) {

        try {

            return ConverterResult.success(
                    parseNumber(value, locale)
                            .map(val -> val.equals(Double.NaN) ? null : new BigDecimal(val.toString()))
                            .orElse(null)
            );

        } catch (ParseException e) {
            return ConverterResult.failed(null, e.getMessage());
        }

    }
}
