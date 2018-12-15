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

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * The JUnit tests for the PathUtils class.
 *
 * @author Florian Hirsch
 */
public class PathUtilsTest {

	@Test
	public void noStartingSlash() {
		assertThat(PathUtils.noStartingSlash("foo"), is("foo"));
		assertThat(PathUtils.noStartingSlash("/foo"), is("foo"));
		assertThat(PathUtils.noStartingSlash("/foo/"), is("foo/"));
		assertThat(PathUtils.noStartingSlash("/"), is(""));
		assertThat(PathUtils.noStartingSlash(""), is(""));
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
		assertThat(PathUtils.noPrefix("redirect:foo", "redirect:"), is("foo"));
		assertThat(PathUtils.noPrefix("foo:bar", "bar"), is("foo:bar"));
		assertThat(PathUtils.noPrefix("", ""), is(""));
	}

	@Test
	public void ensureStartingSlash() {
		assertThat(PathUtils.ensureStartingSlash("foo"), is("/foo"));
		assertThat(PathUtils.ensureStartingSlash("/foo"), is("/foo"));
		assertThat(PathUtils.ensureStartingSlash("/foo/"), is("/foo/"));
		assertThat(PathUtils.ensureStartingSlash("/"), is("/"));
		assertThat(PathUtils.ensureStartingSlash(""), is("/"));
	}

	@Test
	public void ensureEndingSlash() {
		assertThat(PathUtils.ensureEndingSlash("foo"), is("foo/"));
		assertThat(PathUtils.ensureEndingSlash("/foo"), is("/foo/"));
		assertThat(PathUtils.ensureEndingSlash("/foo/"), is("/foo/"));
		assertThat(PathUtils.ensureStartingSlash("/"), is("/"));
		assertThat(PathUtils.ensureStartingSlash(""), is("/"));
	}

	@Test
	public void ensureNotEndingSlash() {
		assertThat(PathUtils.ensureNotEndingSlash("foo/"), is("foo"));
		assertThat(PathUtils.ensureNotEndingSlash("/foo/"), is("/foo"));
		assertThat(PathUtils.ensureNotEndingSlash("/"), is(""));
		assertThat(PathUtils.ensureNotEndingSlash(""), is(""));
	}

	@Test
	public void normalizePath() {
		assertThat(PathUtils.normalizePath(""), is(""));
		assertThat(PathUtils.normalizePath("/*"), is(""));
		assertThat(PathUtils.ensureStartingSlash("/"), is("/"));
		assertThat(PathUtils.normalizePath("/foo/bar/"), is("/foo/bar"));
		assertThat(PathUtils.normalizePath("foo/bar"), is("/foo/bar"));
	}

}
