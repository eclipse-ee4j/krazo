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

import org.eclipse.krazo.binding.convert.ConverterResult;
import org.eclipse.krazo.binding.convert.MvcConverter;

import java.util.Locale;

/**
 * Converter for boolean primitive or wrapper types.
 *
 * @author Christian Kaltepoth
 */
public class BooleanConverter implements MvcConverter<Boolean> {

    @Override
    public boolean supports(Class<Boolean> rawType) {
        return Boolean.class.equals(rawType) || Boolean.TYPE.equals(rawType);
    }

    @Override
    public ConverterResult<Boolean> convert(String value, Class<Boolean> rawType, Locale locale) {

        String normalized = value != null ? value.trim().toLowerCase() : "";
        return ConverterResult.success("on".equals(normalized) || "true".equals(normalized));

    }
}
