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
package org.eclipse.krazo.test.ext;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Gregor Tudan
 */
@RunWith(Arquillian.class)
public class ThymeleafIT {

    private static final String WEB_INF_SRC = "src/main/resources/thymeleaf/";

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
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.ext.thymeleaf")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/hello.html").toFile(), "hello.html")
            .addBeansXml()
            .addDependency("org.eclipse.krazo.ext:krazo-thymeleaf")
            .build();
    }

    @Test
    @RunAsClient
    public void test() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/hello?user=mvc");
        final DomElement h1 = page.getElementsByTagName("h1").get(0);
        assertNotNull(h1);
        assertTrue(h1.getTextContent().contains("mvc"));
    }
}
