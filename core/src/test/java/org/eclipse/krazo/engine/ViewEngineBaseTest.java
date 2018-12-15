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
package org.eclipse.krazo.engine;

import org.easymock.EasyMock;
import org.junit.Test;

import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.ws.rs.core.Configuration;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * The JUnit test for the ViewEngineBase class.
 *
 * @author Florian Hirsch
 */
public class ViewEngineBaseTest {

	private final ViewEngineBase viewEngineBase = new ViewEngineBase() {
		@Override
		public boolean supports(String view) {
			return false;
		}
		@Override
		public void processView(ViewEngineContext context) throws ViewEngineException {

		}
	};

	@Test
	public void resolveView() {
		ViewEngineContext ctx = EasyMock.createMock(ViewEngineContext.class);
		Configuration config = EasyMock.createMock(Configuration.class);
		expect(config.getProperty(eq(ViewEngine.VIEW_FOLDER))).andReturn(null);
		expect(ctx.getConfiguration()).andReturn(config);
		expect(ctx.getView()).andReturn("index.jsp");
		expect(ctx.getView()).andReturn("/somewhere/else/index.jsp");
		replay(ctx, config);
		assertThat(viewEngineBase.resolveView(ctx), is("/WEB-INF/views/index.jsp"));
		assertThat(viewEngineBase.resolveView(ctx), is("/somewhere/else/index.jsp"));
		verify(ctx, config);
	}

	@Test
	public void resolveViewCustomFolder() {
		ViewEngineContext ctx = EasyMock.createMock(ViewEngineContext.class);
		Configuration config = EasyMock.createMock(Configuration.class);
		expect(config.getProperty(eq(ViewEngine.VIEW_FOLDER))).andReturn("/somewhere/else");
		expect(ctx.getConfiguration()).andReturn(config);
		expect(ctx.getView()).andReturn("index.jsp");
		replay(ctx, config);
		assertThat(viewEngineBase.resolveView(ctx), is("/somewhere/else/index.jsp"));
		verify(ctx, config);
	}

}
