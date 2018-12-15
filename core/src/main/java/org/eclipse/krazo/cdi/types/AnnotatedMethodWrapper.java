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

import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedParameter;
import javax.enterprise.inject.spi.AnnotatedType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Custom AnnotatedMethod implementation which wraps an existing instance and allows
 * to add additional annotations.
 *
 * @author Christian Kaltepoth
 */
public class AnnotatedMethodWrapper<T> implements AnnotatedMethod<T> {

    private final AnnotatedMethod<T> wrapped;

    private final Set<Annotation> annotations = new LinkedHashSet<>();

    public AnnotatedMethodWrapper(AnnotatedMethod<T> wrapped,
                                  Set<Annotation> additionalAnnotations,
                                  Predicate<Class> annotationBlacklist) {

        this.wrapped = wrapped;

        // add annotations which are not blacklisted
        this.annotations.addAll(
                wrapped.getAnnotations().stream()
                        .filter(a -> !annotationBlacklist.test(a.annotationType()))
                        .collect(Collectors.toList())
        );

        // add additional annotations
        this.annotations.addAll(additionalAnnotations);

    }

    @Override
    public Method getJavaMember() {
        return wrapped.getJavaMember();
    }

    @Override
    public boolean isStatic() {
        return wrapped.isStatic();
    }

    @Override
    public AnnotatedType<T> getDeclaringType() {
        return wrapped.getDeclaringType();
    }

    @Override
    public List<AnnotatedParameter<T>> getParameters() {
        return wrapped.getParameters();
    }

    @Override
    public Type getBaseType() {
        return wrapped.getBaseType();
    }

    @Override
    public Set<Type> getTypeClosure() {
        return wrapped.getTypeClosure();
    }

    @Override
    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(annotationType)) {
                return annotationType.cast(annotation);
            }
        }
        return null;
    }

    @Override
    public Set<Annotation> getAnnotations() {
        return Collections.unmodifiableSet(annotations);
    }

    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        return getAnnotation(annotationType) != null;
    }

}
