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
package org.eclipse.krazo.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Test for ViewResponseFilter
 *
 * @author Dmytro Maidaniuk
 */
@RunWith(value = Parameterized.class)
public class ViewResponseFilterTest {

    private String viewName;

    private String defaultExtension;

    private String expectedViewName;

    public ViewResponseFilterTest(String viewName,
                                  String defaultExtension,
                                  String expectedViewName) {
        this.viewName = viewName;
        this.defaultExtension = defaultExtension;
        this.expectedViewName = expectedViewName;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"main.jsp", "jsp", "main.jsp"},
            {"main", "jsp", "main.jsp"},
            {"main", null, "main"},
            {"main", "", "main"},
            {"redirect:some.jsp", "jsp", "redirect:some.jsp"},
            {"react:some", "jsp", "react:some.jsp"},
            {"main.", "jsp", "main."}
        });
    }

    @Test
    public void testAppendExtensionIfRequired() {
        String actualViewName = ViewResponseFilter.appendExtensionIfRequired(viewName, defaultExtension);
        assertEquals(expectedViewName, actualViewName);
    }

}
