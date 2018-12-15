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
package org.eclipse.krazo.test.validation;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * @author Christian Kaltepoth
 */
public class I18NValidationIT {

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
    }

    @After
    public void tearDown() {
        webClient.closeAllWindows();
    }

    @Test
    public void testEnglishValidationMessage() throws Exception {

        HtmlPage page1 = webClient.getPage(webUrl + "resources/validation?lang=en");
        HtmlForm form1 = page1.getFormByName("form");
        form1.getInputByName("name").setValueAttribute("foo");

        HtmlPage page2 = form1.getInputByName("button").click();
        assertThat(page2.getWebResponse().getContentAsString(),
                CoreMatchers.containsString("size must be between 5 and 10"));

    }

    @Test
    public void testGermanValidationMessage() throws Exception {

        HtmlPage page1 = webClient.getPage(webUrl + "resources/validation?lang=de");
        HtmlForm form1 = page1.getFormByName("form");
        form1.getInputByName("name").setValueAttribute("foo");

        HtmlPage page2 = form1.getInputByName("button").click();
        assertThat(page2.getWebResponse().getContentAsString(),
                CoreMatchers.containsString("muss zwischen 5 und 10 liegen"));

    }

    @Test
    public void testFrenchValidationMessage() throws Exception {

        HtmlPage page1 = webClient.getPage(webUrl + "resources/validation?lang=fr");
        HtmlForm form1 = page1.getFormByName("form");
        form1.getInputByName("name").setValueAttribute("foo");

        HtmlPage page2 = form1.getInputByName("button").click();
        assertThat(page2.getWebResponse().getContentAsString(),
                CoreMatchers.containsString("entre 5 et 10"));

    }

}
