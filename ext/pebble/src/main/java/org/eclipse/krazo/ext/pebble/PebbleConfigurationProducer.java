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

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Stream;

@ApplicationScoped
public class PebbleConfigurationProducer {

    @Produces
    public Properties pebbleConfiguration() {
        Properties pebbleProperties = loadFromFile("pebble.properties");

        Stream.of(PebbleProperty.values())
            .forEach(property
                -> property.systemPropertyValue().ifPresent(value -> pebbleProperties.put(property.key(), value))
            );

        return pebbleProperties;
    }

    public Properties loadFromFile(String fileName) {
        Properties props = new Properties();

        try (InputStream config = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            if (Objects.nonNull(config)) {
                props.load(config);
            }
        } catch (IOException e) {
            // ignore exception
        }

        return props;
    }

}
