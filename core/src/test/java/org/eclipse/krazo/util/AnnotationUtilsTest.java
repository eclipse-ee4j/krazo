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

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * The JUnit tests for the AnnotationUtils class.
 *
 * @author Florian Hirsch
 */
public class AnnotationUtilsTest {

    private SomeController someController = new SomeController();

    private SomeBean someBean = new SomeBean();

    @Test
    public void getAnnotation() {
        Path path = AnnotationUtils.getAnnotation(someController.getClass(), Path.class);
        assertThat(path.value(), is("start"));
        Named named = AnnotationUtils.getAnnotation(someBean.getClass(), Named.class);
        assertThat(named.value(), is("someBean"));
        assertThat(AnnotationUtils.getAnnotation(BaseController.class, Controller.class), is(notNullValue()));
        // inheritance of class or interface annotations is not supported
        assertThat(AnnotationUtils.getAnnotation(InheritedController.class, Controller.class), is(nullValue()));
        assertThat(AnnotationUtils.getAnnotation(ControllerImpl.class, Controller.class), is(nullValue()));
    }

    @Test
    public void hasAnnotation() {
        assertTrue(AnnotationUtils.hasAnnotation(someController.getClass(), Path.class));
        assertFalse(AnnotationUtils.hasAnnotation(someController.getClass(), Named.class));
        assertTrue(AnnotationUtils.hasAnnotation(someBean.getClass(), Named.class));
        assertFalse(AnnotationUtils.hasAnnotation(someBean.getClass(), Path.class));
        assertTrue(AnnotationUtils.hasAnnotation(BaseController.class, Controller.class));
        // inheritance of class or interface annotations is not supported
        assertFalse(AnnotationUtils.hasAnnotation(InheritedController.class, Controller.class));
        assertFalse(AnnotationUtils.hasAnnotation(ControllerImpl.class, Controller.class));
    }

    @Test
    public void getAnnotationOnMethod() throws NoSuchMethodException {
        View view = AnnotationUtils.getAnnotation(someController.getClass().getMethod("start"), View.class);
        assertThat(view.value(), is("start.jsp"));
        NotNull notNull = AnnotationUtils.getAnnotation(someBean.getClass().getMethod("notNull"), NotNull.class);
        assertThat(notNull.message(), is("notNull"));
        assertThat(AnnotationUtils.getAnnotation(BaseController.class.getMethod("start"), View.class), is(notNullValue()));
        assertThat(AnnotationUtils.getAnnotation(InheritedController.class.getMethod("start"), View.class), is(notNullValue()));
        assertThat(AnnotationUtils.getAnnotation(ControllerImpl.class.getMethod("start"), View.class), is(notNullValue()));
        View inheritedView = AnnotationUtils.getAnnotation(InheritedControllerImpl.class.getMethod("start"), View.class);
        // Annotations on a super-class take precedence over those on an implemented interface
        assertThat(inheritedView.value(), is("start-base.jsp"));
        // if a subclass or implementation method has any MVC or JAX-RS annotations
        // then all of the annotations on the superclass or interface method are ignored
        assertThat(AnnotationUtils.getAnnotation(NoInheritanceController.class.getMethod("start"), Path.class), is(nullValue()));
    }

    @Test
    public void hasAnnotationOnMethod() throws NoSuchMethodException {
        assertTrue(AnnotationUtils.hasAnnotation(someController.getClass().getMethod("start"), View.class));
        assertFalse(AnnotationUtils.hasAnnotation(someController.getClass().getMethod("start"), NotNull.class));
        assertTrue(AnnotationUtils.hasAnnotation(someBean.getClass().getMethod("notNull"), NotNull.class));
        assertFalse(AnnotationUtils.hasAnnotation(someBean.getClass().getMethod("notNull"), View.class));
        assertTrue(AnnotationUtils.hasAnnotation(BaseController.class.getMethod("start"), View.class));
        assertTrue(AnnotationUtils.hasAnnotation(InheritedController.class.getMethod("start"), View.class));
        assertTrue(AnnotationUtils.hasAnnotation(ControllerImpl.class.getMethod("start"), View.class));
        // if a subclass or implementation method has any MVC or JAX-RS annotations
        // then all of the annotations on the superclass or interface method are ignored
        assertFalse(AnnotationUtils.hasAnnotation(NoInheritanceController.class.getMethod("start"), Path.class));
    }

    @Controller
    @Path("start")
    static class SomeController {
        @View("start.jsp")
        @GET
        public void start() {
        }
    }

    @Named("someBean")
    @RequestScoped
    static class SomeBean {
        @NotNull(message = "notNull")
        public String notNull() {
            return "something";
        }
    }

    @Controller
    public static class BaseController {
        @View("start-base.jsp")
        @Path("/base")
        public void start() {
        }
    }

    public static class InheritedController extends BaseController {
    }

    @Controller
    public interface ControllerInterface {
        @View("start-interface.jsp")
        void start();
    }

    public static class ControllerImpl implements ControllerInterface {
        public void start() {
        }
    }

    public static class InheritedControllerImpl extends BaseController implements ControllerInterface {
    }

    public static class NoInheritanceController extends BaseController {
        @View("start.jsp")
        public void start() {
        }
    }
}




