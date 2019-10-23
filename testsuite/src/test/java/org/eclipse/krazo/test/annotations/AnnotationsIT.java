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
package org.eclipse.krazo.test.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Iterator;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AnnotationsIT {

    private static final String WEB_INF_SRC = "src/main/resources/annotations/";

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;

    @Before
    public void setUp() throws Exception {
        webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setRedirectEnabled(true);
    }

    @After
    public void tearDown() throws Exception {
        webClient.close();
    }

    @Deployment(testable = false, name = "annotations")
    public static Archive createDeployment() {
        return new WebArchiveBuilder().addPackage("org.eclipse.krazo.test.annotations")
                .addView(Paths.get(WEB_INF_SRC).resolve("views/error.jsp").toFile(), "error.jsp")
                .addView(Paths.get(WEB_INF_SRC).resolve("views/success.jsp").toFile(), "success.jsp").addBeansXml()
                .build();
    }

    @Test
    public void testNoView() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/annotations/no_view");
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Success"));
    }

    @Test
    public void testWithView() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/annotations/view");
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Success"));
    }

    @Test
    public void testWithViewInterface() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/annotations/view_interface");
        final Iterator<HtmlElement> it = page.getDocumentElement().getElementsByTagName("h1").iterator();
        assertTrue(it.next().asText().contains("Success"));
    }

    @Test
    public void testNoOverrideJaxrs() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/annotations/no_override_jaxrs");
        assertNull(page); // Empty 204
    }

    @Test
    public void testNoOverrideMvc() throws Exception {
        final Page page = webClient.getPage(baseURL + "resources/annotations/no_override_mvc");
        assertEquals(500, page.getWebResponse().getStatusCode()); // void but no @View -> Exception
    }
}
