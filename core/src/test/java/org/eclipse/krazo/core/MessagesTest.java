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
package org.eclipse.krazo.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test for MessagesTest.
 *
 * @author Santiago Pericas-Geertsen
 * @author Manfred Riem (manfred.riem at oracle.com)
 */
public class MessagesTest {

    private Messages messages = new Messages();

    @Test
    public void testMessages() {
        assertTrue(messages.get("NoViewEngine", "MyView").contains("'MyView'"));
        assertTrue(messages.get("VoidControllerNoView", "foo()").contains("'foo()'"));
        assertTrue(messages.get("UnableValidateCsrf", "foo").contains("'foo'"));
        assertTrue(messages.get("CsrfFailed", "some reason").contains("some reason"));
    }

    /**
     * Test get method.
     */
    @Test
    public void testGet() {
        assertNull(messages.get("Blabla", Locale.US, new Object[] {}));
    }

    /**
     * Test get method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testGet2() throws Exception {
        HttpServletRequest request = EasyMock.createStrictMock(HttpServletRequest.class);
        Field field = messages.getClass().getDeclaredField("request");
        field.setAccessible(true);
        field.set(messages, request);
        ArrayList<Locale> locales = new ArrayList<>();
        locales.add(Locale.FRENCH);
        locales.add(Locale.ENGLISH);
        expect(request.getLocales()).andReturn(Collections.enumeration(locales));
        replay(request);
        assertEquals("Validation of CSRF failed due to {0}", messages.get("CsrfFailed", new Object[] {}));
        verify(request);
    }
}
