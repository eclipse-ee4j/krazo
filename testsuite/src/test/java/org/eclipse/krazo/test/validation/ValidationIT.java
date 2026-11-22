/*
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
package org.eclipse.krazo.test.validation;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
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

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

@RunWith(Arquillian.class)
public class ValidationIT {
    private static final String WEB_INF_SRC = "src/main/resources/validation/";

    private static final String FORM = "form";
    private static final String VALIDATE_ON_EXECUTION_FORM = "validate-on-execution-form";

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
            .addView(webInf.resolve("views/form.jsp").toFile(), "form.jsp")
            .addView(webInf.resolve("views/binderror.jsp").toFile(), "binderror.jsp")
            .addView(webInf.resolve("views/data.jsp").toFile(), "data.jsp")
            .addView(webInf.resolve("views/error.jsp").toFile(), "error.jsp")
            .addBeansXml()
            .build();
    }

    @After
    public void teardown() {
        webClient.close();
    }

    @Test
    public void testFormControllerOk() throws Exception {
        assumeRuntimeValidationCanBeSkipped();
        assertValidSubmission(FORM);
    }

    @Test
    public void testFormControllerFail() throws Exception {
        assumeRuntimeValidationCanBeSkipped();
        assertInvalidSubmission(FORM);
    }

    @Test
    public void testValidateOnExecutionNoneOk() throws Exception {
        assertValidSubmission(VALIDATE_ON_EXECUTION_FORM);
    }

    @Test
    public void testValidateOnExecutionNoneFail() throws Exception {
        assertInvalidSubmission(VALIDATE_ON_EXECUTION_FORM);
    }

    /**
     * Open Liberty doesn't expose the RESTEasy validation SPI to applications, so Krazo cannot stop
     * RESTEasy from validating controller methods there. Controllers need
     * {@code @ValidateOnExecution(type = ExecutableType.NONE)} on that runtime (#398).
     */
    private static void assumeRuntimeValidationCanBeSkipped() {
        assumeFalse(System.getProperty("testsuite.profile", "").startsWith("testsuite-liberty"));
    }

    private void assertValidSubmission(String path) throws Exception {
        final HtmlPage page = submitForm(path, "john", "21");

        assertEquals(page.getWebResponse().getContentAsString(), 200, page.getWebResponse().getStatusCode());
        assertThat(page.getElementById("name").asNormalizedText(), containsString("john"));
        assertThat(page.getElementById("age").asNormalizedText(), containsString("21"));
    }

    private void assertInvalidSubmission(String path) throws Exception {
        final HtmlPage page = submitForm(path, "john", "2"); // Not old enough!

        // the controller must be invoked and render the error view, instead of the
        // Jakarta REST runtime rejecting the request with its own 400 response (#398)
        assertEquals(page.getWebResponse().getContentAsString(), 400, page.getWebResponse().getStatusCode());
        assertThat(page.getElementsByTagName("h1").get(0).asNormalizedText(), containsString("Form Error"));
        assertThat(page.getElementsByTagName("p").get(0).asNormalizedText(), containsString("age"));
        assertThat(page.getElementsByTagName("p").get(1).asNormalizedText(), containsString("age"));
        assertThat(page.getElementsByTagName("p").get(2).asNormalizedText(), containsString("2"));
        assertThat(page.getElementsByTagName("p").get(3).asNormalizedText(), containsString("18"));
    }

    private HtmlPage submitForm(String path, String name, String age) throws Exception {
        final Page page = webClient.getPage(baseURL + "validation/" + path + "/new");
        final WebResponse response = page.getWebResponse();
        assertEquals(response.getContentAsString(), 200, response.getStatusCode());
        assertTrue(response.getContentAsString(), page.isHtmlPage());

        final HtmlForm form = ((HtmlPage) page).getFormByName("form");
        form.getInputByName("name").setValueAttribute(name);
        form.getInputByName("age").setValueAttribute(age);

        final Page result = form.getInputByName("button").click();
        assertTrue(result.getWebResponse().getContentAsString(), result.isHtmlPage());
        return (HtmlPage) result;
    }
}
