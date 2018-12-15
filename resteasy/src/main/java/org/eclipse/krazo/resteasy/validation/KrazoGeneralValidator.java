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
package org.eclipse.krazo.resteasy.validation;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.validation.GeneralValidator;
import org.eclipse.krazo.util.AnnotationUtils;

import javax.mvc.Controller;
import java.lang.reflect.Method;

/**
 * Custom implementation of {@link GeneralValidator} which will ignore all
 * validation requests for MVC controller.
 *
 * @author Christian Kaltepoth
 */
class KrazoGeneralValidator implements GeneralValidator {

    private GeneralValidator delegate;

    KrazoGeneralValidator(GeneralValidator delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean isValidatable(Class<?> clazz) {

        // TODO: Won't work correctly for mixed controller/resource methods.
        boolean mvcController =
                AnnotationUtils.hasAnnotationOnClassOrMethod(clazz, Controller.class);

        return !mvcController && delegate.isValidatable(clazz);

    }

    @Override
    public boolean isMethodValidatable(Method method) {

        // TODO: Won't work correctly for mixed controller/resource methods.
        boolean mvcControllerMethod =
                AnnotationUtils.hasAnnotationOnClassOrMethod(method.getDeclaringClass(), Controller.class);

        return !mvcControllerMethod && delegate.isMethodValidatable(method);

    }

    @Override
    public void validate(HttpRequest request, Object object, Class<?>... groups) {
        delegate.validate(request, object, groups);
    }

    @Override
    public void validateAllParameters(HttpRequest request, Object object, Method method, Object[] parameterValues, Class<?>... groups) {
        delegate.validateAllParameters(request, object, method, parameterValues, groups);
    }

    @Override
    public void validateReturnValue(HttpRequest request, Object object, Method method, Object returnValue, Class<?>... groups) {
        delegate.validateReturnValue(request, object, method, returnValue, groups);
    }

    @Override
    public void checkViolations(HttpRequest request) {
        delegate.checkViolations(request);
    }

}
