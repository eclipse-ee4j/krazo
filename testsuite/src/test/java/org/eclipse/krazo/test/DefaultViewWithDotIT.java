/*
 * Copyright (c) 2023 Eclipse Krazo committers and contributors
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
import org.eclipse.krazo.test.defaultview.DefaultViewController;
import org.eclipse.krazo.test.defaultview.DefaultViewWithDotApplication;
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

import static org.junit.Assert.assertEquals;

/**
 * Tests default view extension.
 *
 * @author Tobias Erdle
 */
@RunWith(Arquillian.class)
public class DefaultViewWithDotIT {
    private static final String WEB_INF_SRC = "src/main/resources/defaultview/";
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

    @Deployment(testable = false, name = "default-view")
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addClasses(DefaultViewWithDotApplication.class, DefaultViewController.class)
            .addView(Paths.get(WEB_INF_SRC).resolve("views/index.jsp").toFile(), "index.jsp")
            .addBeansXml()
            .build();
    }

    @Test
    public void test() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "mvc/default-view");

        System.out.println(page.asXml());

        assertEquals("Default-View Extension Test", page.getElementById("headline").getTextContent());
    }

    @Test
    public void testWithAppliedExtension() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "mvc/default-view/with-extension");

        System.out.println(page.asXml());

        assertEquals("Default-View Extension Test", page.getElementById("headline").getTextContent());
    }
}
