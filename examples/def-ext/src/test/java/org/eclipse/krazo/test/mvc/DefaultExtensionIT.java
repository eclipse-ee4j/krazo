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
package org.eclipse.krazo.test.mvc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests Default Extension Implementation.
 *
 * @author Dmytro Maidaniuk
 */
public class DefaultExtensionIT {

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
    public void testString() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "resources/def-ext/string");
        assertEquals("/test-def-ext/resources", page.getElementById("basePath").asText());
        assertEquals("jsp", page.getElementById("defaultExtension").asText());
    }
    
    @Test
    public void testViewable() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "resources/def-ext/viewable");
        assertEquals("/test-def-ext/resources", page.getElementById("basePath").asText());
        assertEquals("jsp", page.getElementById("defaultExtension").asText());
    }
    
    @Test
    public void testResponse() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "resources/def-ext/response");
        assertEquals("/test-def-ext/resources", page.getElementById("basePath").asText());
        assertEquals("jsp", page.getElementById("defaultExtension").asText());
    }
    
    @Test
    public void testVoid() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "resources/def-ext/void");
        assertEquals("/test-def-ext/resources", page.getElementById("basePath").asText());
        assertEquals("jsp", page.getElementById("defaultExtension").asText());
    }
}

