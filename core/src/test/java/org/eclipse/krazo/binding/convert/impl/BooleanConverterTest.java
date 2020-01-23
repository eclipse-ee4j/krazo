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

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

/**
 * @author Gregor Tudan
 */
@RunWith(Enclosed.class)
public class BooleanConverterTest {

    public static class ConversionTests extends ConversionTest<Boolean> {

        public ConversionTests() {
            super(new BooleanConverter(), Boolean.class);
        }

        @Parameters(name = "{0} converts to {1}")
        public static List<Object[]> getParameters() {
            return Arrays.asList(
                new Object[]{"true", true, false},
                new Object[]{"TRUE", true, false},
                new Object[]{"on", true, false},
                new Object[]{"false", false, false},
                new Object[]{"off", false, false},
                new Object[]{"null", false, false},
                new Object[]{"baz", false, false},
                new Object[]{"", null, false},
                new Object[]{null, null, false}
            );
        }
    }

    public static class Supports extends SupportsTest<Boolean> {

        public Supports() {
            super(new BooleanConverter());
        }

        @Parameters(name = "supports {0} | {1} = {2}")
        public static List<Object[]> getParameters() {
            return Arrays.asList(
                new Object[]{Boolean.class, EMPTY_ANNOTATIONS, true},
                new Object[]{Integer.class, EMPTY_ANNOTATIONS, false},
                new Object[]{null, EMPTY_ANNOTATIONS, false}
            );
        }
    }
}
