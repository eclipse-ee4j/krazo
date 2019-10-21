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

import static org.junit.Assert.assertEquals;
import java.net.URL;
import java.nio.file.Paths;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
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
public class CsrfValidateFilterIT {

    private static final String WEB_INF_SRC = "src/main/resources/csrf/methods/";

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

    @After
    public void tearDown() {
        webClient.close();
    }

    @Deployment(testable = false, name = "csrf-methods")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.csrf.methods")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-exception-delete.jsp")
                .toFile(), "csrf-exception-delete.jsp")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-exception-patch.jsp")
                .toFile(), "csrf-exception-patch.jsp")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-exception-post.jsp")
                .toFile(), "csrf-exception-post.jsp")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-exception-put.jsp")
                .toFile(), "csrf-exception-put.jsp")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-ok-delete.jsp")
                .toFile(), "csrf-ok-delete.jsp")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-ok-patch.jsp")
                .toFile(), "csrf-ok-patch.jsp")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-ok-post.jsp")
                .toFile(), "csrf-ok-post.jsp")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-ok-put.jsp")
                .toFile(), "csrf-ok-put.jsp")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/ok.jsp")
                .toFile(), "ok.jsp")
            .addBeansXml()
            .build();
    }

    @Test
    public void testDeleteWithoutCsrfFieldFailsWithStatusCode403() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-methods/exception-delete");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(403, result.getWebResponse()
            .getStatusCode());
    }

    @Test
    public void testPatchWithoutCsrfFieldFailsWithStatusCode403() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-methods/exception-patch");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(403, result.getWebResponse()
            .getStatusCode());
    }

    @Test
    public void testPutWithoutCsrfFieldFailsWithStatusCode403() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-methods/exception-put");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(403, result.getWebResponse()
            .getStatusCode());
    }

    @Test
    public void testPostWithoutCsrfFieldFailsWithStatusCode403() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-methods/exception-post");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(403, result.getWebResponse()
            .getStatusCode());
    }



    @Test
    public void testDeleteWithCsrfFieldWorksWithStatusCode200() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-methods/ok-delete");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(200, result.getWebResponse()
            .getStatusCode());
    }

    @Test
    public void testPatchWithCsrfFieldWorksWithStatusCode200() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-methods/ok-patch");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(200, result.getWebResponse()
            .getStatusCode());
    }

    @Test
    public void testPutWithCsrfFieldWorksWithStatusCode200() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-methods/ok-put");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(200, result.getWebResponse()
            .getStatusCode());
    }

    @Test
    public void testPostWithCsrfFieldWorksWithStatusCode200() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-methods/ok-post");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(200, result.getWebResponse()
            .getStatusCode());
    }
}
