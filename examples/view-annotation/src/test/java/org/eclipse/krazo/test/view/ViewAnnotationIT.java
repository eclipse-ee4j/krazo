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
package org.eclipse.krazo.test.view;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ViewAnnotationIT {

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
        // we explicitly want to test some status codes
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
    }

    @After
    public void tearDown() {
        webClient.close();
    }

    @Test
    public void testVoid() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/void");
        assertEquals(200, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asNormalizedText().contains("Hello World"));
    }

    @Test
    public void testString() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/string");
        assertEquals(200, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asNormalizedText().contains("Bye World"));
    }

    @Test
    public void testNull() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/null");
        assertEquals(200, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asNormalizedText().contains("Hello World"));
    }

    @Test
    public void testVoidClass() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/class/void");
        assertEquals(200, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asNormalizedText().contains("Hello World"));
    }

    @Test
    public void testStringClass() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/class/string");
        assertEquals(200, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asNormalizedText().contains("Bye World"));
    }

    @Test
    public void testNullClass() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/class/null");
        assertEquals(200, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asNormalizedText().contains("Hello World"));
    }

    @Test
    public void testVoidForbiddenException() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/void/forbidden");
        assertEquals(403, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertFalse(it.next().asNormalizedText().contains("Hello World"));
    }

    @Test
    public void testVoidIllegalArgumentException() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/void/illegal-argument");
        assertEquals(500, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asNormalizedText().contains("Hello Error"));
    }

    @Test
    public void testStringForbiddenException() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/string/forbidden");
        assertEquals(403, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertFalse(it.next().asNormalizedText().contains("Hello World"));
    }

    @Test
    public void testStringIllegalArgumentException() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/string/illegal-argument");
        assertEquals(500, page.getWebResponse().getStatusCode());
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asNormalizedText().contains("Hello Error"));
    }

}
