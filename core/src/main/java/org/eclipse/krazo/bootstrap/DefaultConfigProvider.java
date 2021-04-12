/*
 * Copyright (c) 2018, 2021 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.bootstrap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.krazo.binding.convert.MvcConverterProvider;
import org.eclipse.krazo.core.ViewResponseFilter;
import org.eclipse.krazo.core.ViewableWriter;
import org.eclipse.krazo.forms.HiddenMethodFilter;
import org.eclipse.krazo.jaxrs.PostMatchingRequestFilter;
import org.eclipse.krazo.jaxrs.PreMatchingRequestFilter;
import org.eclipse.krazo.security.CsrfExceptionMapper;
import org.eclipse.krazo.security.CsrfProtectFilter;
import org.eclipse.krazo.security.CsrfValidateFilter;

import jakarta.ws.rs.core.FeatureContext;

/**
 * Implementation of ConfigProvider which registers all providers of the core module.
 *
 * @author Christian Kaltepoth
 */
public class DefaultConfigProvider implements ConfigProvider {

    public static final Set<Class<?>> PROVIDERS = new HashSet<>(
        Arrays.asList(
            ViewResponseFilter.class,
            ViewableWriter.class,
            CsrfValidateFilter.class,
            CsrfProtectFilter.class,
            CsrfExceptionMapper.class,
            PreMatchingRequestFilter.class,
            PostMatchingRequestFilter.class,
            MvcConverterProvider.class,
            HiddenMethodFilter.class
        )
    );

    @Override
    public void configure(FeatureContext context) {
        PROVIDERS.forEach(provider -> register(context, provider));
    }

    private void register(FeatureContext context, Class<?> providerClass) {
        context.register(providerClass);
    }

}
