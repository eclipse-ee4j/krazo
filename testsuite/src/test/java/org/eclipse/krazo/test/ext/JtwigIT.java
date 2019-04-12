/*
 * Copyright © 2017, 2019 Ivar Grimstad
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

import java.net.URL;
import java.nio.file.Paths;

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


/**
 * Unit test for simple App.
 */
@RunWith(Arquillian.class)
public class JtwigIT {

    private static final String WEB_INF_SRC = "src/main/resources/jtwig/";

    @ArquillianResource
    private URL baseURL;

    @Drone
    private WebDriver webDriver;

    @Deployment(testable = false, name = "jtwig")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.ext.jtwig")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/hello.twig.html").toFile(), "hello.twig.html")
            .addBeansXml()
            .addDependency("org.eclipse.krazo.ext:krazo-jtwig")
            .build();
    }

    @Test
    public void testView1() throws Exception {
        webDriver.navigate().to(baseURL + "resources/hello?user=mvc");
        final String h1 = webDriver.findElement(By.tagName("h1")).getText();
        assertEquals("Hello mvc", h1.trim());
    }
}
