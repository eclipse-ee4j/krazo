/*
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
package org.eclipse.krazo.util;

import org.eclipse.krazo.bootstrap.ConfigProvider;

import javax.annotation.Priority;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Utility code for the {@link ServiceLoader} class.
 *
 * @author Christian Kaltepoth
 */
public class ServiceLoaders {

    private ServiceLoaders() {
        // only static methods
    }

    public static <T> List<T> list(Class<T> type) {

        // classloader to use for ServiceLoader lookups
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        /*
         * Special workaround for TomEE . The context classloader is an instance of CxfContainerClassLoader
         * and NOT the TomEEWebappClassLoader, which seems to break when redeploying apps into a running
         * container for some reason.
         */
        if (classLoader.getClass().getName().contains("CxfContainerClassLoader")) {
            classLoader = ConfigProvider.class.getClassLoader();
        }

        // return the SPI implementations as a list
        return StreamSupport.stream(ServiceLoader.load(type, classLoader).spliterator(), false)
            .sorted(new PriorityComparator())
            .collect(Collectors.toList());
    }

    /**
     * Sorts objects by their {@link Priority} annotation. Defaults to 0 if the class is not annotated.
     */
    private static class PriorityComparator implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {
            // Reverse the objects, as we need reverse order (0 being the lowest priority)
            return Integer.compare(getPriority(o2), getPriority(o1));
        }

        private int getPriority(Object o) {
            Priority priority = o.getClass().getAnnotation(Priority.class);
            if (priority != null) {
                return priority.value();
            } else {
                return 0;
            }
        }
    }


}
