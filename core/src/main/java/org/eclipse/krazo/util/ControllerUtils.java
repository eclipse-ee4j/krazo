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

import javax.mvc.Controller;
import javax.ws.rs.HttpMethod;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Utility class for controller related checks.
 *
 * @author Florian Hirsch
 */
public final class ControllerUtils {

    private ControllerUtils() {

    }

    /**
     * Tests if given class or any method of this class is annotated with @Controller.
     * Following the inheritance rules defined by the JAX-RS and MVC specification.
     */
    public static boolean isController(Class<?> clazz) {
        return AnnotationUtils.getAnnotation(clazz, Controller.class) != null ||
            Arrays.stream(clazz.getMethods()).anyMatch(m -> AnnotationUtils.getAnnotation(m, Controller.class) != null);
    }

    /**
     * Tests if given method is a controller and request method which is true
     * if a {@link Controller} annotation is found on given method or the declaring class
     * and if a {@link HttpMethod} annotated annotation is declared or inherited on this method.
     */
    public static boolean isControllerMethod(Method method) {
        boolean isController = AnnotationUtils.getAnnotation(method.getDeclaringClass(), Controller.class) != null
            || AnnotationUtils.getAnnotation(method, Controller.class) != null;
        return isController && isRequestMethod(method);
    }

    /**
     * Tests if a {@link HttpMethod} annotated annotation is declared or inherited on this method
     * following the inheritance rules defined by the MVC specification. If an annotation is
     * not defined on a method, check super methods along the class hierarchy first. If
     * not found, then look at the interface hierarchy. Note that this method implements
     * a depth-first search strategy.
     */
    static boolean isRequestMethod(Method method) {
        if (hasDeclaredRequestMethodAnnotation(method)) {
            return true;
        }
        // inheritance disabled if other MVC or JAX-RS annotations found
        if (AnnotationUtils.hasMvcOrJaxrsAnnotations(method)) {
            return false;
        }
        // check all super classes
        Class<?> clazz = method.getDeclaringClass();
        while (clazz != null) { // Object.class reached
            try {
                Method currentMethod = clazz.getMethod(method.getName(), method.getParameterTypes());
                if (hasDeclaredRequestMethodAnnotation(currentMethod)) {
                    return true;
                }
            } catch (NoSuchMethodException ignored) { // NOPMD ignore empty catch block
                // falls through
            }
            clazz = clazz.getSuperclass();
        }
        // check all interfaces
        for (Class<?> in : method.getDeclaringClass().getInterfaces()) {
            try {
                Method currentMethod = in.getMethod(method.getName(), method.getParameterTypes());
                if (hasDeclaredRequestMethodAnnotation(currentMethod)) {
                    return true;
                }
            } catch (NoSuchMethodException ignored) { // NOPMD ignore empty catch block
                // falls through
            }
        }
        return false;
    }

    /**
     * Tests if a {@link HttpMethod} annotated annotation is
     * directly present on given method without checking inheritance.
     */
    static boolean hasDeclaredRequestMethodAnnotation(Method method) {
        return Arrays.stream(method.getDeclaredAnnotations()).anyMatch(anno
            -> anno.annotationType().getAnnotation(HttpMethod.class) != null);
    }

}
