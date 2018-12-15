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
package org.eclipse.krazo.uri;

import org.eclipse.krazo.util.AnnotationUtils;

import javax.enterprise.inject.Vetoed;
import javax.mvc.UriRef;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>A cache for all parsed instances of {@link UriTemplate}
 * providing methods to generate URIs of current application.</p>
 *
 * @author Florian Hirsch
 */
@Vetoed // produced by UriTemplateParser
public class ApplicationUris {

    private MultivaluedMap<String, UriTemplate> uriTemplates = new MultivaluedHashMap<>();

    /**
     * @see javax.mvc.MvcContext#uri(String)
     */
    public URI get(String identifier) {
        return getUriBuilder(identifier).build();
    }

    /**
     * @see javax.mvc.MvcContext#uri(String, Map)
     */
    public URI get(String identifier, Map<String, Object> params) {
        UriTemplate uriTemplate = getUriTemplate(identifier);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriTemplate.path());
        Map<String, Object> pathParams = new HashMap<>();
        // Everything which is not defined as query- or matrix-param should be a path-param
        params.forEach((key, value) -> {
            if (uriTemplate.queryParams().contains(key)) {
                uriBuilder.queryParam(key, value);
            } else if (uriTemplate.matrixParams().contains(key)) {
                uriBuilder.matrixParam(key, value);
            } else {
                pathParams.put(key, value);
            }
        });
        return uriBuilder.buildFromMap(pathParams);
    }

    /**
     * @see javax.mvc.MvcContext#uriBuilder(String)
     */
    public UriBuilder getUriBuilder(String identifier) {
        UriTemplate uriTemplate = getUriTemplate(identifier);
        return UriBuilder.fromUri(uriTemplate.path());
    }

    /**
     * <p>Registers given uriTemplate by the value of
     * the {@link UriRef} annotation if present on given method
     * <em>and</em> by the simple name of the controller class
     * and the method name separated by '#' (MyController#myMethod).</p>
     *
     * <p>We don't validate ambigous usage of e.g. MyController#myMethod as this
     * is valid if mvc#uri methods are not used.</p>
     */
    void register(UriTemplate uriTemplate, Method method) {
        UriRef uriRef = AnnotationUtils.getAnnotation(method, UriRef.class);
        if (uriRef != null) {
            merge(uriRef.value(), uriTemplate);
        }
        String identifier = String.format("%s#%s", method.getDeclaringClass().getSimpleName(), method.getName());
        merge(identifier, uriTemplate);
    }

    /**
     * <p>Merges given UriTemplate into the Cache.
     * If one or more templates for given identifier is found
     * we check if the exisiting templates have the same path.
     * If so we merge the optional query- and matrix params to the template.
     * It's valid to reuse an identifier for the same path for different HTTP methods.
     * If the pathes don't match the usage of the identifier is amigous and
     * we store both templates to inform the developer about all invalid usages.</p>
     */
    private void merge(String identifier, UriTemplate uriTemplate) {
        if (!uriTemplates.containsKey(identifier)) {
            uriTemplates.add(identifier, uriTemplate);
            return;
        }
        Optional<UriTemplate> existingTemplate = uriTemplates.get(identifier).stream().filter(template
            -> template.path().equals(uriTemplate.path())).findFirst();
        if (existingTemplate.isPresent()) {
            UriTemplate template = existingTemplate.get();
            template.queryParams().addAll(uriTemplate.queryParams());
            template.matrixParams().addAll(uriTemplate.matrixParams());
        } else {
            uriTemplates.add(identifier, uriTemplate);
        }
    }

    /**
     * @return the UriTemplate for given identifier from the cache.
     * @throws IllegalArgumentException if no UriTemplate
     * is found for given identifier or if ambiguously used
     * templates are found.
     */
    private UriTemplate getUriTemplate(String identifier) {
        Objects.requireNonNull(identifier, "identifier must not be null");
        if (!uriTemplates.containsKey(identifier)) {
            throw new IllegalArgumentException(
                String.format("No uriTemplate registered for identifier '%s'", identifier));
        }
        List<UriTemplate> registeredTemplats = uriTemplates.get(identifier);
        if (registeredTemplats.size() > 1) {
            throw new IllegalArgumentException(String.format(
                "Ambiguous usage of identifier '%s' for following URIs: %s", identifier,
                registeredTemplats.stream().map(UriTemplate::path).collect(Collectors.toList())));
        }
        return this.uriTemplates.getFirst(identifier);
    }

    /**
     * @return all registered UriTemplates with their identifier.
     */
    Set<Map.Entry<String, List<UriTemplate>>> list() {
        return uriTemplates.entrySet();
    }

    @Override
    public String toString() {
        return "ApplicationUris{" + "uriTemplates=" + uriTemplates + '}';
    }

}
