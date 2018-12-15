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
package org.eclipse.krazo.test.csrfproperty;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.net.URL;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests CSRF implementation. Ensures hidden field is returned and that a form submitted
 * without it results in a 403 error.
 *
 * @author Santiago Pericas-Geertsen
 */
public class CsrfIT {

    private static final String CSRF_HEADER = "X-CSRF-TOKEN";
    private static final String CSRF_PARAM = "_csrf";

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        if (webUrl == null) {
            webUrl = "http://localhost:8080/test-csrf-property/";
        }
        webClient = new WebClient();
        webClient.getOptions().setRedirectEnabled(true);        // enable redirect!
    }

    @After
    public void tearDown() {
        webClient.closeAllWindows();
    }

    /**
     * Retrieve a form and submit it making sure the CSRF hidden field is present
     *
     * @throws Exception an error occurs or validation fails.
     */
    @Test
    public void testFormOk() throws Exception {
        HtmlPage page1 = webClient.getPage(webUrl + "resources/csrf");
        HtmlForm form = (HtmlForm) page1.getDocumentElement().getHtmlElementsByTagName("form").get(0);

        // Check hidden input field
        HtmlElement input = form.getHtmlElementsByTagName("input").get(1);
        assertTrue(input.getAttribute("type").equals("hidden"));
        assertTrue(input.getAttribute("name").equals(CSRF_PARAM));
        assertTrue(input.hasAttribute("value"));        // token

        // Submit form
        HtmlSubmitInput button = (HtmlSubmitInput) form.getHtmlElementsByTagName("input").get(0);
        HtmlPage page2 = button.click();
        Iterator<HtmlElement> it = page2.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("CSRF Protection OK"));
    }

    /**
     * Retrieves a form, removes CSRF hidden field and attempts to submit. Should
     * result in a 403 error.
     *
     * @throws Exception an error occurs or validation fails.
     */
    @Test
    public void testFormFail() throws Exception {
        HtmlPage page1 = webClient.getPage(webUrl + "resources/csrf");
        HtmlForm form = (HtmlForm) page1.getDocumentElement().getHtmlElementsByTagName("form").get(0);

        // Remove hidden input field to cause a CSRF validation failure
        HtmlElement input = form.getHtmlElementsByTagName("input").get(1);
        form.removeChild(input);

        // Submit form - should fail
        HtmlSubmitInput button = (HtmlSubmitInput) form.getHtmlElementsByTagName("input").get(0);
        try {
            button.click();
            fail("CSRF validation should have failed!");
        } catch (FailingHttpStatusCodeException e) {
            // falls through
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
        HtmlPage page1 = webClient.getPage(webUrl + "resources/csrf");

        // Check response and CSRF header
        WebResponse res = page1.getWebResponse();
        assertEquals(Response.Status.OK.getStatusCode(), res.getStatusCode());
        assertNotNull(res.getResponseHeaderValue(CSRF_HEADER));

        WebRequest req = new WebRequest(new URL(webUrl + "resources/csrf"));
        req.setHttpMethod(HttpMethod.POST);
        req.setAdditionalHeader(CSRF_HEADER, res.getResponseHeaderValue(CSRF_HEADER));
        res = webClient.loadWebResponse(req);
        assertEquals(Response.Status.OK.getStatusCode(), res.getStatusCode());
    }

    /**
     * Checks that regular JAX-RS resource method is not protected for CSRF.
     *
     * @throws Exception an error occurs or validation fails.
     */
    @Test
    public void testJaxrsOk() throws Exception {
        WebRequest req = new WebRequest(new URL(webUrl + "resources/csrf/jaxrs"));
        req.setHttpMethod(HttpMethod.POST);
        WebResponse res = webClient.loadWebResponse(req);
        assertEquals(Response.Status.OK.getStatusCode(), res.getStatusCode());
    }
}

