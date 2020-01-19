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
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Locale;

/**
 * Converter for double primitive or wrapper types.
 *
 * @author Christian Kaltepoth
 */
public class BigIntegerConverter extends NumberConverter<BigInteger> {

    @Override
    public boolean supports(Class<BigInteger> rawType, Annotation[] annotations) {
        return BigInteger.class.equals(rawType);
    }

    @Override
    public ConverterResult<BigInteger> convert(String value, Class<BigInteger> rawType, Annotation[] annotations, Locale locale) {

        try {

            return ConverterResult.success(
                    parseNumber(value, locale)
                            .map(val -> new BigInteger(val.toString()))
                            .orElse(null)
            );

        } catch (ParseException | NumberFormatException e) {
            return ConverterResult.failed(null, e.getMessage());
        }

    }
}
