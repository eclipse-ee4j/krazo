/*
 * Copyright © 2019 Eclipse Krazo committers and contributors
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

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import org.eclipse.krazo.test.csrf.exception.CsrfCustomExceptionApplication;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Integration test to check the behaviour of Krazo when a custom {@link javax.ws.rs.ext.ExceptionMapper} is used.
 *
 * @author Tobias Erdle
 */
@RunWith(Arquillian.class)
public class CsrfCustomExceptionIT {

    private static final String WEB_INF_SRC = "src/main/resources/csrf/exception/";

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.getOptions()
            .setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions()
            .setRedirectEnabled(false);
    }

    @After
    public void tearDown() {
        webClient.close();
    }

    @Deployment(testable = false, name = "csrf-exception")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.csrf.exception")
            .addView(Paths.get(WEB_INF_SRC)
                .resolve("views/csrf-exception.jsp")
                .toFile(), "csrf-exception.jsp")
            .addBeansXml()
            .build();
    }

    /**
     * Check if Krazo returns a custom value when the {@link org.eclipse.krazo.Properties#STRICT_VIEW_RESOLUTION} flag is
     * set to false (see {@link CsrfCustomExceptionApplication} for the setting).
     */
    @Test
    public void testCustomExceptionMapperReturnsPlainTextWithMessageWhenStrictViewResolutionIsDisabled() throws IOException {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/csrf-exception");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final Page result = button.click();

        assertEquals(499, result.getWebResponse()
            .getStatusCode());
        assertEquals("Invalid CSRF token", result.getWebResponse()
            .getContentAsString());
    }
}

