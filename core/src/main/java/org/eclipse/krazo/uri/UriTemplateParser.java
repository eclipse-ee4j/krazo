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
package org.eclipse.krazo.uri;

import org.eclipse.krazo.servlet.KrazoContainerInitializer;
import org.eclipse.krazo.util.AnnotationUtils;
import org.eclipse.krazo.util.BeanUtils;
import org.eclipse.krazo.util.ControllerUtils;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.mvc.MvcContext;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.UriBuilder;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * <p>Parses all instances of {@link UriTemplate} and @Produces
 * the {@link ApplicationUris}.</p>
 *
 * @author Florian Hirsch
 */
@ApplicationScoped
public class UriTemplateParser {

    @Inject
    MvcContext mvcContext;

    @Inject
    private ServletContext servletContext;

    @Produces
    @ApplicationScoped
    private ApplicationUris applicationUris;

    @PostConstruct
    public void init() {

        Set<Class<?>> controllerClasses =
                (Set<Class<?>>) servletContext.getAttribute(KrazoContainerInitializer.CONTROLLER_CLASSES);

        applicationUris = init(controllerClasses != null ? controllerClasses : Collections.emptySet());

    }

    ApplicationUris init(Set<Class<?>> controllers) {
        ApplicationUris uris = new ApplicationUris();
        controllers.forEach(controller ->
                Stream.of(controller.getMethods()).filter(ControllerUtils::isControllerMethod).forEach(method -> {
                    UriTemplate uriTemplate = parseMethod(method, mvcContext.getBasePath());
                    uris.register(uriTemplate, method);
                })
        );
        return uris;
    }

    /**
     * <p>Parses given method and constructs a {@link UriTemplate} containing
     * all the information found in the annotations {@link jakarta.ws.rs.Path},
     * {@link jakarta.ws.rs.QueryParam} and {@link jakarta.ws.rs.MatrixParam}.</p>
     */
    UriTemplate parseMethod(Method method, String basePath) {
        UriBuilder uriBuilder = UriBuilder.fromPath(basePath);
        Path controllerPath = AnnotationUtils.getAnnotation(method.getDeclaringClass(), Path.class);
        if (controllerPath != null) {
            uriBuilder.path(controllerPath.value());
        }
        Path methodPath = AnnotationUtils.getAnnotation(method, Path.class);
        if (methodPath != null) {
            uriBuilder.path(methodPath.value());
        }
        UriTemplate.Builder uriTemplateBuilder = UriTemplate.fromTemplate(uriBuilder.toTemplate());
        // Populate a List with all properties of given target and all parameters of given method
        // except for BeanParams where we need all properties of annotated type.
        List<AnnotatedElement> annotatedElements = BeanUtils.getFieldsAndAccessors(method.getDeclaringClass());
        Arrays.asList(method.getParameters()).forEach(param -> {
            if (param.isAnnotationPresent(BeanParam.class)) {
                annotatedElements.addAll(BeanUtils.getFieldsAndAccessors(param.getType()));
            } else {
                annotatedElements.add(param);
            }
        });
        annotatedElements.forEach(accessibleObject -> {
            if (accessibleObject.isAnnotationPresent(QueryParam.class)) {
                uriTemplateBuilder.queryParam(accessibleObject.getAnnotation(QueryParam.class).value());
            }
            if (accessibleObject.isAnnotationPresent(MatrixParam.class)) {
                uriTemplateBuilder.matrixParam(accessibleObject.getAnnotation(MatrixParam.class).value());
            }
        });
        return uriTemplateBuilder.build();
    }

}
