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
package org.eclipse.krazo.binding.convert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Asserts that converters for all supported types have been registered
 * @author Gregor Tudan
 */
@RunWith(Parameterized.class)
public class ConverterRegistryTest {

    @Parameter
    public Class<Object> type;

    private ConverterRegistry registry;

    @Before
    public void setup() {
        registry = new ConverterRegistry();
        registry.init();
    }

    @Parameterized.Parameters(name = "test that {0} has a converter")
    public static Collection<Object> parameters() {
        return Arrays.asList(
            Short.class,
            Long.class,
            Integer.class,
            Long.class,
            Float.class,
            Double.class,
            BigInteger.class,
            BigDecimal.class
        );
    }

    @Test
    public void testConverterRegistered() {
        MvcConverter converter = registry.lookup(type);
        assertNotNull(converter);
    }
}
