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

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class PebbleConfigurationProducerTest {

    PebbleConfigurationProducer pebbleConfigurationProducer;

    @Before
    public void setup() {
        pebbleConfigurationProducer = new PebbleConfigurationProducer();
        System.clearProperty(PebbleProperty.AUTO_ESCAPING.key());
    }

    @Test
    public void shouldReturnEmptyPropertiesForNonExistingPropertiesFile() {
        Properties pebbleConfiguration = pebbleConfigurationProducer.loadFromFile("unexisting.properties");

        assertNotNull(pebbleConfiguration);
        assertTrue(pebbleConfiguration.isEmpty());
    }

    @Test
    public void shouldLoadPebbleConfigurationPropertiesFromFile() {
        Properties pebbleConfiguration = pebbleConfigurationProducer.loadFromFile("pebble.properties");

        assertNotNull(pebbleConfiguration);
        assertEquals(pebbleConfiguration.getProperty("org.eclipse.krazo.ext.pebble.autoEscaping"), "true");
    }

    @Test
    public void shouldReturnPebbleConfiguration() {
        Properties pebbleConfiguration = pebbleConfigurationProducer.pebbleConfiguration();

        assertNotNull(pebbleConfiguration);
        assertEquals(pebbleConfiguration.getProperty("org.eclipse.krazo.ext.pebble.autoEscaping"), "true");
    }

    @Test
    public void systemPropertyShouldHaveHigherPriorityThanTheOneFromPropertyFile() {
        System.setProperty(PebbleProperty.AUTO_ESCAPING.key(), "false-override");

        Properties pebbleConfiguration = pebbleConfigurationProducer.pebbleConfiguration();

        assertNotNull(pebbleConfiguration);
        assertEquals(pebbleConfiguration.getProperty(PebbleProperty.AUTO_ESCAPING.key()), "false-override");
    }
}
