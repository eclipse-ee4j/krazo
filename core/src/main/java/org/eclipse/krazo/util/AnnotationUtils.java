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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Utility methods to lookup annotations.
 *
 * @author Santiago Pericas-Geertsen
 * @author Eddú Meléndez
 */
public final class AnnotationUtils {

    /**
     * Retrieve an annotation from a possibly proxied CDI/Weld class. First inspect
     * the class and if that fails, try using an annotated type obtained from CDI's
     * bean manager.
     *
     * @param clazz          class to search annotation.
     * @param annotationType type of annotation to search for.
     * @param <T> annotation subclass.
     * @return annotation instance or {@code null} if none found.
     */
    public static <T extends Annotation> T getAnnotation(Class<?> clazz, Class<T> annotationType) {
        T an = clazz.getDeclaredAnnotation(annotationType);
        if (an == null && isProxy(clazz)) {
            an = clazz.getSuperclass().getDeclaredAnnotation(annotationType);
        }
        return an;
    }

    /**
     * Checks if the supplied type is a proxy. This method works with both
     * Weld and OpenWebBeans.
     *
     * @param clazz Type to check
     * @return whether the class is a proxy or not
     */
    private static boolean isProxy(Class<?> clazz) {
        Class<?> parent = clazz.getSuperclass();
        if (parent != null) {
            return clazz.getName().contains("$$") && clazz.getName().startsWith(parent.getName());
        }
        return false;
    }

    /**
     * Determines if an annotation is present on a class by calling {@link #getAnnotation(Class, Class)}.
     *
     * @param clazz class to search annotation.
     * @param annotationType type of annotation to search for.
     * @param <T> annotation subclass.
     * @return outcome of test.
     */
    public static <T extends Annotation> boolean hasAnnotation(Class<?> clazz, Class<T> annotationType) {
        return getAnnotation(clazz, annotationType) != null;
    }

    /**
     * Search for a method annotation following the inheritance rules defined by the
     * JAX-RS specification, and also stated in the MVC specification. If an annotation is
     * not defined on a method, check super methods along the class hierarchy first. If
     * not found, then look at the interface hierarchy. Note that this method implements
     * a depth-first search strategy.
     *
     * @param method method to start search at.
     * @param annotationType annotation class to search for.
     * @param <T> annotation subclass.
     * @return annotation instances or {@code null} if not found.
     */
    public static <T extends Annotation> T getAnnotation(Method method, Class<T> annotationType) {
        // If we reached Object.class, we couldn't find it
        final Class<?> clazz = method.getDeclaringClass();
        if (clazz == Object.class) {
            return null;
        }

        // Check if annotation declared (but not inherited) on method
        T an = method.getDeclaredAnnotation(annotationType);
        if (an != null) {
            return an;
        }

        // Other MVC annotations on this method, then inheritance disabled
        if (hasMvcOrJaxrsAnnotations(method)) {
            return null;
        } else {
            // Search for overridden method in super class
            final Class<?> superClass = method.getDeclaringClass().getSuperclass();
            if (superClass != null) {
                try {
                    final Method superMethod = superClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
                    an = getAnnotation(superMethod, annotationType);
                } catch (NoSuchMethodException e) { // NOPMD ignore empty catch block
                    // falls through
                }
                if (an != null) {
                    return an;
                }
            }

            // Now search for overridden method in super interfaces
            final Class<?>[] interfaces = method.getDeclaringClass().getInterfaces();
            for (Class<?> in : interfaces) {
                try {
                    final Method superMethod = in.getDeclaredMethod(method.getName(), method.getParameterTypes());
                    an = getAnnotation(superMethod, annotationType);
                } catch (NoSuchMethodException e) { // NOPMD ignore empty catch block
                    // falls through
                }
                if (an != null) {
                    return an;
                }
            }

            // Not found, return null
            return null;
        }
    }

    /**
     * Determines if an annotation is present on a method by calling
     * {@link #getAnnotation(java.lang.reflect.Method, Class)}.
     *
     * @param <T> the type.
     * @param method method to start search at..
     * @param annotationType type of annotation to search for.
     * @return outcome of test.
     */
    public static <T extends Annotation> boolean hasAnnotation(Method method, Class<T> annotationType) {
        return getAnnotation(method, annotationType) != null;
    }

    /**
     * Determines if an annotation is present on a class or its methods by calling {@link #getAnnotation(Class, Class)}
     * and {@link #getAnnotation(java.lang.reflect.Method, Class)} iteratively.
     *
     * @param <T> the type.
     * @param clazz class to search annotation.
     * @param annotationType type of annotation to search for.
     * @return outcome of test.
     */
    public static <T extends Annotation> boolean hasAnnotationOnClassOrMethod(Class<?> clazz, Class<T> annotationType) {
        return hasAnnotation(clazz, annotationType)
                || Arrays.stream(clazz.getMethods()).anyMatch(m -> hasAnnotation(m, annotationType));
    }

    /**
     * Determines if a method has one or more MVC or JAX-RS annotations on it.
     *
     * @param method method to check for MVC or JAX-RS annotations.
     * @return outcome of test.
     */
    static boolean hasMvcOrJaxrsAnnotations(Method method) {
        return Arrays.stream(method.getDeclaredAnnotations()).anyMatch(a -> {
            final String an = a.annotationType().getName();
            return an.startsWith("javax.mvc.") || an.startsWith("javax.ws.rs.");
        });
    }
}
