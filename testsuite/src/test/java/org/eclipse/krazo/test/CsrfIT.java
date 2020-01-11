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

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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


    private static final String WEB_INF_SRC = "src/main/resources/csrf/base/";

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

    @Deployment(testable = false, name = "csrf")
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.csrf.base")
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
    public void testFormOk() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/csrf");
        final HtmlForm form = page.getForms().get(0);

        // Check hidden input field
        final HtmlInput input = form.getInputByName(CSRF_PARAM);
        assertEquals("hidden", input.getAttribute("type"));
        assertEquals(CSRF_PARAM, input.getAttribute("name"));
        assertNotNull(input.getAttribute("value"));        // token

        HtmlSubmitInput button = form.getInputByName("submit");
        final HtmlPage newPage = button.click();

        final DomElement h1 = newPage.getElementsByTagName("h1").get(0);
        assertTrue(h1.getTextContent().contains("CSRF Protection OK"));
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

