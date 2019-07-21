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
package org.eclipse.krazo.bootstrap;

import org.eclipse.krazo.binding.convert.MvcConverterProvider;
import org.eclipse.krazo.core.ViewResponseFilter;
import org.eclipse.krazo.core.ViewableWriter;
import org.eclipse.krazo.forms.HiddenMethodFilter;
import org.eclipse.krazo.jaxrs.PostMatchingRequestFilter;
import org.eclipse.krazo.jaxrs.PreMatchingRequestFilter;
import org.eclipse.krazo.security.CsrfExceptionMapper;
import org.eclipse.krazo.security.CsrfProtectFilter;
import org.eclipse.krazo.security.CsrfValidateFilter;
import org.eclipse.krazo.util.CdiUtils;

import javax.ws.rs.core.FeatureContext;
import java.util.List;

/**
 * Implementation of ConfigProvider which registers all providers of the core module.
 *
 * @author Christian Kaltepoth
 */
public class DefaultConfigProvider implements ConfigProvider {

    @Override
    public void configure(FeatureContext context) {

        register(context, ViewResponseFilter.class);
        register(context, ViewableWriter.class);
        register(context, CsrfValidateFilter.class);
        register(context, CsrfProtectFilter.class);
        register(context, CsrfExceptionMapper.class);
        register(context, PreMatchingRequestFilter.class);
        register(context, PostMatchingRequestFilter.class);
        register(context, MvcConverterProvider.class);
        register(context, HiddenMethodFilter.class);

    }

    private void register(FeatureContext context, Class<?> providerClass) {

        boolean isCxf = context.getClass().getName().startsWith("org.apache.cxf");

        /*
         * With CXF there is no CDI injection if JAX-RS providers are registered via
         * context.register(Class). So we try to lookup provider instances from CDI
         * and register them instead.
         * See: https://issues.apache.org/jira/browse/CXF-7501
         */
        if (isCxf) {
            List<?> providerInstances = CdiUtils.getApplicationBeans(providerClass);
            if (!providerInstances.isEmpty()) {
                context.register(providerInstances.get(0));
            } else {
                context.register(providerClass);
            }
        }

        // will work for all other containers
        else {
            context.register(providerClass);
        }


    }

}
