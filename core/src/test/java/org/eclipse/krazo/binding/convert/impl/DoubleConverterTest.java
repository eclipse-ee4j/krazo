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
public class DoubleConverterTest {

    public static class ConversionTests extends ConversionTest<Double> {

        public ConversionTests() {
            super(new DoubleConverter(), Double.class);
        }

        @Parameters(name = "{0} converts to {1}")
        public static List<Object[]> getParameters() {
            return Arrays.asList(
                new Object[]{"12", 12d, false},
                new Object[]{"12.2", 12.2d, false},
                new Object[]{"0", 0d, false},
                new Object[]{"-2", -2d, false},
                new Object[]{"", null, false},
                new Object[]{"asd", null, true},
                new Object[]{null, null, false},
                new Object[]{"3E2", 300d, false}
                // Flaky test: NaN resolves to 0 (java 11) or null (java 8) in the long-converter.
                // It triggers a binding error in java 8, but not in java 11
                //new Object[]{"NaN", null, false}
            );
        }
    }

    public static class Supports extends SupportsTest<Double> {

        public Supports() {
            super(new DoubleConverter());
        }

        @Parameters(name = "supports {0} | {1} = {2}")
        public static List<Object[]> getParameters() {
            return Arrays.asList(
                new Object[]{Double.class, EMPTY_ANNOTATIONS, true},
                new Object[]{Number.class, EMPTY_ANNOTATIONS, false},
                new Object[]{Object.class, EMPTY_ANNOTATIONS, false},
                new Object[]{Float.class, EMPTY_ANNOTATIONS, false},
                new Object[]{List.class, EMPTY_ANNOTATIONS, false}
            );
        }
    }
}
