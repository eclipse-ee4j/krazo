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
package org.eclipse.krazo.binding.convert;

import java.util.Locale;

/**
 * Interface for MVC specific converter implementations.
 *
 * @author Christian Kaltepoth
 */
public interface MvcConverter<T> {

    /**
     * Returns true if the converter supports the specified type.
     */
    boolean supports(Class<T> rawType);

    /**
     * Try to convert the value to the specified target type. Must only be called if
     * the converter returned true from {@link #supports(Class)} for the type.
     *
     * @param value   The value to convert
     * @param rawType The target type
     * @param locale  The request locale
     * @return The result of the conversion
     */
    ConverterResult<T> convert(String value, Class<T> rawType, Locale locale);

}
