/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.krazo.engine;

import org.eclipse.krazo.util.CdiUtils;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.engine.ViewEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.eclipse.krazo.util.AnnotationUtils.getAnnotation;

/**
 * <p>Selects the view engine for a {@link Viewable}. If the viewable
 * includes a reference to an engine, the selection process stops and returns
 * it. Otherwise, the method {@link jakarta.mvc.engine.ViewEngine#supports(String)}
 * is called for each of the view engines injectable via CDI (i.e., all classes
 * that implement {@link jakarta.mvc.engine.ViewEngine}).</p>
 *
 * <p>The resulting set of candidates is sorted based on its priority as
 * defined by the annotation {@link jakarta.annotation.Priority} on the view engine
 * implementation.</p>
 *
 * <p>This class implements a simple cache to avoid repeated look-ups for the same
 * view.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @author Eddú Meléndez
 */
@ApplicationScoped
public class ViewEngineFinder {

    @Inject
    private CdiUtils cdiUtils;

    private final Map<String, ViewEngine> cache = new HashMap<>();

    /**
     * Finds view engine for a viewable.
     *
     * @param viewable the viewable to be used.
     * @return selected view engine or {@code null} if none found.
     */
    public ViewEngine find(Viewable viewable) {
        Optional<ViewEngine> engine;
        final String view = viewable.getView();

        // If engine specified in viewable, use it
        final Class<? extends ViewEngine> engineClass = viewable.getViewEngine();
        if (engineClass != null) {
            engine = Optional.of(cdiUtils.newBean(engineClass));
        } else {
            // Check cache first
            engine = Optional.ofNullable(cache.get(view));

            if (!engine.isPresent()) {
                List<ViewEngine> engines = CdiUtils.getApplicationBeans(ViewEngine.class);

                // Gather set of candidates
                final Set<ViewEngine> candidates = engines.stream()
                        .filter(e -> e.supports(view)).collect(toSet());

                // Find candidate with highest priority
                engine = candidates.stream().max(
                        (e1, e2) -> {
                            final Priority p1 = getAnnotation(e1.getClass(), Priority.class);
                            final int v1 = p1 != null ? p1.value() : ViewEngine.PRIORITY_APPLICATION;
                            final Priority p2 = getAnnotation(e2.getClass(), Priority.class);
                            final int v2 = p2 != null ? p2.value() : ViewEngine.PRIORITY_APPLICATION;
                            return v1 - v2;
                        });
                // Update cache
                engine.ifPresent(viewEngine -> cache.put(view, viewEngine));
            }
        }
        return engine.orElse(null);
    }
}
