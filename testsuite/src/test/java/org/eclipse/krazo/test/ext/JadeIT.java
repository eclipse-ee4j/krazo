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
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Florian Hirsch
 */
@RunWith(Arquillian.class)
public class JadeIT {

    private static final String WEB_INF_SRC = "src/main/resources/jade/";

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

    @Deployment(testable = false, name = "jade")
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.ext.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/config.jade").toFile(), "config.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/helper.jade").toFile(), "helper.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/main.jade").toFile(), "main.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/markdown.jade").toFile(), "markdown.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/includes/footer.jade").toFile(), "includes/footer.jade")
            .addResource(Paths.get(WEB_INF_SRC).resolve("jade.properties").toFile())
            .addBeansXml()
            .addDependency("org.eclipse.krazo.ext:krazo-jade")
            .build();
    }

    @Test
    public void testUsesModel() throws Exception {
        String path = baseURL + "jade?user=mvc%d";
        final HtmlPage page = webClient.getPage(String.format(path, 0));
        assertTrue(page.getTitleText().contains("Jade"));
        for (int i = 0; i < 10; i++) { // just to ensure that not the whole page is cached
            final HtmlPage subPage = webClient.getPage(String.format(path, i));
            final DomElement h1 = subPage.getFirstByXPath("//html/body/h1");
            assertTrue(h1.getTextContent().contains("mvc" + i));
        }
    }

    @Test
    public void testIncludesViews() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "jade");
        final DomElement footer = page.getFirstByXPath("//p[@class='footer']");
        assertTrue(footer.getTextContent().contains("Eclipse Krazo committers and contributors"));
    }

    @Test
    public void testUsesFilters() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "jade/markdown");
        final List<DomElement> elements = page.getByXPath("//html/body/ul/li");
        assertEquals(3, elements.size());
    }

    @Test
    public void testConfiguration() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "jade/config");
        final DomElement systemProperties = page.getFirstByXPath("//p[@class='SystemProperties']");
        assertEquals("SystemProperties", systemProperties.getTextContent());
        final DomElement configFile = page.getFirstByXPath("//p[@class='ConfigFile']");
        assertEquals("ConfigFile", configFile.getTextContent());
    }

    @Test
    public void testHelper() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "jade/helper");
        final DomElement element = page.getFirstByXPath("//p[@class='result']");
        assertEquals("3", element.getTextContent());
    }
}
