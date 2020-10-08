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
package org.eclipse.krazo.binding.convert;

import org.eclipse.krazo.binding.BindingErrorImpl;
import org.eclipse.krazo.binding.BindingResultImpl;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.mvc.MvcContext;
import jakarta.mvc.binding.MvcBinding;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.stream.Stream;

/**
 * Implementation if the JAX-RS {@link ParamConverterProvider} contract which delegates conversion
 * to the custom implementations for MVC.
 *
 * @author Christian Kaltepoth
 */
@Priority(0)  // should be preferred over builtin providers
public class MvcConverterProvider implements ParamConverterProvider {

    @Inject
    private ConverterRegistry converterRegistry;

    @Inject
    private MvcContext mvcContext;

    @Inject
    private BindingResultImpl bindingResult;

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {

        MvcBinding mvcBinding = (MvcBinding) Stream.of(annotations != null ? annotations : new Annotation[0])
                .filter(a -> a.annotationType().equals(MvcBinding.class))
                .findFirst()
                .orElse(null);

        if (mvcBinding != null) {

            MvcConverter<T> mvcConverter = converterRegistry.lookup(rawType, annotations);

            if (mvcConverter != null) {

                return new ParamConverter<T>() {

                    @Override
                    public T fromString(String value) {

                        // execute the converter
                        ConverterResult<T> result = mvcConverter.convert(value, rawType, annotations, mvcContext.getLocale());

                        // register possible errors in BindingResult
                        result.getError()
                                .map(error -> new BindingErrorImpl(error, getParamName(annotations), value))
                                .ifPresent(bindingError -> bindingResult.addBindingError(bindingError));

                        // always return a value so JAX-RS continues processing the request
                        return (T) result.getValue();

                    }

                    @Override
                    public String toString(T value) {
                        throw new UnsupportedOperationException();
                    }

                };

            }

        }
        return null;

    }

    // TODO: Duplicated in ConstraintViolationUtils
    private static String getParamName(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof QueryParam) {
                return ((QueryParam) annotation).value();
            }
            if (annotation instanceof PathParam) {
                return ((PathParam) annotation).value();
            }
            if (annotation instanceof FormParam) {
                return ((FormParam) annotation).value();
            }
            if (annotation instanceof MatrixParam) {
                return ((MatrixParam) annotation).value();
            }
            if (annotation instanceof CookieParam) {
                return ((CookieParam) annotation).value();
            }
        }
        return null;
    }
}

