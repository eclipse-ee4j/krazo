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
package org.eclipse.krazo.test.annotations;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class AnnotationsIT {

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    }

    @After
    public void tearDown() {
        webClient.closeAllWindows();
    }

    @Test
    public void testNoView() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/annotations/no_view");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Success"));
    }

    @Test
    public void testWithView() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/annotations/view");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Success"));
    }


    @Test
    public void testWithViewInterface() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/annotations/view_interface");
        final Iterator<HtmlElement> it = page.getDocumentElement().getHtmlElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Success"));
    }

    @Test
    public void testNoOverrideJaxrs() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/annotations/no_override_jaxrs");
        assertNull(page);       // Empty 204
    }

    @Test
    public void testNoOverrideMvc() throws Exception {
        final HtmlPage page = webClient.getPage(webUrl + "resources/annotations/no_override_mvc");
        assertEquals(500, page.getWebResponse().getStatusCode());       // void but no @View -> Exception
    }
}
