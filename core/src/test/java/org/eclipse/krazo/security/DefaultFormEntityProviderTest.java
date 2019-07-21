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
package org.eclipse.krazo.security;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Gregor Tudan
 */
public class DefaultFormEntityProviderTest {

    private DefaultFormEntityProvider underTest;

    private ContainerRequestContext context;

    @Before
    public void setUp() {
        context = EasyMock.createMock(ContainerRequestContext.class);
        underTest = new DefaultFormEntityProvider();
    }

    @After
    public void tearDown() {
        EasyMock.verify(context);
    }

    @Test
    public void testReadingForm() throws IOException {
        EasyMock.expect(context.getEntityStream()).andReturn(new ByteArrayInputStream("foo=bar".getBytes()));
        EasyMock.expect(context.getMediaType()).andReturn(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        context.setEntityStream(EasyMock.anyObject(InputStream.class));

        EasyMock.replay(context);

        Form form = underTest.getForm(context);
        assertEquals("bar", form.asMap().getFirst("foo"));
    }

    @Test
    public void testMultipleParamValues() throws IOException {
        EasyMock.expect(context.getEntityStream()).andReturn(new ByteArrayInputStream("foo=bar&foo=baz".getBytes()));
        EasyMock.expect(context.getMediaType()).andReturn(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        context.setEntityStream(EasyMock.anyObject(InputStream.class));

        EasyMock.replay(context);

        Form form = underTest.getForm(context);
        assertEquals("bar", form.asMap().get("foo").get(0));
        assertEquals("baz", form.asMap().get("foo").get(1));
    }

    @Test
    public void testEmptyValue() throws IOException {
        EasyMock.expect(context.getEntityStream()).andReturn(new ByteArrayInputStream("foo=".getBytes()));
        EasyMock.expect(context.getMediaType()).andReturn(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        context.setEntityStream(EasyMock.anyObject(InputStream.class));

        EasyMock.replay(context);

        Form form = underTest.getForm(context);
        assertEquals("", form.asMap().get("foo").get(0));
    }

    @Test
    public void testURLEncodedValues() throws IOException {
        EasyMock.expect(context.getEntityStream()).andReturn(new ByteArrayInputStream("foo=bar%3Dbaz".getBytes()));
        EasyMock.expect(context.getMediaType()).andReturn(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        context.setEntityStream(EasyMock.anyObject(InputStream.class));

        EasyMock.replay(context);

        Form form = underTest.getForm(context);
        assertEquals("bar=baz", form.asMap().get("foo").get(0));
    }

    @Test
    public void testReadingAnEmptyResponse() throws IOException {
        EasyMock.expect(context.getEntityStream()).andReturn(new ByteArrayInputStream(new byte[0]));
        EasyMock.expect(context.getMediaType()).andReturn(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        context.setEntityStream(EasyMock.anyObject(InputStream.class));

        EasyMock.replay(context);

        Form form = underTest.getForm(context);
        assertEquals(0, form.asMap().size());
    }

    @Test
    public void testReadingGarbage() throws IOException {
        byte[] bytes = "sj238snssKJSHUFDH8u290+!9@*32".getBytes();

        EasyMock.expect(context.getEntityStream()).andReturn(new ByteArrayInputStream(bytes));
        EasyMock.expect(context.getMediaType()).andReturn(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        context.setEntityStream(EasyMock.anyObject(InputStream.class));

        EasyMock.replay(context);

        Form form = underTest.getForm(context);
        assertEquals(0, form.asMap().size());
    }

    @Test
    public void testWithNonBufferedStream() throws IOException {
        // A file input stream does not support reset
        // So let's write some content to a temp file and feed it to the form provider
        File temp = File.createTempFile("tempfile", ".tmp");
        try (FileWriter fileWriter = new FileWriter(temp)) {
            fileWriter.write("foo=bar");
        }

        EasyMock.expect(context.getEntityStream()).andReturn(new FileInputStream(temp));
        EasyMock.expect(context.getMediaType()).andReturn(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        context.setEntityStream(EasyMock.anyObject(InputStream.class));

        EasyMock.replay(context);

        Form form = underTest.getForm(context);
        assertEquals("bar", form.asMap().get("foo").get(0));
    }
}
