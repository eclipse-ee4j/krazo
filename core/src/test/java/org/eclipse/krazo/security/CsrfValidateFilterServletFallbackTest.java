/*
 * Copyright (c) 2026 Eclipse Krazo committers and contributors
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

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;

import jakarta.mvc.Controller;
import jakarta.mvc.security.Csrf;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.MultivaluedHashMap;

import org.easymock.EasyMock;
import org.eclipse.krazo.KrazoConfig;
import org.eclipse.krazo.core.Messages;
import org.junit.Test;

public class CsrfValidateFilterServletFallbackTest {

    @Test
    public void shouldAcceptTokenFromServletRequestParameter() throws Exception {
        CsrfValidateFilter filter = new CsrfValidateFilter();

        ContainerRequestContext context = EasyMock.createStrictMock(ContainerRequestContext.class);
        ResourceInfo resourceInfo = EasyMock.createStrictMock(ResourceInfo.class);
        CsrfTokenManager tokenManager = EasyMock.createStrictMock(CsrfTokenManager.class);
        KrazoConfig config = EasyMock.createStrictMock(KrazoConfig.class);
        HttpServletRequest request = EasyMock.createStrictMock(HttpServletRequest.class);

        expect(resourceInfo.getResourceMethod()).andReturn(TestController.class.getDeclaredMethod("submit"));
        expect(config.getCsrfOptions()).andReturn(Csrf.CsrfOptions.IMPLICIT);
        expect(tokenManager.getToken()).andReturn(Optional.of(new CsrfToken("X-CSRF-TOKEN", "_csrf", "token-123")));
        expect(context.getHeaders()).andReturn(new MultivaluedHashMap<>());
        expect(request.getParameter("_csrf")).andReturn("token-123");

        setField(filter, "resourceInfo", resourceInfo);
        setField(filter, "csrfTokenManager", tokenManager);
        setField(filter, "krazoConfig", config);
        setField(filter, "messages", EasyMock.createNiceMock(Messages.class));
        setField(filter, "request", request);

        replay(context, resourceInfo, tokenManager, config, request);
        filter.filter(context);
        verify(context, resourceInfo, tokenManager, config, request);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Controller
    private static class TestController {
        @POST
        public void submit() {
        }
    }
}
