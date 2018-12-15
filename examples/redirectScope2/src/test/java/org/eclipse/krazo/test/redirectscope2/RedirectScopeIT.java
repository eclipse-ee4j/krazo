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
package org.eclipse.krazo.test.redirectscope2;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RedirectScopeIT {

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
    public void testSingleRequest() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "resources/redirect/from");
        assertTrue(page.asXml().contains("Redirect about to happen"));
    }

    @Test
    public void testDoubleRequest() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "resources/redirect/from");
        assertTrue(page.asXml().contains("Redirect about to happen"));
        page = webClient.getPage(webUrl + "resources/redirect/from");
        assertTrue(page.asXml().contains("Redirect about to happen"));
    }
}
