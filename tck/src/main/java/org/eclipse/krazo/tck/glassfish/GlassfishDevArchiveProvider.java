/*
 * Copyright (c) 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.tck.glassfish;

import org.eclipse.krazo.tck.AbstractArchiveProvider;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * BaseArchiveProvider implementation for running TCK against Glassfish
 */
public class GlassfishDevArchiveProvider extends AbstractArchiveProvider {

    @Override
    public WebArchive getBaseArchive() {
        return ShrinkWrap.create(WebArchive.class)
                .addAsLibraries(resolveMvcSpecJar())
                .addAsLibraries(
                        ShrinkWrap.create(ExplodedImporter.class, "krazo-core.jar")
                                .importDirectory("../core/target/classes")
                                .as(JavaArchive.class)
                )
                .addAsLibraries(
                        ShrinkWrap.create(ExplodedImporter.class, "krazo-jersey.jar")
                                .importDirectory("../jersey/target/classes")
                                .as(JavaArchive.class)
                );
    }

}
