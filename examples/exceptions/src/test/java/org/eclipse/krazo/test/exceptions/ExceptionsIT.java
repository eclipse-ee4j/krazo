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
package org.eclipse.krazo.test.exceptions;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests responses that return error codes like 400 and 500 to ensure that views
 * are processed correctly.
 *
 * @author Santiago Pericas-Geertsen
 */
public class ExceptionsIT {

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
    }

    @After
    public void tearDown() {
        webClient.closeAllWindows();
    }

    @Test
    public void testNotFound() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/exceptions/not_found");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testNotFoundNoView() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/exceptions/not_found_no_view");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertFalse(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testInternalError() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/exceptions/internal_error");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testInternalErrorNoView() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/exceptions/internal_error_no_view");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertFalse(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testInternalErrorMapped() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/exceptions/internal_error_mapped");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }
}

