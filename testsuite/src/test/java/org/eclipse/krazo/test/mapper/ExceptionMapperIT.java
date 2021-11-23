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

package org.eclipse.krazo.test.mapper;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ExceptionMapperIT {

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;

    @Deployment(testable = false)
    public static Archive<WebArchive> createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.mapper")
            .addView(new StringAsset("<h1>${message}</h1>"), "success.jsp")
            .addView(new StringAsset("<h1>Exception caught: ${error}</h1>"), "mvc-error.jsp")
            .addBeansXml()
            .build();
    }

    @Before
    public void before() {
        webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setRedirectEnabled(false);
    }

    @Test
    public void testControllerHappyPath() throws IOException {

        Page page = webClient.getPage(baseURL.toString() + "mvc/mappers/success");
        WebResponse webResponse = page.getWebResponse();

        assertEquals(200, webResponse.getStatusCode());
        assertTrue(webResponse.getContentType().startsWith("text/html"));
        assertTrue(webResponse.getContentAsString().contains("<h1>Controller was executed without errors!</h1>"));

    }

    @Test
    public void testHandledByPlainTextMapper() throws IOException {

        Page page = webClient.getPage(baseURL.toString() + "mvc/mappers/fail-plain-text");
        WebResponse webResponse = page.getWebResponse();

        assertEquals(491, webResponse.getStatusCode());
        assertTrue(webResponse.getContentType().startsWith("text/plain"));
        assertEquals("Exception caught: Error thrown by controller", webResponse.getContentAsString());

    }

    @Test
    public void testHandledByMvcViewMapper() throws IOException {

        Page page = webClient.getPage(baseURL.toString() + "mvc/mappers/fail-mvc-view");
        WebResponse webResponse = page.getWebResponse();

        assertEquals(492, webResponse.getStatusCode());
        assertTrue(webResponse.getContentType().startsWith("text/html"));
        assertTrue(webResponse.getContentAsString().contains("<h1>Exception caught: Error thrown by controller</h1>"));

    }
}
