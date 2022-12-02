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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests resource containing MVC as well as non-MVC methods. Sets its focus in Bean Validation.
 */
@RunWith(Arquillian.class)
public class MixedSetupValidationIT {

    private static final String WEB_INF_SRC = "src/main/resources/mixedsetup/";

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;
    private OkHttpClient httpClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.getOptions()
            .setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions()
            .setRedirectEnabled(true);

        httpClient = new OkHttpClient().newBuilder()
            .readTimeout(Duration.of(1000, ChronoUnit.MILLIS))
            .writeTimeout(Duration.of(1000, ChronoUnit.MILLIS))
            .build();
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
        form.getInputByName("title").setValueAttribute("Test");
        form.getInputByName("content").setValueAttribute("Test");

        final HtmlPage resultPage = form.getInputByName("submit").click();

        assertTrue(resultPage.getElementById("validation-performed").getTextContent().isEmpty());
    }

    @Test
    public void shouldShowMessageWhenMvcInputIsInvalid() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "resources/mixed");

        final HtmlForm form = page.getFormByName("todoForm");
        form.getInputByName("title").setValueAttribute("Test");

        final HtmlPage resultPage = form.getInputByName("submit").click();
        assertTrue(
            resultPage.getElementById("validation-performed").getTextContent().contains("true"));
    }

    @Test
    public void shouldReturnHttp204WhenAPIInputIsValid() throws Exception {
        final String payload = "{\"title\":\"Test\",\"content\":\"Test\"}";

        final Request request = new Request.Builder()
            .url(URI.create(baseURL + "resources/mixed").toURL())
            .post(RequestBody.create(payload, okhttp3.MediaType.parse("application/json")))
            .build();

        final okhttp3.Response response = httpClient.newCall(request).execute();

        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.code());
    }

    @Test
    public void shouldReturnHttp400WhenAPIInputIsInvalid() throws Exception {
        final String payload = "{\"title\":\"Test\",\"content\":\"\"}";

        final Request request = new Request.Builder()
            .url(URI.create(baseURL + "resources/mixed").toURL())
            .post(RequestBody.create(payload, okhttp3.MediaType.parse("application/json")))
            .build();

        final okhttp3.Response response = httpClient.newCall(request).execute();

        assertEquals(Status.BAD_REQUEST.getStatusCode(), response.code());
    }
}

