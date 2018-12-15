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

import org.eclipse.krazo.MvcContextImpl;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import java.io.IOException;
import java.util.Locale;

/**
 * Implementation of {@link ContainerRequestFilter} responsible for the resolving
 * of the request locale.
 *
 * @author Christian Kaltepoth
 */
@PreMatching
@Priority(Priorities.HEADER_DECORATOR)
public class LocaleRequestFilter implements ContainerRequestFilter {

    @Inject
    private LocaleResolverChain localeResolverChain;

    @Inject
    private MvcContextImpl mvc;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // resolve the locale as described in the spec
        Locale locale = localeResolverChain.resolve(requestContext);

        // update the MvcContext
        mvc.setLocale(locale);

    }

}
