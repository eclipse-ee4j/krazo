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
package org.eclipse.krazo.binding.validate;

import javax.validation.ConstraintViolation;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Encapsulates metadata about the property or method parameter that caused a constraint violation exception.
 *
 * @author Christian Kaltepoth
 */
public class ConstraintViolationMetadata {

    private final ConstraintViolation<?> violation;
    private final Annotation[] annotations;

    public ConstraintViolationMetadata(ConstraintViolation<?> violation, Annotation[] annotations) {
        this.violation = Objects.requireNonNull(violation, "violations");
        this.annotations = Objects.requireNonNull(annotations, "annotations");
    }

    public Optional<Annotation> getAnnotation(Class<Annotation> type) {
        return Arrays.stream(annotations).filter(a -> a.annotationType().equals(type)).findFirst();
    }

    public boolean hasAnnotation(Class<? extends Annotation> type) {
        return Arrays.stream(annotations).anyMatch(a -> a.annotationType().equals(type));
    }

    public Optional<String> getParamName() {
        for (Annotation annotation : annotations) {
            if (annotation instanceof QueryParam) {
                return Optional.of(((QueryParam) annotation).value());
            }
            if (annotation instanceof PathParam) {
                return Optional.of(((PathParam) annotation).value());
            }
            if (annotation instanceof FormParam) {
                return Optional.of(((FormParam) annotation).value());
            }
            if (annotation instanceof MatrixParam) {
                return Optional.of(((MatrixParam) annotation).value());
            }
            if (annotation instanceof CookieParam) {
                return Optional.of(((CookieParam) annotation).value());
            }
        }
        return Optional.empty();
    }

}
