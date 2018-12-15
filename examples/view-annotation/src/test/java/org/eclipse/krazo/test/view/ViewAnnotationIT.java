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
package org.eclipse.krazo.test.view;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
        webClient.closeAllWindows();
    }

    @Test
    public void testVoid() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/void");
        assertThat(page.getWebResponse().getStatusCode(), is(200));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testString() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/string");
        assertThat(page.getWebResponse().getStatusCode(), is(200));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Bye World"));
    }

    @Test
    public void testNull() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/null");
        assertThat(page.getWebResponse().getStatusCode(), is(200));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testVoidClass() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/class/void");
        assertThat(page.getWebResponse().getStatusCode(), is(200));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testStringClass() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/class/string");
        assertThat(page.getWebResponse().getStatusCode(), is(200));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Bye World"));
    }

    @Test
    public void testNullClass() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/class/null");
        assertThat(page.getWebResponse().getStatusCode(), is(200));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testVoidForbiddenException() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/void/forbidden");
        assertThat(page.getWebResponse().getStatusCode(), is(403));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testVoidIllegalArgumentException() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/void/illegal-argument");
        assertThat(page.getWebResponse().getStatusCode(), is(500));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello Error"));
    }

    @Test
    public void testStringForbiddenException() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/string/forbidden");
        assertThat(page.getWebResponse().getStatusCode(), is(403));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello World"));
    }

    @Test
    public void testStringIllegalArgumentException() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/string/illegal-argument");
        assertThat(page.getWebResponse().getStatusCode(), is(500));
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Hello Error"));
    }

}
