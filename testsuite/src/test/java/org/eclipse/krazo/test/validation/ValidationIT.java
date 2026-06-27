/*
 * Copyright (c) 2018, 2022 Eclipse Krazo committers and contributors
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
import com.gargoylesoftware.htmlunit.html.*;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ValidationIT {
    private static final String WEB_INF_SRC = "src/main/resources/validation/";

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.getOptions()
            .setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions()
            .setRedirectEnabled(true);
    }

    @Deployment(testable = false, name = "validation")
    public static WebArchive createDeployment() {
        var webInf = Paths.get(WEB_INF_SRC);
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.validation")
            .addView(webInf.resolve("index.html").toFile(), "index.jsp")
            .addView(webInf.resolve("views/binderror.jsp").toFile(), "index.jsp")
            .addView(webInf.resolve("views/data.jsp").toFile(), "index.jsp")
            .addView(webInf.resolve("views/error.jsp").toFile(), "index.jsp")
            .addBeansXml()
            .build();
    }

    @After
    public void teardown() {
        webClient.close();
    }

    @Test
    public void testFormControllerOk() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/validation");
        final HtmlForm form = page1.getFormByName("form");
        form.getInputByName("name").setValueAttribute("john");
        form.getInputByName("age").setValueAttribute("21");

        final HtmlPage page2 = form.getInputByName("button").click();

        assertTrue(page2.getElementById("name").asNormalizedText().contains("john"));
        assertTrue(page2.getElementById("age").asNormalizedText().contains("21"));
    }

    @Test
    public void testFormControllerFail() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/validation");
        final HtmlForm form = page1.getFormByName("form");
        form.getInputByName("name").setValueAttribute("john");
        form.getInputByName("age").setValueAttribute("2"); // Not old enough!

        final HtmlPage page2 = form.getInputByName("button").click();

        assertTrue(page2.getElementsByTagName("h1").get(0).asNormalizedText().contains("Form Error"));
        assertTrue(page2.getElementsByTagName("p").get(1).asNormalizedText().contains("age"));
        assertTrue(page2.getElementsByTagName("p").get(2).asNormalizedText().contains("2"));
        assertTrue(page2.getElementsByTagName("p").get(3).asNormalizedText().contains("foo"));
    }
}
