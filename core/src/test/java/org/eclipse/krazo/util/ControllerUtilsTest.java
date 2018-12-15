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
package org.eclipse.krazo.util;

import org.junit.Test;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * The JUnit tests for the {@link ControllerUtils} class.
 *
 * @author Florian Hirsch
 */
public class ControllerUtilsTest {

    @Test
    public void shouldIdentifyControllerClasses() {
        assertThat(ControllerUtils.isController(ClassController.class), is(true));
        assertThat(ControllerUtils.isController(MethodController.class), is(true));
        assertThat(ControllerUtils.isController(NoController.class), is(false));
    }

    @Test
    public void shouldIdentifyControllerMethods() throws NoSuchMethodException {
        assertThat(ControllerUtils.isControllerMethod(ClassController.class.getMethod("foo")), is(false));
        assertThat(ControllerUtils.isControllerMethod(ClassController.class.getMethod("bar")), is(true));
        assertThat(ControllerUtils.isControllerMethod(MethodController.class.getMethod("foo")), is(false));
        assertThat(ControllerUtils.isControllerMethod(MethodController.class.getMethod("bar")), is(true));
        assertThat(ControllerUtils.isControllerMethod(NoController.class.getMethod("foo")), is(false));
        assertThat(ControllerUtils.isControllerMethod(NoController.class.getMethod("bar")), is(false));
    }

    @Test
    public void shouldIdentifyRequestMethods() throws NoSuchMethodException {
        assertThat(ControllerUtils.isRequestMethod(NoController.class.getMethod("foo")), is(false));
        assertThat(ControllerUtils.isRequestMethod(NoController.class.getMethod("bar")), is(true));
        assertThat(ControllerUtils.isRequestMethod(InheritedController.class.getMethod("foo")), is(false));
        assertThat(ControllerUtils.isRequestMethod(InheritedController.class.getMethod("bar")), is(true));
        assertThat(ControllerUtils.isRequestMethod(ControllerImpl.class.getMethod("foo")), is(true));
        // if a subclass or implementation method has any MVC or JAX-RS annotations
        // then all of the annotations on the superclass or interface method are ignored
        assertThat(ControllerUtils.isRequestMethod(InheritedController.class.getMethod("baz")), is(false));
        assertThat(ControllerUtils.isRequestMethod(ControllerImpl.class.getMethod("baz")), is(false));
    }

    @Test
    public void shouldIdentifyDeclaredRequestMethodAnnotations() throws NoSuchMethodException {
        assertThat(ControllerUtils.hasDeclaredRequestMethodAnnotation(
            MethodController.class.getMethod("foo")), is(false));
        assertThat(ControllerUtils.hasDeclaredRequestMethodAnnotation(
            MethodController.class.getMethod("bar")), is(true));
    }

    @Controller
    public static class ClassController {
        public void foo() {}
        @GET public void bar() {}
        @GET public void baz() {}
    }

    public static class MethodController {
        @Controller public void foo() {}
        @Controller @GET public void bar() {}
    }

    public static class NoController {
        public void foo() {}
        @GET public void bar() {}
    }

    public static class InheritedController extends ClassController {
        public void foo() {}
        public void bar() {}
        @Path("baz") public void baz() {}
    }

    public interface ControllerInterface {
        @GET void foo();
        @GET void baz();
    }

    public static class ControllerImpl implements ControllerInterface {
        public void foo() {}
        @Path("baz") public void baz() {}
    }

}
