/*
 * Copyright © 2017, 2018 Ivar Grimstad
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
package org.eclipse.krazo.test.uribuilder;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Florian Hirsch
 */
public class UriBuilderIT {

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
    }

    @After
    public void tearDown() {
        webClient.closeAllWindows();
    }

    @Test
    public void test() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "resources/uri-builder");
        assertThat(page.getElementById("uri-ref").asText(),
            equalTo("/uri-builder/resources/uri-builder"));
        assertThat(page.getElementById("method-ref").asText(),
            equalTo("/uri-builder/resources/uri-builder"));
        assertThat(page.getElementById("path-params").asText(),
            equalTo("/uri-builder/resources/parameters/path/baz/4711"));
        assertThat(page.getElementById("query-params").asText(),
            equalTo("/uri-builder/resources/parameters/query?q1=foo&q2=42"));
        assertThat(page.getElementById("matrix-params").asText(),
            equalTo("/uri-builder/resources/parameters/matrix;m1=foo;m2=42"));
        assertThat(page.getElementById("bean-params").asText(),
            equalTo("/uri-builder/resources/parameters/bean/foo;m=42?q=bar"));
    }

}
