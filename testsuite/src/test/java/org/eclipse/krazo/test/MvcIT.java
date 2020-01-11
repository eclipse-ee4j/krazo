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
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * Tests Mvc Implementation.
 *
 * @author Santiago Pericas-Geertsen
 */
@RunWith(Arquillian.class)
public class MvcIT {

    private static final String CSRF_PARAM = "_csrf";

    private static final String WEB_INF_SRC = "src/main/resources/mvc/";

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

    @Deployment(testable = false, name = "thymeleaf")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.mvc")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/mvc.jsp").toFile(), "mvc.jsp")
            .addBeansXml()
            .build();
    }

    @Test
    public void test() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/mvc");

        assertEquals(baseURL.getPath() + "resources", page.getElementById("basePath").getTextContent());
        assertEquals(CSRF_PARAM, page.getElementById("csrf").getTextContent());
        assertEquals("<&>", page.getElementById("encoders").getTextContent());
        assertEquals("true", page.getElementById("config").getTextContent());
    }
}

