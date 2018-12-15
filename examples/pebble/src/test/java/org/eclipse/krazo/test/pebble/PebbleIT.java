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
package org.eclipse.krazo.test.pebble;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PebbleIT {

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
    String path = webUrl + "pebble";
    HtmlPage page = webClient.getPage(path);

    assertTrue(page.asText().contains("Pebble's home page"));
    assertTrue(page.asText().contains("Rock solid"));
  }

  @Test
  public void testUsesFilter() throws IOException {
    String path = webUrl + "pebble/filter";
    String text = "To be filtered";

    HtmlPage page = webClient.getPage(path);

    assertFalse(page.asText().contains(text));
    assertTrue(page.asText().contains(text.toUpperCase()));
  }

}
