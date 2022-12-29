/*
 * Copyright (c) 2022 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.resteasy.core;

import jakarta.annotation.Priority;
import jakarta.interceptor.Interceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.krazo.core.HttpCommunicationUnwrapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Unwraps a Weld-generated proxy around the original {@code HttpServletRequest} instance.
 *
 * <p>The request object provided to Krazo by the RESTEasy implementation on
 * Liberty 22.0.0.13-beta and above is a Weld-generated proxy class. Liberty's internal handling
 * fails to recognise that as an instance of its own request class ({@code IExtendedRequest}).</p>
 *
 * @author Maarten Mulders
 * @since 3.0.2
 */
@Priority(Interceptor.Priority.PLATFORM_BEFORE + 2)
public class WeldHttpCommunicationUnwrapper implements HttpCommunicationUnwrapper {
    @Override
    public boolean supports(Object obj) {
        try {
            Class<?> weldClientProxyClass = Class.forName(
                "org.jboss.weld.proxy.WeldClientProxy", //$NON-NLS-1$
                false,
                obj.getClass().getClassLoader()
            );

            return weldClientProxyClass.isInstance(obj);
        } catch (ClassNotFoundException cnfe) {
            return false;
        }
    }

    @Override
    public HttpServletRequest unwrapRequest(HttpServletRequest obj, Class<HttpServletRequest> type) {
        try {
            //
            // Invoke WeldClientProxy#getMetadata()
            //
            Class<?> weldClientProxyClass = Class.forName(
                "org.jboss.weld.proxy.WeldClientProxy", //$NON-NLS-1$
                false,
                obj.getClass().getClassLoader()
            );
            Method getMetadataMethod = weldClientProxyClass.getDeclaredMethod("getMetadata"); //$NON-NLS-1$
            Object weldClientProxyMetadata = getMetadataMethod.invoke(obj);

            //
            // Invoke WeldClientProxy.Metadata#getContextualInstance()
            //
            Class<?> weldClientProxyMetadataClass = Class.forName(
                "org.jboss.weld.proxy.WeldClientProxy$Metadata", //$NON-NLS-1$
                false,
                obj.getClass().getClassLoader()
            );
            Method getContextualInstanceMethod = weldClientProxyMetadataClass.getDeclaredMethod("getContextualInstance"); //$NON-NLS-1$
            Object contextualInstance = getContextualInstanceMethod.invoke(weldClientProxyMetadata);

            return (HttpServletRequest) contextualInstance;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Encountered exception when unwrapping Weld request object", e);
        }
    }

    @Override
    public HttpServletResponse unwrapResponse(HttpServletResponse obj, Class<HttpServletResponse> type) {
        return null;
    }
}
