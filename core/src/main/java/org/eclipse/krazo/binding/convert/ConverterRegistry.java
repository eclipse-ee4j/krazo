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
package org.eclipse.krazo.binding.convert;

import org.eclipse.krazo.binding.convert.impl.BooleanConverter;
import org.eclipse.krazo.binding.convert.impl.DoubleConverter;
import org.eclipse.krazo.binding.convert.impl.FloatConverter;
import org.eclipse.krazo.binding.convert.impl.IntegerConverter;
import org.eclipse.krazo.binding.convert.impl.LongConverter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Central registry for {@link MvcConverter} instances.
 *
 * @author Christian Kaltepoth
 */
@ApplicationScoped
public class ConverterRegistry {

    private final List<MvcConverter> converters = new ArrayList<>();

    @PostConstruct
    public void init() {
        register(new IntegerConverter());
        register(new LongConverter());
        register(new DoubleConverter());
        register(new FloatConverter());
        register(new BooleanConverter());
    }

    private void register(MvcConverter converter) {
        converters.add(converter);
    }

    <T> MvcConverter<T> lookup(Class<T> rawType, Annotation[] annotations) {
        return converters.stream()
                .filter(converter -> converter.supports(rawType))
                .findFirst().orElse(null);
    }

}
