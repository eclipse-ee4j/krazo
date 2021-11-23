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
package org.eclipse.krazo.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The JUnit tests for the PathUtils class.
 *
 * @author Florian Hirsch
 */
public class PathUtilsTest {

    private static final String EMPTY_STRING = "";

	@Test
	public void noStartingSlash() {
        assertEquals("foo", PathUtils.noStartingSlash("foo"));
        assertEquals("foo", PathUtils.noStartingSlash("/foo"));
        assertEquals("foo/", PathUtils.noStartingSlash("/foo/"));
        assertEquals(EMPTY_STRING, PathUtils.noStartingSlash("/"));
        assertEquals(EMPTY_STRING, PathUtils.noStartingSlash(""));
	}

	@Test
	public void hasStartingSlash() {
		assertTrue(PathUtils.hasStartingSlash("/foo"));
		assertTrue(PathUtils.hasStartingSlash("/"));
		assertFalse(PathUtils.hasStartingSlash("foo"));
		assertFalse(PathUtils.hasStartingSlash(""));
	}

	@Test
	public void noPrefix() {
        assertEquals("foo", PathUtils.noPrefix("redirect:foo", "redirect:"));
        assertEquals("foo:bar", PathUtils.noPrefix("foo:bar", "bar"));
        assertEquals(EMPTY_STRING, PathUtils.noPrefix(EMPTY_STRING, EMPTY_STRING));
	}

	@Test
	public void ensureStartingSlash() {
		assertEquals("/foo", PathUtils.ensureStartingSlash("foo"));
		assertEquals("/foo", PathUtils.ensureStartingSlash("/foo"));
		assertEquals("/foo/", PathUtils.ensureStartingSlash("/foo/"));
		assertEquals("/", PathUtils.ensureStartingSlash("/"));
		assertEquals("/", PathUtils.ensureStartingSlash(""));
	}

	@Test
	public void ensureEndingSlash() {
		assertEquals("foo/", PathUtils.ensureEndingSlash("foo"));
		assertEquals("/foo/", PathUtils.ensureEndingSlash("/foo"));
		assertEquals("/foo/", PathUtils.ensureEndingSlash("/foo/"));
		assertEquals("/", PathUtils.ensureStartingSlash("/"));
		assertEquals("/", PathUtils.ensureStartingSlash(EMPTY_STRING));
	}

	@Test
	public void ensureNotEndingSlash() {
		assertEquals("foo", PathUtils.ensureNotEndingSlash("foo/"));
		assertEquals("/foo", PathUtils.ensureNotEndingSlash("/foo/"));
		assertEquals(EMPTY_STRING, PathUtils.ensureNotEndingSlash("/"));
		assertEquals(EMPTY_STRING, PathUtils.ensureNotEndingSlash(""));
	}

	@Test
	public void normalizePath() {
		assertEquals(EMPTY_STRING, PathUtils.normalizePath(EMPTY_STRING));
		assertEquals(EMPTY_STRING, PathUtils.normalizePath("/*"));
		assertEquals("/", PathUtils.ensureStartingSlash("/"));
		assertEquals("/foo/bar", PathUtils.normalizePath("/foo/bar/"));
		assertEquals("/foo/bar", PathUtils.normalizePath("foo/bar"));
	}

}
