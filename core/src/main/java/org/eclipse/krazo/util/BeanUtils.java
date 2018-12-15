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

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for Bean related tasks
 *
 * @author Florian Hirsch
 */
public final class BeanUtils {

    private BeanUtils() {

    }

    /**
     * @return a List of all fields and getters/setters of given class.
     */
    public static List<AnnotatedElement> getFieldsAndAccessors(Class<?> clazz) {
        List<AnnotatedElement> properties = new ArrayList<>();
        properties.addAll(Arrays.stream(clazz.getDeclaredFields()).filter(f -> !f.isSynthetic()).collect(Collectors.toList()));
        try {
            Arrays.asList(Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors()).forEach(prop -> {
                if (prop.getReadMethod() != null) {
                    properties.add(prop.getReadMethod());
                }
                if (prop.getWriteMethod() != null) {
                    properties.add(prop.getWriteMethod());
                }
            });
        } catch (IntrospectionException ex) {
            throw new IllegalArgumentException(String.format("Could not parse properties from class %s", clazz), ex);
        }
        return properties;
    }

}
