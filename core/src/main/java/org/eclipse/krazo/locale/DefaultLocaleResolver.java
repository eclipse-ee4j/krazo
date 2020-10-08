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
package org.eclipse.krazo.locale;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.mvc.locale.LocaleResolver;
import jakarta.mvc.locale.LocaleResolverContext;
import java.util.Locale;

/**
 * Default implementation of {@link LocaleResolver} as defined in the spec.
 *
 * @author Christian Kaltepoth
 */
@ApplicationScoped
@Priority(0)
public class DefaultLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(LocaleResolverContext context) {

        // Prefer language from "Accept-Language" header
        Locale clientLocale = context.getAcceptableLanguages().stream()
                .filter(l -> !"*".equals(l.getLanguage()))
                .findFirst()
                .orElse(null);
        if (clientLocale != null) {
            return clientLocale;
        }

        // Fallback to system default locale
        return Locale.getDefault();

    }

}
