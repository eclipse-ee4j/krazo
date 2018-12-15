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
package org.eclipse.krazo.test.locale;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.mvc.locale.LocaleResolver;
import javax.mvc.locale.LocaleResolverContext;
import java.util.List;
import java.util.Locale;

/**
 * Custom locale resolver
 *
 * @author Christian Kaltepoth
 */
@ApplicationScoped
@Priority(1000)  // = default priority for user provided resolvers
public class QueryLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(LocaleResolverContext context) {

        List<String> lang = context.getUriInfo().getQueryParameters().get("lang");
        if (lang != null && !lang.isEmpty()) {
            return new Locale(lang.get(0));
        }

        return null;

    }

}
