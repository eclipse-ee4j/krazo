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
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
// To get the test to work, we'd need to patch Wildfly with an own Asciidoctor module
// (see: https://github.com/asciidoctor/asciidoctorj/blob/26641dbe1510a83fbb9c5cab3974a8736b385bdd/README.adoc#running-asciidoctorj-on-wildfly-as)
// We think that isn't worth the effort in our case and skip the test for that reason.
@Category(IgnoreOnWildfly.class)
public class AsciiDocIT {

    private static final String WEB_INF_SRC = "src/main/resources/asciidoc/";

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

    @Deployment(testable = false, name = "asciidoc")
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.ext.asciidoc")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/hello.adoc").toFile(), "hello.adoc")
            .addBeansXml()
            .addDependency("org.eclipse.krazo.ext:krazo-asciidoc")
            .build();
    }

    @Test
    public void testView1() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/hello?user=mvc");
        final String h2 = page.getElementsByTagName("h2").get(0).getTextContent();
        assertTrue(h2.contains("mvc"));
    }
}
