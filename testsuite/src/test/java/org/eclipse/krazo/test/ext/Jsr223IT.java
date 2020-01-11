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
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.eclipse.krazo.test.helper.annotation.IgnoreOnWildfly;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class Jsr223IT {

    private static final String WEB_INF_SRC = "src/main/resources/jsr223/";

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

    @Deployment(name = "jsr223", testable = false)
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.ext.jsr223")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/index.js").toFile(), "index.js")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/index.py").toFile(), "index.py")
            .addBeansXml()
            .addDependency("org.eclipse.krazo.ext:krazo-jsr223")
            .addDependency("org.python:jython-standalone:2.7.0")
            .build();
    }

    @Test
    public void testNashorn() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "mvc/nashorn?name=Nashorn");
        assertTrue(page.getBody().getTextContent().contains("Hello Nashorn"));
    }

    @Test
    // Ignore on wildfly as we'd have to configure the server to get this test to run.
    // Also it doesn't seem that there will be a Jython 3 in the near future, so
    // in 2020 (EOL Python 2) we probably need to remove this test with Jython 2.7 anyway
    // and the above mentioned configuration effort would count for nothing.
    @Category(IgnoreOnWildfly.class)
    public void testJython() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "mvc/jython?name=Jython");
        assertTrue(page.getBody().getTextContent().contains("Hello Jython"));
    }
}
