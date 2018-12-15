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

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * The JUnit tests for the ModelsImpl class.
 *
 * @author Manfred Riem (manfred.riem at oracle.com)
 */
@SuppressWarnings("unchecked")
public class ModelsImplTest {

    /**
     * Test get method.
     */
    @Test
    public void testGet() {
        ModelsImpl models = new ModelsImpl();
        assertNull(models.get("K"));
        models.put("K", "V");
        assertNotNull(models.get("K"));
        assertEquals("V", models.get("K"));
    }

    /**
     * Test iterator method.
     */
    @Test
    public void testIterator() {
        ModelsImpl models = new ModelsImpl();
        assertNotNull(models.iterator());
    }
}
