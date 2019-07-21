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
package org.eclipse.krazo.test.ext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Florian Hirsch
 */
@RunWith(Arquillian.class)
public class JadeIT {

    private static final String WEB_INF_SRC = "src/main/resources/jade/";

    @ArquillianResource
    private URL baseURL;

    @Drone
    private WebDriver webDriver;

    @Deployment(testable = false, name = "jade")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.ext.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/config.jade").toFile(), "config.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/helper.jade").toFile(), "helper.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/main.jade").toFile(), "main.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/markdown.jade").toFile(), "markdown.jade")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/includes/footer.jade").toFile(), "includes/footer.jade")
            .addResource(Paths.get(WEB_INF_SRC).resolve("jade.properties").toFile())
            .addBeansXml()
            .addDependency("org.eclipse.krazo.ext:krazo-jade")
            .build();
    }

    @Test
    public void testUsesModel() {
        String path = baseURL + "jade?user=mvc%d";
        webDriver.navigate().to(String.format(path, 0));
        assertTrue(webDriver.getTitle().contains("Jade"));
        for (int i = 0; i < 10; i++) { // just to ensure that not the whole page is cached
            webDriver.navigate().to(String.format(path, i));
            WebElement h1 = webDriver.findElement(By.xpath("//html/body/h1"));
            assertTrue(h1.getText().contains("mvc" + i));
        }
    }

    @Test
    public void testIncludesViews() {
        webDriver.navigate().to(baseURL + "jade");
        WebElement footer = webDriver.findElement(By.xpath("//p[@class='footer']"));
        assertTrue(footer.getText().contains("Eclipse Krazo committers and contributors"));
    }

    @Test
    public void testUsesFilters() {
        webDriver.navigate().to(baseURL + "jade/markdown");
        final List<WebElement> elements = webDriver.findElements(By.xpath("//html/body/ul/li"));
        assertEquals(3, elements.size());
    }

    @Test
    public void testConfiguration() {
        webDriver.navigate().to(baseURL + "jade/config");
        WebElement systemProperties = webDriver.findElement(By.xpath("//p[@class='SystemProperties']"));
        assertEquals("SystemProperties", systemProperties.getText());
        WebElement configFile = webDriver.findElement(By.xpath("//p[@class='ConfigFile']"));
        assertEquals("ConfigFile", configFile.getText());
    }

    @Test
    public void testHelper() {
        webDriver.navigate().to(baseURL + "jade/helper");
        final WebElement element = webDriver.findElement(By.xpath("//p[@class='result']"));
        assertEquals("3", element.getText());
    }
}
