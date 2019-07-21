/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.krazo.ext.pebble;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PebblePropertyTest {

    @Test
    public void propertyKeyShouldStartWithGroupPrefix() {
        final String groupPrefix = "org.eclipse.krazo.ext.pebble.";

        Stream.of(PebbleProperty.values()).forEach(property -> {
            assertTrue(property.key().startsWith(groupPrefix));
        });
    }

    @Test
    public void shouldResolvePebblePropertyFromStringKey() {
        Stream.of(PebbleProperty.values()).forEach(property -> {
            assertEquals(property, PebbleProperty.fromKey(property.key()));
        });
    }

    @Test
    public void shouldReturnSystemPropertyValueAsOptional() {
        System.setProperty(PebbleProperty.STRICT_VARIABLES.key(), "false");

        assertEquals("false", PebbleProperty.STRICT_VARIABLES.systemPropertyValue().get());
        assertFalse(PebbleProperty.NEW_LINE_TRIMMING.systemPropertyValue().isPresent());
    }
}
