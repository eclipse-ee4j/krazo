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
package org.eclipse.krazo.cdi.types;

import org.eclipse.krazo.binding.validate.ValidationInterceptorBinding;

import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.mvc.Controller;
import javax.ws.rs.*;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class can create a modified version of a AnnotatedType to inject custom behavior
 * into controllers.
 *
 * @author Christian Kaltepoth
 */
public class AnnotatedTypeProcessor {

    private static final Logger log = Logger.getLogger(AnnotatedTypeProcessor.class.getName());

    public <T> AnnotatedType<T> getReplacement(AnnotatedType<T> originalType) {

        boolean modified = false;
        Set<AnnotatedMethod<? super T>> methods = new LinkedHashSet<>();

        for (AnnotatedMethod<? super T> originalMethod : originalType.getMethods()) {
            AnnotatedMethod<? super T> replacement = getReplacement(originalType, originalMethod);
            if (replacement != null) {
                methods.add(replacement);
                modified = true;
            } else {
                methods.add(originalMethod);
            }
        }

        if (modified) {
            return new AnnotatedTypeWrapper<T>(originalType, methods);
        }
        return null;

    }

    private <T> AnnotatedMethod<? super T> getReplacement(AnnotatedType<T> type,
                                                          AnnotatedMethod<? super T> method) {

        boolean isResourceMethod = method.getAnnotation(GET.class) != null ||
            method.getAnnotation(POST.class) != null || method.getAnnotation(PUT.class) != null ||
            method.getAnnotation(HEAD.class) != null || method.getAnnotation(DELETE.class) != null;

        boolean hasControllerAnnotation =
            method.getAnnotation(Controller.class) != null || type.getAnnotation(Controller.class) != null;

        // added to methods to intercept calls with our validation interceptor
        Set<Annotation> markerAnnotations = Collections.singleton(() -> ValidationInterceptorBinding.class);

        // drop Hibernate Validator's marker annotations to skip the native validation
        Predicate<Class> annotationBlacklist = clazz -> isHibernateValidatorMarkerAnnotation(clazz);

        if (isResourceMethod && hasControllerAnnotation) {

            log.log(Level.FINE, "Found controller method: {0}#{1}", new Object[]{
                type.getJavaClass().getName(),
                method.getJavaMember().getName()
            });

            return new AnnotatedMethodWrapper<>(method, markerAnnotations, annotationBlacklist);

        }

        return null;

    }

    private boolean isHibernateValidatorMarkerAnnotation(Class clazz) {
        /*
         * May be one of these classes depending on the exact Hibernate Validator version:
         * org.hibernate.validator.cdi.internal.interceptor.MethodValidated
         * org.hibernate.validator.internal.cdi.interceptor.MethodValidated
         */
        return clazz.getName().startsWith("org.hibernate.validator.")
                && clazz.getName().endsWith(".interceptor.MethodValidated");
    }

}
