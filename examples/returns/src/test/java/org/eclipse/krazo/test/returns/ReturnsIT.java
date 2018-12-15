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
package org.eclipse.krazo.test.returns;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Tests all possible return types from a controller method, including an arbitrary
 * type on which {@code toString} is called and a {@code Response} that wraps
 * other types.
 *
 * @author Santiago Pericas-Geertsen
 */
public class ReturnsIT {

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
    }

    @After
    public void tearDown() {
        webClient.closeAllWindows();
    }

    @Test
    public void testString() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/string");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testViewable() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/viewable");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testResponse() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/response");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testMyViewable() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/myviewable");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testMyViewableNull() throws Exception {
        try {
            final HtmlPage page = webClient.getPage(webUrl + "resources/myviewable/null");
        } catch (FailingHttpStatusCodeException e) {
            assertEquals(e.getStatusCode(), 500);
            return;
        }
        fail();
    }

    @Test
    public void testResponseViewable() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/response/viewable");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testResponseMyViewable() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/response/myviewable");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }
}
