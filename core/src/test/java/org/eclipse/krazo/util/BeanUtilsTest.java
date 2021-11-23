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

import java.lang.reflect.AnnotatedElement;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The JUnit tests for the {@link BeanUtils} class.
 *
 * @author Florian Hirsch
 */
public class BeanUtilsTest {

    @Test
    public void shouldFindFieldsAndAccessors() {
        List<AnnotatedElement> fieldsAndAccessors = BeanUtils.getFieldsAndAccessors(SomeBean.class);
        assertEquals(3, fieldsAndAccessors.size());
        fieldsAndAccessors.forEach(fieldsAndAccessor ->
            assertTrue(fieldsAndAccessor.toString().toLowerCase().contains("foo"))
        );
    }

    private static class SomeBean {
        private String foo;
        public String getFoo() {
            return foo;
        }
        public void setFoo(String foo) {
            this.foo = foo;
        }
        public String bar() {
            return null;
        }
    }

}
