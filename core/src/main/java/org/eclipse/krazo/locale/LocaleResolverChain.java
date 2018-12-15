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
package org.eclipse.krazo.locale;

import org.eclipse.krazo.jaxrs.JaxRsContext;
import org.eclipse.krazo.util.CdiUtils;
import org.eclipse.krazo.util.AnnotationUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.locale.LocaleResolver;
import javax.mvc.locale.LocaleResolverContext;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Configuration;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Implements the locale resolving algorithm described in {@link LocaleResolver}.
 *
 * @author Christian Kaltepoth
 */
@ApplicationScoped
public class LocaleResolverChain {

    @Inject
    @JaxRsContext
    private Configuration configuration;

    @PostConstruct
    public void verify() {
        Objects.requireNonNull(configuration, "The Configuration instance was not injected! " +
                "Please make sure you are using a recent version of Jersey.");
    }

    public Locale resolve(ContainerRequestContext requestContext) {

        // prepare context instance
        LocaleResolverContext context = new LocaleResolverContextImpl(configuration, requestContext);

        List<LocaleResolver> resolvers = CdiUtils.getApplicationBeans(LocaleResolver.class);

        // candidates as sorted list
        List<LocaleResolver> candidates = StreamSupport.stream(resolvers.spliterator(), false)
                .sorted((resolver1, resolver2) -> {
                    final Priority prio1 = getAnnotation(resolver1.getClass(), Priority.class);
                    final Priority prio2 = getAnnotation(resolver2.getClass(), Priority.class);
                    final int value1 = prio1 != null ? prio1.value() : 1000;
                    final int value2 = prio2 != null ? prio2.value() : 1000;
                    return value2 - value1;
                })
                .collect(Collectors.toList());

        // do the resolving
        for (LocaleResolver candidate : candidates) {
            Locale locale = candidate.resolveLocale(context);
            if (locale != null) {
                return locale;
            }
        }

        throw new IllegalStateException("Could not resolve locale with any of the " + candidates.size()
                + " resolver implementations");

    }

    /**
     * It looks like {@link AnnotationUtils#getAnnotation(Class, Class)}
     * still doesn't handle proxies correctly. This method handles proxies correctly
     * but unfortunately only works with Weld.
     */
    private <T extends Annotation> T getAnnotation(Class<?> clazz, Class<T> annotationType) {
        if (clazz.getName().endsWith("$$_WeldClientProxy")) {
            return clazz.getSuperclass().getAnnotation(annotationType);
        }
        return clazz.getAnnotation(annotationType);
    }

}
