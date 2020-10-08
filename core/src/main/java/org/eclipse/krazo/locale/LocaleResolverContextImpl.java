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

import jakarta.mvc.locale.LocaleResolverContext;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Locale;

/**
 * Implementation of the {@link LocaleResolverContext} interface.
 *
 * @author Christian Kaltepoth
 */
public class LocaleResolverContextImpl implements LocaleResolverContext {

    private final Configuration config;
    private final ContainerRequestContext context;

    public LocaleResolverContextImpl(Configuration config, ContainerRequestContext context) {
        this.config = config;
        this.context = context;
    }

    @Override
    public Configuration getConfiguration() {
        return config;
    }

    @Override
    public List<Locale> getAcceptableLanguages() {
        return context.getAcceptableLanguages();
    }

    @Override
    public Request getRequest() {
        return context.getRequest();
    }

    @Override
    public UriInfo getUriInfo() {
        return context.getUriInfo();
    }

    @Override
    public Cookie getCookie(String name) {
        return context.getCookies().get(name);
    }

    @Override
    public String getHeaderString(String name) {
        return context.getHeaderString(name);
    }

}
