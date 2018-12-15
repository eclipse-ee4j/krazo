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
package org.eclipse.krazo.binding.validate;

import org.junit.Assert;
import org.junit.Test;

import javax.mvc.Controller;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.executable.ExecutableValidator;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ConstraintViolationsTest {

    private static final long VALID = 10;
    private static final long INVALID = -10;

    @Test
    public void shouldSupportControllerFields() {

        SomeController controller = new SomeController();
        controller.setControllerField(INVALID);

        long methodParameter = VALID;

        BeanParamBean paramBean = new BeanParamBean();
        paramBean.setBeanParamField(VALID);

        List<ConstraintViolation<?>> violations = simulateValidation(
                controller, "someControllerMethod", methodParameter, paramBean);

        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("controller-field",
                ConstraintViolations.getMetadata(violations.get(0)).getParamName().orElse(null));

    }

    @Test
    public void shouldSupportMethodParameters() {

        SomeController controller = new SomeController();
        controller.setControllerField(VALID);

        long methodParameter = INVALID;

        BeanParamBean paramBean = new BeanParamBean();
        paramBean.setBeanParamField(VALID);

        List<ConstraintViolation<?>> violations = simulateValidation(
                controller, "someControllerMethod", methodParameter, paramBean);

        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("method-parameter",
                ConstraintViolations.getMetadata(violations.get(0)).getParamName().orElse(null));

    }


    @Test
    public void shouldSupportBeanParamBeans() {

        SomeController controller = new SomeController();
        controller.setControllerField(VALID);

        long methodParameter = VALID;

        BeanParamBean paramBean = new BeanParamBean();
        paramBean.setBeanParamField(INVALID);

        List<ConstraintViolation<?>> violations = simulateValidation(
                controller, "someControllerMethod", methodParameter, paramBean);

        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("bean-param-field",
                ConstraintViolations.getMetadata(violations.get(0)).getParamName().orElse(null));

    }

    private List<ConstraintViolation<?>> simulateValidation(Object controller, String methodName, Object... args) {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        Validator validator = validatorFactory.getValidator();
        ExecutableValidator executableValidator = validator.forExecutables();

        List<ConstraintViolation<?>> result = new ArrayList<>();

        // validate controller fields
        result.addAll(validator.validate(controller));

        // controller method parameters
        Method method = getFirstMethod(controller.getClass(), methodName);
        result.addAll(executableValidator.validateParameters(controller, method, args));

        return result;

    }

    private Method getFirstMethod(Class<?> clazz, String methodName) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        throw new IllegalStateException("Canot find method: " + methodName);
    }

    @Controller
    @Path("something")
    public static class SomeController {

        @QueryParam("controller-field")
        @Min(0)
        private Long controllerField;

        @POST
        public String someControllerMethod(
                @FormParam("method-parameter") @Min(0) Long methodParameter,
                @BeanParam @Valid BeanParamBean beanParam) {
            return "view.jsp";
        }

        public void setControllerField(Long controllerField) {
            this.controllerField = controllerField;
        }

    }

    public static class BeanParamBean {

        @FormParam("bean-param-field")
        @Min(0)
        private long beanParamField;

        public long getBeanParamField() {
            return beanParamField;
        }

        public void setBeanParamField(long beanParamField) {
            this.beanParamField = beanParamField;
        }
    }


}
