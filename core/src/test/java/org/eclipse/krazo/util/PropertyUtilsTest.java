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

import javax.ws.rs.core.Configuration;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * The JUnit tests for the PropertyUtils class.
 *
 * @author Florian Hirsch
 */
public class PropertyUtilsTest {

	@Test
	public void getProperty() {
		Configuration config = EasyMock.createStrictMock(Configuration.class);
		expect(config.getProperty(eq("host"))).andReturn("java.net");
		expect(config.getProperty(eq("port"))).andReturn(null);
		replay(config);
		assertThat(PropertyUtils.getProperty(config, "host", "oracle.com"), is("java.net"));
		assertThat(PropertyUtils.getProperty(config, "port", 8080), is(8080));
		verify(config);
	}

}
