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
package org.eclipse.krazo.util;

import org.junit.Test;

import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The JUnit tests for the {@link ControllerUtils} class.
 *
 * @author Florian Hirsch
 */
public class ControllerUtilsTest {

    @Test
    public void shouldIdentifyControllerClasses() {
        assertTrue(ControllerUtils.isController(ClassController.class));
        assertTrue(ControllerUtils.isController(MethodController.class));
        assertFalse(ControllerUtils.isController(NoController.class));
    }

    @Test
    public void shouldIdentifyControllerMethods() throws NoSuchMethodException {
        assertFalse(ControllerUtils.isControllerMethod(ClassController.class.getMethod("foo")));
        assertTrue(ControllerUtils.isControllerMethod(ClassController.class.getMethod("bar")));
        assertFalse(ControllerUtils.isControllerMethod(MethodController.class.getMethod("foo")));
        assertTrue(ControllerUtils.isControllerMethod(MethodController.class.getMethod("bar")));
        assertFalse(ControllerUtils.isControllerMethod(NoController.class.getMethod("foo")));
        assertFalse(ControllerUtils.isControllerMethod(NoController.class.getMethod("bar")));
    }

    @Test
    public void shouldIdentifyRequestMethods() throws NoSuchMethodException {
        assertFalse(ControllerUtils.isRequestMethod(NoController.class.getMethod("foo")));
        assertTrue(ControllerUtils.isRequestMethod(NoController.class.getMethod("bar")));
        assertFalse(ControllerUtils.isRequestMethod(InheritedController.class.getMethod("foo")));
        assertTrue(ControllerUtils.isRequestMethod(InheritedController.class.getMethod("bar")));
        assertTrue(ControllerUtils.isRequestMethod(ControllerImpl.class.getMethod("foo")));
        // if a subclass or implementation method has any MVC or JAX-RS annotations
        // then all the annotations on the superclass or interface method are ignored
        assertFalse(ControllerUtils.isRequestMethod(InheritedController.class.getMethod("baz")));
        assertFalse(ControllerUtils.isRequestMethod(ControllerImpl.class.getMethod("baz")));
    }

    @Test
    public void shouldIdentifyDeclaredRequestMethodAnnotations() throws NoSuchMethodException {
        assertFalse(ControllerUtils.hasDeclaredRequestMethodAnnotation(
            MethodController.class.getMethod("foo")));
        assertTrue(ControllerUtils.hasDeclaredRequestMethodAnnotation(
            MethodController.class.getMethod("bar")));
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
