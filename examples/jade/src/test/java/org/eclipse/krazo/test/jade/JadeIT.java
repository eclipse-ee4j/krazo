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
package org.eclipse.krazo.test.jade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlUnorderedList;

/**
 * @author Florian Hirsch
 */
public class JadeIT {

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
    public void testUsesModel() throws Exception {
        String path = webUrl + "jade?user=mvc%d";
        HtmlPage page = webClient.getPage(String.format(path, 0));
        assertTrue(page.getTitleText().contains("Jade"));
        for (int i = 0; i < 10; i++) { // just to ensure that not the whole page is cached
            page = webClient.getPage(String.format(path, i));
            HtmlHeading1 h1 = page.getFirstByXPath("//html/body/h1");
            assertTrue(h1.asText().contains("mvc" + i));
        }
    }

    @Test
    public void testIncludesViews() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "jade");
        HtmlParagraph footer = page.getFirstByXPath("//p[@class='footer']");
        assertTrue(footer.asText().contains("Ivar Grimstad"));
    }

    @Test
    public void testUsesFilters() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "jade/markdown");
        HtmlUnorderedList ul = page.getFirstByXPath("//html/body/ul");
        assertEquals(3, ul.getChildElementCount());
    }

    @Test
    public void testConfiguration() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "jade/config");
        HtmlParagraph systemProperties = page.getFirstByXPath("//p[@class='SystemProperties']");
        assertEquals("SystemProperties", systemProperties.asText());
        HtmlParagraph configFile = page.getFirstByXPath("//p[@class='ConfigFile']");
        assertEquals("ConfigFile", configFile.asText());
    }

    @Test
    public void testHelper() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "jade/helper");
        HtmlParagraph result = page.getFirstByXPath("//p[@class='result']");
        assertEquals("3", result.asText());
    }
}
