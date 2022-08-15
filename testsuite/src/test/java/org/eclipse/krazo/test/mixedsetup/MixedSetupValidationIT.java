/*
 * Copyright (c) 2018, 2022 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.test.mixedsetup;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests resource containing MVC as well as non-MVC methods. Sets its focus in Bean Validation.
 */
@RunWith(Arquillian.class)
public class MixedSetupValidationIT {

    private static final String WEB_INF_SRC = "src/main/resources/mixedsetup/";

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;
    private HttpClient httpClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.getOptions()
            .setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions()
            .setRedirectEnabled(true);

        httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
    }

    @Deployment(testable = false, name = "mixed")
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.mixedsetup")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/index.jsp").toFile(), "index.jsp")
            .addBeansXml()
            .build();
    }

    @After
    public void teardown() {
        webClient.close();
    }

    @Test
    public void shouldNotShowMessageWhenMvcInputIsValid() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/mixed");

        final HtmlForm form = page.getFormByName("todoForm");
        form.getInputByName("title").setValue("Test");
        form.getInputByName("content").setValue("Test");

        final HtmlPage resultPage = form.getInputByName("submit").click();

        assertTrue(resultPage.getElementById("validation-performed").getTextContent().isEmpty());
    }

    @Test
    public void shouldShowMessageWhenMvcInputIsInvalid() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/mixed");

        final HtmlForm form = page.getFormByName("todoForm");
        form.getInputByName("title").setValue("Test");

        final HtmlPage resultPage = form.getInputByName("submit").click();
        assertTrue(resultPage.getElementById("validation-performed").getTextContent().contains("true"));
    }

    @Test
    public void shouldReturnHttp204WhenAPIInputIsValid() throws Exception {
        final String payload = "{\"title\":\"Test\",\"content\":\"Test\"}";
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseURL + "resources/mixed"))
            .POST(HttpRequest.BodyPublishers.ofString(payload))
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .build();

        final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.statusCode());
    }

    @Test
    public void shouldReturnHttp400WhenAPIInputIsInvalid() throws Exception {
        final String payload = "{\"title\":\"Test\",\"content\":\"\"}";
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseURL + "resources/mixed"))
            .POST(HttpRequest.BodyPublishers.ofString(payload))
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .build();

        final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.statusCode());
    }
}

