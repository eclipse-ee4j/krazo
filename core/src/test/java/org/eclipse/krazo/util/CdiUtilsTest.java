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
package org.eclipse.krazo.util;

import org.easymock.EasyMock;
import org.junit.Test;

import javax.enterprise.inject.spi.BeanManager;
import java.lang.reflect.Field;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNull;

/**
 * The JUnit tests for the CdiUtils class.
 *
 * @author Manfred Riem (manfred.riem at oracle.com)
 */
public class CdiUtilsTest {

    /**
     * Test newBean method.
     *
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testNewBean() throws Exception {
        CdiUtils utils = new CdiUtils();

        Field bmField = utils.getClass().getDeclaredField("beanManager");
        bmField.setAccessible(true);
        BeanManager bm = EasyMock.createMock(BeanManager.class);
        bmField.set(utils, bm);

        expect(bm.getBeans(CdiUtilsTest.class)).andReturn(null);
        expect(bm.resolve(null)).andReturn(null);
        expect(bm.createCreationalContext(null)).andReturn(null);
        expect(bm.getReference(null, CdiUtilsTest.class, null)).andReturn(null);
        replay(bm);
        assertNull(utils.newBean(CdiUtilsTest.class));
        verify(bm);
    }

}
