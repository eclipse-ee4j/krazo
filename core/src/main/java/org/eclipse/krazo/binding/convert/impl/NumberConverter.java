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
package org.eclipse.krazo.binding.convert.impl;

import org.eclipse.krazo.binding.convert.MvcConverter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;

abstract class NumberConverter<T extends Number> implements MvcConverter<T> {

    Number parseNumber(String value, Locale locale) throws ParseException {

        if (value != null && !value.trim().isEmpty()) {

            ParsePosition parsePosition = new ParsePosition(0);
            NumberFormat numberFormat = NumberFormat.getInstance(locale);

            Number result = numberFormat.parse(value.trim(), parsePosition);

            if (value.trim().length() != parsePosition.getIndex()) {
                throw new ParseException("Not a valid number: " + value.trim(), parsePosition.getIndex());
            }

            return result;

        }
        return null;

    }
}
