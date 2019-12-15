/*
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
package org.eclipse.krazo.binding.convert;

import java.util.Locale;

/**
 * Interface for MVC specific converter implementations.
 *
 * @author Christian Kaltepoth
 */
public interface MvcConverter<T> {

    /**
     * The common priority for built-in converters.
     */
    int BUILT_IN_PRIORITY = 0;

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

    /**
     * Return the priority of a {@link MvcConverter}. Converters with a higher priority (= higher number) are evaluated
     * before those with a lower one. So for example, a built-in converter with the priority 0 is evaluated after
     * a custom converter with priority 10.
     * <br><br>
     * <b>Note:</b> It is assumed that all built-in converters have a common, very low priority, so a client is free to prioritize
     * its converters as he wants (@see {@link MvcConverter#BUILT_IN_PRIORITY}).
     *
     * @return the priority of the {@link MvcConverter}
     */
    int getPriority();
}
