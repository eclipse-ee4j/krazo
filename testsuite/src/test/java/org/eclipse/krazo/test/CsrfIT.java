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
package org.eclipse.krazo.test;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Tests CSRF implementation. Ensures hidden field is returned and that a form submitted
 * without it results in a 403 error.
 *
 * @author Santiago Pericas-Geertsen
 */
@RunWith(Arquillian.class)
public class CsrfIT {

    private static final String CSRF_HEADER = "X-CSRF-TOKEN";
    private static final String CSRF_PARAM = "_csrf";


    private static final String WEB_INF_SRC = "src/main/resources/csrf/";

    @ArquillianResource
    private URL baseURL;

    @Drone
    private WebDriver webDriver;

    @Deployment(testable = false, name = "csrf")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.csrf")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/csrf.jsp").toFile(), "csrf.jsp")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/ok.jsp").toFile(), "ok.jsp")
            .addBeansXml()
            .build();
    }

    /**
     * Retrieve a form and submit it making sure the CSRF hidden field is present
     *
     */
    @Test
    public void testFormOk() {
        webDriver.get(baseURL + "resources/csrf");
        WebElement form = webDriver.findElement(By.tagName("form"));

        // Check hidden input field
        WebElement input = form.findElement(By.name(CSRF_PARAM));
        assertEquals("hidden", input.getAttribute("type"));
        assertEquals(CSRF_PARAM, input.getAttribute("name"));
        assertNotNull(input.getAttribute("value"));        // token

        form.submit();
        WebElement h1 = webDriver.findElement(By.tagName("h1"));
        assertTrue(h1.getText().contains("CSRF Protection OK"));
    }

    /**
     * Retrieves a form, removes CSRF hidden field and attempts to submit. Should
     * result in a 403 error.
     */
    @Test
    public void testFormFail() throws IOException {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf");
            HtmlForm form = (HtmlForm) page1.getDocumentElement().getElementsByTagName("form").get(0);

            // Remove hidden input field to cause a CSRF validation failure
            HtmlElement input = form.getInputByName(CSRF_PARAM);
            form.removeChild(input);

            // Submit form - should fail
            HtmlSubmitInput button = form.getInputByName("submit");
            try {
                button.click();
                fail("CSRF validation should have failed!");
            } catch (FailingHttpStatusCodeException e) {
                // falls through
                assertEquals(403, e.getStatusCode());
            }
        }
    }

    /**
     * Checks that CSRF validation works if token sent as header instead of
     * form field.
     *
     * @throws Exception an error occurs or validation fails.
     */
    @Test
    public void testFormHeaderOk() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf");

            // Check response and CSRF header
            WebResponse res = page1.getWebResponse();
            assertEquals(Response.Status.OK.getStatusCode(), res.getStatusCode());
            assertNotNull(res.getResponseHeaderValue(CSRF_HEADER));

            WebRequest req = new WebRequest(new URL(baseURL + "resources/csrf"));
            req.setHttpMethod(HttpMethod.POST);
            req.setAdditionalHeader(CSRF_HEADER, res.getResponseHeaderValue(CSRF_HEADER));
            res = webClient.loadWebResponse(req);
            assertEquals(Response.Status.OK.getStatusCode(), res.getStatusCode());
        }
    }
}

