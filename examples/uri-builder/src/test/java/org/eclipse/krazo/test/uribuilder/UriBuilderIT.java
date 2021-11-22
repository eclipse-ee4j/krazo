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
package org.eclipse.krazo.test.uribuilder;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        webClient.close();
    }

    @Test
    public void test() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "resources/uri-builder");
        assertEquals("/uri-builder/resources/uri-builder",
            page.getElementById("uri-ref").asNormalizedText());
        assertEquals("/uri-builder/resources/uri-builder",
            page.getElementById("method-ref").asNormalizedText());
        assertEquals("/uri-builder/resources/parameters/path/baz/4711",
            page.getElementById("path-params").asNormalizedText());
        assertEquals("/uri-builder/resources/parameters/query?q1=foo&q2=42",
            page.getElementById("query-params").asNormalizedText());
        assertEquals("/uri-builder/resources/parameters/matrix;m1=foo;m2=42",
            page.getElementById("matrix-params").asNormalizedText());
        assertEquals("/uri-builder/resources/parameters/bean/foo;m=42?q=bar",
            page.getElementById("bean-params").asNormalizedText());
    }

}
