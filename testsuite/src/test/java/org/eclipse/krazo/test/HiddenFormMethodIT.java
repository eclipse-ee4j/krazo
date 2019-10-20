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
package org.eclipse.krazo.test;

import static org.junit.Assert.assertEquals;
import java.net.URL;
import java.nio.file.Paths;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHiddenInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests the handling of hidden form methods (which may be PUT, PATCH or DELETE).
 *
 * @author Tobias Erdle
 */
@RunWith(Arquillian.class)
public class HiddenFormMethodIT {

    private static final String WEB_INF_SRC = "src/main/resources/forms/";

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;

    @Before
    public void setUp() throws Exception {
        webClient = new WebClient();
    }

    @After
    public void tearDown() throws Exception {
        webClient.close();
    }

    @Deployment(testable = false, name = "forms")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.forms")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/form.jsp").toFile(), "form.jsp")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/form-without-hidden-field.jsp").toFile(),
                "form-without-hidden-field.jsp")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/ok.jsp").toFile(), "ok.jsp")
            .addBeansXml()
            .build();
    }

    @Test
    public void shouldProcessFormMethodWhenNoHiddenMethodIsSpecified() throws Exception {
        final HtmlPage formPage = webClient
            .getPage(baseURL + "resources/forms?without-hidden-field=true");
        final HtmlForm form = (HtmlForm) formPage.getElementById("form");

        final HtmlPage okPage = submit(form);

        assertEquals("POST", okPage.getElementById("invoked-method").getTextContent());
    }

    @Test
    public void shouldProcessPUTMethodWhenHiddenFieldContainsPUT() throws Exception {
        final HtmlPage page = getFormPage();

        final HtmlForm form = setHiddenMethodInForm(page, "PUT");

        final HtmlPage resultPage = submit(form);

        assertEquals("PUT", resultPage.getElementById("invoked-method").getTextContent());
    }

    @Test
    public void shouldProcessPATCHMethodWhenHiddenFieldContainsPATCH() throws Exception {
        final HtmlPage page = getFormPage();

        final HtmlForm form = setHiddenMethodInForm(page, "PATCH");

        final HtmlPage resultPage = submit(form);

        assertEquals("PATCH", resultPage.getElementById("invoked-method").getTextContent());
    }

    @Test
    public void shouldProcessDELETEMethodWhenHiddenFieldContainsDELETE() throws Exception {
        final HtmlPage page = getFormPage();

        final HtmlForm form = setHiddenMethodInForm(page, "DELETE");

        final HtmlPage resultPage = submit(form);

        assertEquals("DELETE", resultPage.getElementById("invoked-method").getTextContent());
    }

    private HtmlPage getFormPage() throws java.io.IOException {
        return webClient.getPage(baseURL + "resources/forms");
    }

    private HtmlForm setHiddenMethodInForm(final HtmlPage page, final String method) {
        final HtmlForm form = (HtmlForm) page.getElementById("form");
        final HtmlHiddenInput hiddenMethod = (HtmlHiddenInput) page
            .getElementById("hidden-method");
        hiddenMethod.setValueAttribute(method);
        return form;
    }

    private HtmlPage submit(HtmlForm form) throws java.io.IOException {
        return form.getInputByName("submit").click();
    }
}
