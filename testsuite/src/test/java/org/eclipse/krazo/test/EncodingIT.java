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

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Tests the Content-Type header and encoding when using JSPs or Facelets.
 *
 * @author Florian Hirsch
 */
@RunWith(Arquillian.class)
public class EncodingIT {

    private static final String WEB_INF_SRC = "src/main/resources/encoding/";

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.getOptions().setRedirectEnabled(true);
    }

    @After
    public void tearDown() {
        webClient.close();
    }

    @Deployment(testable = false, name = "encoding")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.encoding")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/iso-8859-15.jsp").toFile(), "iso-8859-15.jsp")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/iso-8859-15.xhtml").toFile(), "iso-8859-15.xhtml")
            .addWebXml(Paths.get(WEB_INF_SRC).resolve("web.xml").toFile())
            .addBeansXml()
            .build();
    }

    @Test
    public void jsp_should_use_content_type_page_directive() throws Exception {
        HtmlPage page = webClient.getPage(baseURL + "resources/encoding/jsp/iso-8859-15");
        checkContentType(page, "text/html; charset=ISO-8859-15");
        checkUmlauts(page);
    }

    @Test
    public void jsp_should_allow_produces_text_html() throws Exception {
        HtmlPage page = webClient.getPage(baseURL + "resources/encoding/jsp/iso-8859-15-text-html");
        checkContentType(page, "text/html; charset=ISO-8859-15");
        checkUmlauts(page);
    }

    @Test
    public void jsp_should_ignore_produces_text_html_with_charset() throws Exception {
        HtmlPage page = webClient.getPage(baseURL + "resources/encoding/jsp/iso-8859-15-text-html-charset-utf-8");
        checkContentType(page, "text/html; charset=ISO-8859-15");
        checkUmlauts(page);
    }

    @Test
    public void facelets_should_use_content_type_view_attribute() throws Exception {
        HtmlPage page = webClient.getPage(baseURL + "resources/encoding/facelets/iso-8859-15");
        checkContentType(page, "text/html; charset=ISO-8859-15");
        checkUmlauts(page);
    }

    @Test
    public void facelets_should_allow_produces_text_html() throws Exception {
        HtmlPage page = webClient.getPage(baseURL + "resources/encoding/facelets/iso-8859-15-text-html");
        checkContentType(page, "text/html; charset=ISO-8859-15");
        checkUmlauts(page);
    }

    @Test
    public void facelets_should_ignore_produces_text_html_with_charset() throws Exception {
        HtmlPage page = webClient.getPage(baseURL + "resources/encoding/facelets/iso-8859-15-text-html-charset-utf-8");
        checkContentType(page, "text/html; charset=ISO-8859-15");
        checkUmlauts(page);
    }

    private void checkContentType(HtmlPage page, String expectedContentType) {
        // Don't trust helper methods. Compare the real header values.
        Optional<NameValuePair> contentTypeHeader = page.getWebResponse().getResponseHeaders().stream()
            .filter(header -> "Content-Type".equals(header.getName())).findFirst();
        if (!contentTypeHeader.isPresent()) {
            fail("No Content-Type header found");
        }
        assertEquals(
            expectedContentType.replaceAll("\\s", "").toLowerCase(),
            contentTypeHeader.get().getValue().replaceAll("\\s", "").toLowerCase()
        );
    }

    private void checkUmlauts(HtmlPage page) {
        String umlauts = page.getElementById("umlauts").asText();
        assertThat(umlauts, is("äöü"));
    }

}

