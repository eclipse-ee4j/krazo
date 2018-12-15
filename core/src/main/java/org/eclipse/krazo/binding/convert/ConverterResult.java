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

import java.util.Objects;
import java.util.Optional;

/**
 * Returned from {@link MvcConverter} implementations. This class encapsulates the converted value and optional
 * error message. Please note that there is a result even in case of errors. See {@link MvcConverterProvider}
 * for details.
 *
 * @author Christian Kaltepoth
 */
public class ConverterResult<T> {

    private T value;
    private String error;

    private ConverterResult(T value, String error) {
        this.value = value;
        this.error = error;
    }

    public static <T> ConverterResult<T> success(T value) {
        return new ConverterResult<>(value, null);
    }

    public static <T> ConverterResult<T> failed(T value, String error) {
        return new ConverterResult<>(value, Objects.requireNonNull(error, "Error must not be null"));
    }

    public Object getValue() {
        return value;
    }

    public Optional<String> getError() {
        return Optional.ofNullable(error);
    }

}
