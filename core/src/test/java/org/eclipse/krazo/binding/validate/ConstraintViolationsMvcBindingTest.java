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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import java.util.Set;

import javax.mvc.binding.MvcBinding;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import javax.ws.rs.FormParam;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit tests for annotation resolution in {@link ConstraintViolations}.
 * <p>
 * These tests are based on a scenario where we have a number of existing java
 * bean classes that have bean validation constraints already applied to both
 * fields and getter methods. We extend those beans so that we can annotate the
 * field getter methods with {@link MvcBinding}, and annotate the setter methods
 * with {@link javax.ws.rs.FormParam}, as would be done on a JAX-RS/MVC {@link
 * javax.ws.rs.BeanParam}.
 */
public class ConstraintViolationsMvcBindingTest {

    private static Validator validator;

    /**
     * Initialize our {@link Validator} instance.
     */
    @BeforeClass
    public static void initValidator() {

        final ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();

    }

    /**
     * Create a valid {@link MvcUser} successfully, with no constraint
     * violations.
     */
    @Test
    public void validUserSuccess() {

        final MvcUser mvcUser = new MvcUser();
        mvcUser.setFirstName("John");
        mvcUser.setLastName("Doe");

        // validate the user - we should see no violations
        final Set<ConstraintViolation<MvcUser>> errs = validator.validate(mvcUser);
        assertNotNull(errs);
        assertTrue("Expected no constraint violations for valid object", errs.isEmpty());

    }

    /**
     * Create a {@link MvcUser} with an invalid first name.
     * <p>
     * This tests a bean validation constraint applied to the getter method of
     * the field in the {@link BaseUser} superclass.
     */
    @Test
    public void invalidMvcUserFirstNameSuccess() {

        // create a user with a first name longer than 10 characters
        final MvcUser mvcUser = new MvcUser();
        mvcUser.setFirstName("A first name that is longer than 10");
        mvcUser.setLastName("Doe");

        // validate the user - we should see 1 violation due to the long first name
        final Set<ConstraintViolation<MvcUser>> errs = validator.validate(mvcUser);
        assertNotNull(errs);
        assertEquals("Expect 1 constraint violation from validation", errs.size(), 1);

        // create the metadata for our violation
        final ConstraintViolation<MvcUser> violation = errs.iterator().next();
        final ConstraintViolationMetadata metadata = ConstraintViolations.getMetadata(violation);
        assertNotNull("Violation metadata should not be null", metadata);

        // verify that firstName was the violated JAX-RS/MVC param
        final Optional<String> metadataViolatedParamName = metadata.getParamName();
        assertTrue("Violation metadata should contain the violated param name", metadataViolatedParamName.isPresent());
        assertEquals("Metadata violated param should be 'firstName'", "firstName", metadataViolatedParamName.get());

        // lastly, test for our MVC-ish annotations based on our constraint violation
        // metadata. we should find @MvcBinding from the getter method for firstName,
        // and @FormParam from the setter. Also test for annotations that we expect to
        // NOT be present
        assertTrue("@MvcBinding should be found on 'firstName'", metadata.hasAnnotation(MvcBinding.class));
        assertTrue("@FormParam should be found on 'firstName'", metadata.hasAnnotation(FormParam.class));
        assertFalse("@Pattern should not be found on 'firstName'", metadata.hasAnnotation(Pattern.class));

    }

    /**
     * Create a {@link MvcUser} with an invalid last name.
     * <p>
     * This tests a bean validation constraint applied to the field of our
     * {@link BaseUser} superclass.
     */
    @Test
    public void invalidMvcUserLastNameSuccess() {

        // create a user with a last name longer than 10 characters
        final MvcUser mvcUser = new MvcUser();
        mvcUser.setFirstName("John");
        mvcUser.setLastName("A last name longer than 10");

        // validate the user - we should see 1 violation due to the long last name
        final Set<ConstraintViolation<MvcUser>> errs = validator.validate(mvcUser);
        assertNotNull(errs);
        assertEquals("Expect 1 constraint violation from validation", errs.size(), 1);

        // create the metadata for our violation
        final ConstraintViolation<MvcUser> violation = errs.iterator().next();
        final ConstraintViolationMetadata metadata = ConstraintViolations.getMetadata(violation);
        assertNotNull("Violation metadata should not be null", metadata);

        // verify that lastName was the violated JAX-RS/MVC param
        final Optional<String> metadataViolatedParamName = metadata.getParamName();
        assertTrue("Violation metadata should contain the violated param name", metadataViolatedParamName.isPresent());
        assertEquals("Metadata violated param should be 'lastName'", "lastName", metadataViolatedParamName.get());

        // lastly, test for our MVC-ish annotations based on our constraint violation
        // metadata. we should find @MvcBinding from the getter method for lastName,
        // and @FormParam from the setter. Also test for annotations that we expect to
        // NOT be present
        assertTrue("@MvcBinding should be found on 'lastName'", metadata.hasAnnotation(MvcBinding.class));
        assertTrue("@FormParam should be found on 'lastName'", metadata.hasAnnotation(FormParam.class));
        assertFalse("@Pattern should not be found on 'lastName'", metadata.hasAnnotation(Pattern.class));

    }

    /**
     * Test a constraint violation on an object that does use a bean validation
     * constraint on a field, but is NOT a valid java bean.
     * <p>
     * This test simply ensures that our metadata generation methods in {@link
     * ConstraintViolations} work even when passed an object that is not a java
     * bean.
     */
    @Test
    public void notAJavaBeanSuccess() {

        final NotAJavaBean nonJavaBean = new NotAJavaBean("Value that is more than 10");

        // validate the class - we should see 1 violation due to the long name
        final Set<ConstraintViolation<NotAJavaBean>> errs = validator.validate(nonJavaBean);
        assertNotNull(errs);
        assertEquals("Expect 1 constraint violation from validation", errs.size(), 1);

        // create the metadata for our violation. we should have no problem even though
        // we're not dealing with a valid java bean object
        final ConstraintViolation<NotAJavaBean> violation = errs.iterator().next();
        final ConstraintViolationMetadata metadata = ConstraintViolations.getMetadata(violation);
        assertNotNull("Violation metadata should not be null", metadata);

        // our metadata should be able to resolve our violated param name properly
        // (the property 'name' has the annotation @FormParam), but it won't be able to
        // locate the @MvcBinding on the name() method since it is not a valid
        // java beans getter.
        final Optional<String> metadataViolatedParamName = metadata.getParamName();
        assertTrue("Violation metadata should contain the violated field name", metadataViolatedParamName.isPresent());
        assertEquals("Metadata violated field should be 'name'", "name", metadataViolatedParamName.get());
        assertFalse("@MvcBinding should not be found on 'name'", metadata.hasAnnotation(MvcBinding.class));

    }
}
