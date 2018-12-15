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
package org.eclipse.krazo.test.produces;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ProducesIT {

    private final String ACCEPT_HEADER = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
    private final String ACCEPT_LANGUAGE = "en-US,en;q=0.8,es;q=0.6";

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
    }

    @After
    public void tearDown() {
        webClient.closeAllWindows();
    }

    @Test
    public void testNoProducesEmptyAccept1() throws Exception {
        final WebResponse wr = webClient.loadWebResponse(
                new WebRequest(new URL(webUrl + "resources/no_produces1"), ""));
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.TEXT_HTML, wr.getContentType());     // default
    }

    @Test
    public void testNoProducesEmptyAccept2() throws Exception {
        final WebResponse wr = webClient.loadWebResponse(
                new WebRequest(new URL(webUrl + "resources/no_produces2"), ""));
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.TEXT_HTML, wr.getContentType());     // default
    }

    @Test
    public void testNoProduces1() throws Exception {
        final WebResponse wr = webClient.loadWebResponse(
                new WebRequest(new URL(webUrl + "resources/no_produces1"), ACCEPT_HEADER));
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.TEXT_HTML, wr.getContentType());
    }

    @Test
    public void testNoProduces2() throws Exception {
        final WebResponse wr = webClient.loadWebResponse(
                new WebRequest(new URL(webUrl + "resources/no_produces2"), ACCEPT_HEADER));
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.TEXT_HTML, wr.getContentType());
    }

    @Test
    public void testMultipleProduces1() throws Exception {
        final WebResponse wr = webClient.loadWebResponse(
                new WebRequest(new URL(webUrl + "resources/multiple_produces2"), ACCEPT_HEADER));
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.APPLICATION_XHTML_XML, wr.getContentType());
    }

    @Test
    public void testMultipleProduces2() throws Exception {
        final WebResponse wr = webClient.loadWebResponse(
                new WebRequest(new URL(webUrl + "resources/multiple_produces2"), ACCEPT_HEADER));
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.APPLICATION_XHTML_XML, wr.getContentType());
    }

    @Test
    public void otherProduces1() throws Exception {
        final WebResponse wr = webClient.loadWebResponse(
                new WebRequest(new URL(webUrl + "resources/other_produces1"), ACCEPT_HEADER));
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.APPLICATION_XHTML_XML, wr.getContentType());
    }

    @Test
    public void otherProduces2() throws Exception {
        final WebResponse wr = webClient.loadWebResponse(
                new WebRequest(new URL(webUrl + "resources/other_produces2"), ACCEPT_HEADER));
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.APPLICATION_XHTML_XML, wr.getContentType());
    }

    @Test
    public void language1() throws Exception {
        final WebRequest wrq = new WebRequest(new URL(webUrl + "resources/language1"), ACCEPT_HEADER);
        wrq.setAdditionalHeader("Accept-Language", ACCEPT_LANGUAGE);
        final WebResponse wr = webClient.loadWebResponse(wrq);
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.APPLICATION_XHTML_XML, wr.getContentType());
        assertEquals("es", wr.getResponseHeaderValue("Content-Language"));
    }

    @Test
    public void language2() throws Exception {
        final WebRequest wrq = new WebRequest(new URL(webUrl + "resources/language2"), ACCEPT_HEADER);
        wrq.setAdditionalHeader("Accept-Language", ACCEPT_LANGUAGE);
        final WebResponse wr = webClient.loadWebResponse(wrq);
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.APPLICATION_XHTML_XML, wr.getContentType());
        assertEquals("es", wr.getResponseHeaderValue("Content-Language"));
    }

    @Test
    public void locale1() throws Exception {
        final WebRequest wrq = new WebRequest(new URL(webUrl + "resources/locale1"), ACCEPT_HEADER);
        wrq.setAdditionalHeader("Accept-Language", ACCEPT_LANGUAGE);
        final WebResponse wr = webClient.loadWebResponse(wrq);
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.APPLICATION_XHTML_XML, wr.getContentType());
        assertEquals("en-GB", wr.getResponseHeaderValue("Content-Language"));
    }

    @Test
    public void locale2() throws Exception {
        final WebRequest wrq = new WebRequest(new URL(webUrl + "resources/locale2"), ACCEPT_HEADER);
        wrq.setAdditionalHeader("Accept-Language", ACCEPT_LANGUAGE);
        final WebResponse wr = webClient.loadWebResponse(wrq);
        assertEquals(Response.Status.OK.getStatusCode(), wr.getStatusCode());
        assertEquals(MediaType.APPLICATION_XHTML_XML, wr.getContentType());
        assertEquals("en-GB", wr.getResponseHeaderValue("Content-Language"));
    }
}
