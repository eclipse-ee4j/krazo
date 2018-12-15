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

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ValidationIT {

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
    public void testFormControllerOk() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl);
        final HtmlForm form = page.getFormByName("form");
        final HtmlTextInput name = form.getInputByName("name");
        final HtmlTextInput age = form.getInputByName("age");
        final HtmlSubmitInput button = form.getInputByName("button");
        name.setValueAttribute("john");
        age.setValueAttribute("21");
        final HtmlPage page2 = button.click();
        final Iterator<HtmlElement> it = page2.getDocumentElement().getHtmlElementsByTagName("p").iterator();
        assertTrue(it.next().asText().contains("john"));
        assertTrue(it.next().asText().contains("21"));
    }

    @Test
    public void testFormControllerFail() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl);
        final HtmlForm form = page.getFormByName("form");
        final HtmlTextInput name = form.getInputByName("name");
        final HtmlTextInput age = form.getInputByName("age");
        final HtmlSubmitInput button = form.getInputByName("button");
        name.setValueAttribute("john");
        age.setValueAttribute("2");         // Not old enough!
        try {
            button.click();
            fail("Validation error expected in form submission");
        } catch (FailingHttpStatusCodeException e) {
            assertTrue(e.getStatusCode() == 400);
            assertTrue(e.getResponse().getContentAsString().contains("<h1>Form Error</h1>"));
            assertTrue(e.getResponse().getContentAsString().contains("<p>Param: age</p>"));
        }
    }

    @Test
    public void testFormControllerPropertyOk() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "indexprop.html");
        final HtmlForm form = page.getFormByName("form");
        final HtmlTextInput name = form.getInputByName("name");
        final HtmlTextInput age = form.getInputByName("age");
        final HtmlSubmitInput button = form.getInputByName("button");
        name.setValueAttribute("john");
        age.setValueAttribute("21");
        final HtmlPage page2 = button.click();
        final Iterator<HtmlElement> it = page2.getDocumentElement().getHtmlElementsByTagName("p").iterator();
        assertTrue(it.next().asText().contains("john"));
        assertTrue(it.next().asText().contains("21"));
    }

    @Test
    public void testFormControllerPropertyFail() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "indexprop.html");
        final HtmlForm form = page.getFormByName("form");
        final HtmlTextInput name = form.getInputByName("name");
        final HtmlTextInput age = form.getInputByName("age");
        final HtmlSubmitInput button = form.getInputByName("button");
        name.setValueAttribute("john");
        age.setValueAttribute("2");         // Not old enough!
        try {
            button.click();
            fail("Validation error expected in form submission");
        } catch (FailingHttpStatusCodeException e) {
            assertTrue(e.getStatusCode() == 400);
            assertTrue(e.getResponse().getContentAsString().contains("<h1>Form Error</h1>"));
            assertTrue(e.getResponse().getContentAsString().contains("<p>Param: age</p>"));
        }
    }

    @Test
    @Ignore         // Waiting for Jersey 2.22
    public void testBindingErrorFail() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/form?n=j");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("p").iterator();
        assertTrue(it.next().asText().contains("Param: n"));
        assertTrue(it.next().asText().contains("Message: java.lang.NumberFormatException: For input string: \"j\""));
    }
}
