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
package org.eclipse.krazo.core;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Models;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Implementation of {@link javax.mvc.Models} interface. A CDI class that delegates
 * to a {@link java.util.Map} implementation.
 *
 * @author Santiago Pericas-Geertsen
 * @author Christian Kaltepoth
 */
@RequestScoped
public class ModelsImpl implements Models {

    private final Map<String, Object> map = new LinkedHashMap<>();

    @Override
    public Models put(String name, Object model) {
        Objects.requireNonNull(name, "Name must not be null");
        map.put(name, model);
        return this;
    }

    @Override
    public Object get(String name) {
        return get(name, Object.class);
    }

    @Override
    public <T> T get(String name, Class<T> type) {
        Objects.requireNonNull(name, "Name must not be null");
        Objects.requireNonNull(type, "Type must not be null");
        return type.cast(map.get(name));
    }

    @Override
    public Map<String, Object> asMap() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(map));
    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }
}
