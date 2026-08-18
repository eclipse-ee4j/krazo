/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, 2026 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.binding;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import jakarta.mvc.binding.BindingError;
import jakarta.mvc.binding.ValidationError;
import java.util.Collections;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link BindingResultImpl}.
 *
 * @author Satoshi Seto
 */
public class BindingResultImplTest {

    private BindingResultImpl bindingResult;

    @Before
    public void setUp() {
        bindingResult = new BindingResultImpl();
    }

    @Test
    public void testHasErrorsWithNoErrors() {
        assertFalse("hasErrors() should return false when there are no errors", bindingResult.hasErrors());
    }

    @Test
    public void testHasErrorsWithBindingError() {
        BindingError bindingError = EasyMock.createMock(BindingError.class);
        expect(bindingError.getParamName()).andReturn("testParam").anyTimes();
        expect(bindingError.getMessage()).andReturn("Test error message").anyTimes();
        replay(bindingError);

        bindingResult.addBindingError(bindingError);

        assertTrue("hasErrors() should return true when there are binding errors", bindingResult.hasErrors());
    }

    @Test
    public void testHasErrorsWithValidationError() {
        ValidationError validationError = EasyMock.createMock(ValidationError.class);
        expect(validationError.getParamName()).andReturn("testParam").anyTimes();
        expect(validationError.getMessage()).andReturn("Test validation message").anyTimes();
        replay(validationError);

        bindingResult.addValidationErrors(Collections.singleton(validationError));

        assertTrue("hasErrors() should return true when there are validation errors", bindingResult.hasErrors());
    }

    @Test
    public void testHasErrorsWithParamNameNoErrors() {
        assertFalse("hasErrors(param) should return false when there are no errors for the parameter",
                bindingResult.hasErrors("testParam"));
    }

    @Test
    public void testHasErrorsWithParamNameWithMatchingError() {
        BindingError bindingError = EasyMock.createMock(BindingError.class);
        expect(bindingError.getParamName()).andReturn("testParam").anyTimes();
        expect(bindingError.getMessage()).andReturn("Test error message").anyTimes();
        replay(bindingError);

        bindingResult.addBindingError(bindingError);

        assertTrue("hasErrors(param) should return true when there are errors for the parameter",
                bindingResult.hasErrors("testParam"));
    }

    @Test
    public void testHasErrorsWithParamNameWithNonMatchingError() {
        BindingError bindingError = EasyMock.createMock(BindingError.class);
        expect(bindingError.getParamName()).andReturn("otherParam").anyTimes();
        expect(bindingError.getMessage()).andReturn("Test error message").anyTimes();
        replay(bindingError);

        bindingResult.addBindingError(bindingError);

        assertFalse("hasErrors(param) should return false when there are no errors for the specified parameter",
                bindingResult.hasErrors("testParam"));
    }

    @Test
    public void testHasErrorsWithParamNameMultipleErrors() {
        BindingError bindingError1 = EasyMock.createMock(BindingError.class);
        expect(bindingError1.getParamName()).andReturn("testParam").anyTimes();
        expect(bindingError1.getMessage()).andReturn("Test error message 1").anyTimes();
        replay(bindingError1);

        BindingError bindingError2 = EasyMock.createMock(BindingError.class);
        expect(bindingError2.getParamName()).andReturn("otherParam").anyTimes();
        expect(bindingError2.getMessage()).andReturn("Test error message 2").anyTimes();
        replay(bindingError2);

        bindingResult.addBindingError(bindingError1);
        bindingResult.addBindingError(bindingError2);

        assertTrue("hasErrors(param) should return true for testParam",
                bindingResult.hasErrors("testParam"));
        assertTrue("hasErrors(param) should return true for otherParam",
                bindingResult.hasErrors("otherParam"));
        assertFalse("hasErrors(param) should return false for nonExistentParam",
                bindingResult.hasErrors("nonExistentParam"));
    }

    @Test
    public void testHasErrorsWithParamNameMixedErrors() {
        BindingError bindingError = EasyMock.createMock(BindingError.class);
        expect(bindingError.getParamName()).andReturn("bindingParam").anyTimes();
        expect(bindingError.getMessage()).andReturn("Binding error message").anyTimes();
        replay(bindingError);

        ValidationError validationError = EasyMock.createMock(ValidationError.class);
        expect(validationError.getParamName()).andReturn("validationParam").anyTimes();
        expect(validationError.getMessage()).andReturn("Validation error message").anyTimes();
        replay(validationError);

        bindingResult.addBindingError(bindingError);
        bindingResult.addValidationErrors(Collections.singleton(validationError));

        assertTrue("hasErrors(param) should return true for bindingParam",
                bindingResult.hasErrors("bindingParam"));
        assertTrue("hasErrors(param) should return true for validationParam",
                bindingResult.hasErrors("validationParam"));
        assertFalse("hasErrors(param) should return false for nonExistentParam",
                bindingResult.hasErrors("nonExistentParam"));
    }

    @Test(expected = NullPointerException.class)
    public void testHasErrorsWithNullParam() {
        bindingResult.hasErrors(null);
    }

    @Test
    public void testHasErrorsConsistencyWithIsFailed() {
        assertFalse("hasErrors() and isFailed() should be consistent when no errors",
                bindingResult.hasErrors() != bindingResult.isFailed());

        BindingError bindingError = EasyMock.createMock(BindingError.class);
        expect(bindingError.getParamName()).andReturn("testParam").anyTimes();
        expect(bindingError.getMessage()).andReturn("Test error message").anyTimes();
        replay(bindingError);

        bindingResult.addBindingError(bindingError);

        assertTrue("hasErrors() should match isFailed() when there are errors",
                bindingResult.hasErrors() == bindingResult.isFailed());
    }
}
