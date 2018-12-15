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
package org.eclipse.krazo.uri;

import org.junit.Before;
import org.junit.Test;

import javax.mvc.MvcContext;

import java.util.Arrays;
import java.util.HashSet;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * <p>The test for {@link UriTemplateParser}.</p>
 *
 * @author Florian Hirsch
 */
public class UriTemplateParserTest {

    private static final String BASE_PATH = "/base-path";

    private UriTemplateParser uriTemplateParser;

    @Before
    public void onBefore() {
        uriTemplateParser = new UriTemplateParser();
        MvcContext mvcContext = createMock(MvcContext.class);
        expect(mvcContext.getBasePath()).andReturn(BASE_PATH).anyTimes();
        replay(mvcContext);
        uriTemplateParser.mvcContext = mvcContext;
    }

    @Test
    public void shouldInitApplicationUris() {
        HashSet<Class<?>> controllers = new HashSet<>(Arrays.asList(UriBuilderTestControllers.SomeController.class, UriBuilderTestControllers.ParamsController.class));
        ApplicationUris uris = uriTemplateParser.init(controllers);
        assertThat(uris.list().size(), is(7));
    }

    @Test
    public void shouldParseMethods() throws NoSuchMethodException {
        assertThat(uriTemplateParser.parseMethod(UriBuilderTestControllers.SomeController.class.getMethod("root"), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/some").build()));
        assertThat(uriTemplateParser.parseMethod(UriBuilderTestControllers.SomeController.class.getMethod("path"), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/some/path").build()));
    }

    @Test
    public void shouldParseFromInheritedMethods() throws NoSuchMethodException {
        assertThat(uriTemplateParser.parseMethod(UriBuilderTestControllers.SomeController.class.getMethod("parent"), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/some/parent").build()));
        assertThat(uriTemplateParser.parseMethod(UriBuilderTestControllers.ControllerImplementation.class.getMethod("show"), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/implementation/show").build()));
    }

    @Test
    public void shouldParseMethodParams() throws NoSuchMethodException {
        assertThat(uriTemplateParser.parseMethod(
            UriBuilderTestControllers.ParamsController.class.getMethod("pathParams", String.class, long.class), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/params/path/{p1}/{p2}").build()));
        assertThat(uriTemplateParser.parseMethod(
            UriBuilderTestControllers.ParamsController.class.getMethod("queryParams", String.class, long.class), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/params/query").queryParam("q1").queryParam("q2").build()));
        assertThat(uriTemplateParser.parseMethod(
            UriBuilderTestControllers.ParamsController.class.getMethod("matrixParams", String.class, long.class), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/params/matrix").matrixParam("m1").matrixParam("m2").build()));
    }

    @Test
    public void shouldParseFields() throws NoSuchMethodException {
        assertThat(uriTemplateParser.parseMethod(UriBuilderTestControllers.FieldsController.class.getMethod("root"), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/fields/{p1}/{p2}/{p3}") //
                .matrixParam("m1").matrixParam("m2").matrixParam("m3") //
                .queryParam("q1").queryParam("q2").queryParam("q3").build())); //
    }

    @Test
    public void shouldParseBeanParams() throws NoSuchMethodException {
        assertThat(uriTemplateParser.parseMethod(
            UriBuilderTestControllers.BeanParamController.class.getMethod("bean", UriBuilderTestControllers.BeanParams.class), BASE_PATH),
            equalTo(UriTemplate.fromTemplate("/base-path/bean/{p}").matrixParam("m").queryParam("q").build()));
    }

}
