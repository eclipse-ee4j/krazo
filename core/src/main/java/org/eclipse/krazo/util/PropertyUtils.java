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
package org.eclipse.krazo.util;

import javax.ws.rs.core.Configuration;

/**
 * Utility methods for properties.
 *
 * @author Santiago Pericas-Geertsen
 */
public final class PropertyUtils {

    /**
     * Search for a property and return a default value if not found. Value
     * returned is of same type as default value.
     *
     * @param config configuration to search for property.
     * @param name property name.
     * @param defaultValue default value.
     * @param <T> type of default and return value.
     * @return property or default value.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getProperty(Configuration config, String name, T defaultValue) {
        final Object obj = config.getProperty(name);
        return obj != null ? (T) obj : defaultValue;
    }
}
