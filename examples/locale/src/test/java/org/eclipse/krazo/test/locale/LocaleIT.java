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
package org.eclipse.krazo.test.locale;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * @author Christian Kaltepoth
 */
public class LocaleIT {

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
    public void testLocaleFromAcceptLanguageHeader() throws Exception {

        // Accept-Language header for "it"
        webClient.addRequestHeader("Accept-Language", "it");

        // The default resolver prefers the locale from the header
        HtmlPage page = webClient.getPage(webUrl + "resources/locale");
        assertThat(page.getWebResponse().getContentAsString(),
                CoreMatchers.containsString("<p>Locale: it</p>"));
    }

    @Test
    public void testCustomLocaleResolverWins() throws Exception {

        // the default resolver would resolve "it"
        webClient.addRequestHeader("Accept-Language", "it");

        // custom resolver uses "lang" query parameter
        HtmlPage page = webClient.getPage(webUrl + "resources/locale?lang=pl");

        // the customer resolver wins
        assertThat(page.getWebResponse().getContentAsString(),
                CoreMatchers.containsString("<p>Locale: pl</p>"));

    }

}
