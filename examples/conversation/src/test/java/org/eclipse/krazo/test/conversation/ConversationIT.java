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
package org.eclipse.krazo.test.conversation;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ConversationIT {

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
    public void testConversation() throws Exception {
        HtmlPage page;
        Iterator<HtmlElement> it;

        page = webClient.getPage(webUrl + "resources/converse/start");
        it = page.getDocumentElement().getElementsByTagName("p").iterator();
        final String secret = it.next().asNormalizedText();
        System.out.println(secret);

        page = webClient.getPage(webUrl + "resources/converse/" +
            page.getDocumentElement().getElementsByTagName("a")
                .iterator().next().getAttribute("href"));
        it = page.getDocumentElement().getElementsByTagName("p").iterator();
        assertEquals(secret, it.next().asNormalizedText());

        page = webClient.getPage(webUrl + "resources/converse/stop");
        it = page.getDocumentElement().getElementsByTagName("p").iterator();
        assertNotEquals(secret, it.next().asNormalizedText());
    }
}
