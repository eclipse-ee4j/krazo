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
public class ShortConverterTest {

    public static class ConversionTests extends ConversionTest<Short> {

        public ConversionTests() {
            super(new ShortConverter(), Short.class);
        }

        @Parameters(name = "{0} converts to {1}")
        public static List<Object[]> getParameters() {
            return Arrays.asList(
                new Object[]{"12", (short) 12, false},
                new Object[]{"0", (short) 0, false},
                new Object[]{"-2", (short) -2, false},
                new Object[]{"3E2", (short) 300, false},
                new Object[]{"", null, false},
                new Object[]{null, null, false},
                new Object[]{"asd", null, true}
                // Flaky test: NaN resolves to 0 (java 11) or null (java 8) in the long-converter.
                // It triggers a binding error in java 8, but not in java 11
                //new Object[]{"NaN", null, false}
            );
        }
    }

    public static class Supports extends SupportsTest<Short> {

        public Supports() {
            super(new ShortConverter());
        }

        @Parameters(name = "supports {0} | {1} = {2}")
        public static List<Object[]> getParameters() {
            return Arrays.asList(
                new Object[]{Short.class, EMPTY_ANNOTATIONS, true},
                new Object[]{Number.class, EMPTY_ANNOTATIONS, false},
                new Object[]{Object.class, EMPTY_ANNOTATIONS, false},
                new Object[]{Double.class, EMPTY_ANNOTATIONS, false},
                new Object[]{List.class, EMPTY_ANNOTATIONS, false}
            );
        }
    }
}
