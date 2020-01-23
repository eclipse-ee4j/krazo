/*
 * Copyright (c) 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.binding.convert.impl;

import org.eclipse.krazo.binding.convert.MvcConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.lang.annotation.Annotation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Gregor Tudan
 */
@RunWith(Parameterized.class)
public abstract class SupportsTest<T> {

    protected static final Annotation[] EMPTY_ANNOTATIONS = new Annotation[]{};

    private MvcConverter<T> mvcConverter;

    SupportsTest(MvcConverter<T> mvcConverter) {
        this.mvcConverter = mvcConverter;
    }

    @Parameter(0)
    public Class clazz;
    @Parameter(1)
    public Annotation[] annotations;
    @Parameter(2)
    public boolean isSupported;

    @Test
    public void testSupports() {
       if (isSupported) {
           assertTrue(mvcConverter.supports(clazz, annotations));
       } else {
           assertFalse(mvcConverter.supports(clazz, annotations));
       }
    }

}
