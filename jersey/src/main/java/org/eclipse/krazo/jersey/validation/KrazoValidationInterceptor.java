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
package org.eclipse.krazo.jersey.validation;

import org.glassfish.jersey.server.spi.ValidationInterceptor;
import org.glassfish.jersey.server.spi.ValidationInterceptorContext;
import org.eclipse.krazo.util.AnnotationUtils;

import javax.mvc.Controller;

/**
 * This interceptor prevents Jersey from performing validation for MVC requests. This
 * is required because, we need to make sure that controller is always invoked as we
 * are doing validation our self.
 *
 * @author Christian Kaltepoth
 */
public class KrazoValidationInterceptor implements ValidationInterceptor {

    /**
     * For some weird reason we cannot preserve the <code>throws ConstraintViolationException</code>
     * in the method signature. Bundling Krazo as a Glassfish plugin starts failing as soon as
     * this class uses any interface from the javax.validation package. My current guess is
     * that this is related to the OSGi bundling.
     */
    @Override
    public void onValidate(ValidationInterceptorContext context) {

        /*
         * TODO: Won't work correctly for mixed controller/resource methods.
         */
        Class<?> resourceClass = context.getResource().getClass();
        boolean mvcRequest = AnnotationUtils.hasAnnotationOnClassOrMethod(resourceClass, Controller.class);

        if (!mvcRequest) {
            context.proceed();
        }

    }

}
