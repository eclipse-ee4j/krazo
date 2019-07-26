/*
 * Copyright © 2019 Eclipse Krazo committers and contributors
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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ViewResponseFilterTemplatePatternTest {

    private final String viewName;
    private final boolean expectedIsViewTemplate;

    public ViewResponseFilterTemplatePatternTest(final String viewName, final boolean expectedIsViewTemplate) {
        this.viewName = viewName;
        this.expectedIsViewTemplate = expectedIsViewTemplate;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"main.jsp", true},
            {"main", false},
            {"main.html.jsp", true},
            {"main.jsf", true},
            {"redirect:some.jsp", true},
            {"react:some", false},
            {"main.", false}
        });
    }

    @Test
    public void testIsViewTemplate() {
        final boolean actualIsViewTemplate = ViewResponseFilter.isViewTemplate(viewName);

        assertEquals(expectedIsViewTemplate, actualIsViewTemplate);
    }
}