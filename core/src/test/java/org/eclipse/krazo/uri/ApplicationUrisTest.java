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
package org.eclipse.krazo.uri;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * <p>The test for {@link ApplicationUris}.</p>
 *
 * @author Florian Hirsch
 */
public class ApplicationUrisTest {

    private ApplicationUris uris;

    private static final String PATH = "/foo";

    private static final UriTemplate TEMPLATE = UriTemplate.fromTemplate(PATH).build();

    @Before
    public void onBefore() {
        uris = new ApplicationUris();
    }

    @Test
    public void shouldBuildWithMapParams() throws NoSuchMethodException {
        uris.register(UriTemplate.fromTemplate("/a/{b}/{c}").queryParam("q").matrixParam("m").build(),
            UriBuilderTestControllers.SomeController.class.getMethod("root"));
        Map<String, Object> params = new HashMap<>();
        params.put("b", "d");
        params.put("c", "e");
        params.put("m", 1);
        params.put("q", 2);
        assertEquals("/a/d/e;m=1?q=2", uris.get("SomeController#root", params).toString());
    }

    @Test
    public void shouldRegisterByNameAndRef() throws NoSuchMethodException {
        uris.register(TEMPLATE, UriBuilderTestControllers.UriRefController.class.getMethod("getRoot"));
        assertEquals(PATH, uris.get("uri-ref").toString());
        assertEquals(PATH, uris.get("UriRefController#getRoot").toString());
        assertEquals(2, uris.list().size());
    }

    @Test
    public void shouldAllowSameIdentifierForSamePath() throws NoSuchMethodException {
        uris.register(TEMPLATE, UriBuilderTestControllers.UriRefController.class.getMethod("getRoot"));
        uris.register(TEMPLATE, UriBuilderTestControllers.UriRefController.class.getMethod("postRoot"));
        uris.get("uri-ref");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailForAmbiguousRefs() throws NoSuchMethodException {
        uris.register(TEMPLATE, UriBuilderTestControllers.UriRefController.class.getMethod("getRoot"));
        uris.register(UriTemplate.fromTemplate("/bar").build(),
            UriBuilderTestControllers.AmbiguousController.class.getMethod("getAmbiguousRoot"));
        uris.get("uri-ref");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoulFailIfNoTemplateFound() throws NoSuchMethodException {
        uris.register(TEMPLATE, UriBuilderTestControllers.SomeController.class.getMethod("root"));
        uris.get("not#found");
    }

}
