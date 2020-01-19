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

import java.lang.annotation.Annotation;
import java.util.Locale;

/**
 * Interface for MVC specific converter implementations.
 *
 * {@link MvcConverter}s can be sorted by using the {@link javax.annotation.Priority} annotation on its implementation. In case there
 * is no {@link javax.annotation.Priority} annotation available, it assumes a priority of 0 (zero). All internal converter implementations
 * don't have a explicit priority set, so a custom converter can use any number greater than zero. There mustn't be a priority less than zero.
 * Custom converters are REQUIRED to have a {@link javax.annotation.Priority} set.
 *
 * @author Christian Kaltepoth
 */
public interface MvcConverter<T> {

    /**
     * Returns true if the converter supports the specified type or one of the annotations
     */
    boolean supports(Class<T> rawType, Annotation[] annotations);

    /**
     * Try to convert the value to the specified target type. Must only be called if
     * the converter returned true from {@link #supports(Class, Annotation[])} for the type.
     *
     * @param value   The value to convert
     * @param rawType The target type
     * @param annotations The annotations on the target attribute
     * @param locale  The request locale
     * @return The result of the conversion
     */
    ConverterResult<T> convert(String value, Class<T> rawType, Annotation[] annotations, Locale locale);
}
