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
import org.eclipse.krazo.binding.convert.MvcConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.annotation.Annotation;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * @author Gregor Tudan
 */
@RunWith(Parameterized.class)
public abstract class ConversionTest<T> {
    private final MvcConverter<T> converter;
    private Class<T> clazz;

    @Parameterized.Parameter(0)
    public String value;
    @Parameterized.Parameter(1)
    public T convertedValue;
    @Parameterized.Parameter(2)
    public boolean isError;

    ConversionTest(MvcConverter<T> converter, Class<T> clazz) {
        this.converter = converter;
        this.clazz = clazz;
    }

    @Test
    public void testConversionErrors() {
        ConverterResult<T> converterResult = converter.convert(value, clazz, new Annotation[] {}, Locale.ENGLISH);

        assertEquals(convertedValue, converterResult.getValue());
        if (isError) {
            assertTrue(converterResult.getError().isPresent());
            assertFalse(converterResult.getError().get().isEmpty());
        } else {
            assertFalse(converterResult.getError().isPresent());
        }
    }
}
