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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


/**
 * @author Gregor Tudan
 */
@RunWith(Enclosed.class)
public class BigDecimalConverterTest {

    public static class ConversionTests extends ConversionTest<BigDecimal> {

        public ConversionTests() {
            super(new BigDecimalConverter(), BigDecimal.class);
        }

        @Parameters(name = "{0} converts to {1}")
        public static List<Object[]> getParameters() {
            return Arrays.asList(
                new Object[]{"12", BigDecimal.valueOf(12), false},
                new Object[]{"12.2", BigDecimal.valueOf(12.2), false},
                new Object[]{"0", BigDecimal.ZERO, false},
                new Object[]{"-2", BigDecimal.valueOf(-2), false},
                new Object[]{"3E2", new BigDecimal("300"), false},
                new Object[]{"", null, false},
                new Object[]{"NaN", null, true},
                new Object[]{"asd", null, true},
                new Object[]{null, null, false}
            );
        }
    }

    public static class Supports extends SupportsTest<BigDecimal> {

        public Supports() {
            super(new BigDecimalConverter());
        }

        @Parameters(name = "supports {0} = {1}")
        public static List<Object[]> getParameters() {
            return Arrays.asList(
                new Object[]{BigDecimal.class, true},
                new Object[]{Number.class, false},
                new Object[]{Object.class, false},
                new Object[]{Float.class, false},
                new Object[]{List.class, false}
            );
        }
    }
}
