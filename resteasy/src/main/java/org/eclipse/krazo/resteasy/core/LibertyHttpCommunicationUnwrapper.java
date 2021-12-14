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
package org.eclipse.krazo.resteasy.core;

import java.lang.reflect.Method;

import org.eclipse.krazo.core.HttpCommunicationUnwrapper;

import jakarta.annotation.Priority;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Looks up the {@code IExtendedRequest} instance when running on Open Liberty.
 * 
 * <p>The request proxy object provided to Krazo by the RESTEasy implementation on
 * Liberty 21.0.0.12-beta and above does not extend {@code IExtendedRequest}, but
 * Liberty's internal handling requires that the root request passed to a
 * {@code RequestDispatcher} does.</p>
 * 
 * @author Jesse Gallagher
 * @since 3.0.0
 */
@Priority(1)
public class LibertyHttpCommunicationUnwrapper implements HttpCommunicationUnwrapper {

  @Override
  public boolean supports(Object obj) {
    if (obj instanceof HttpServletRequest) {
      try {
        Class.forName("com.ibm.wsspi.webcontainer.WebContainerRequestState", false, obj.getClass().getClassLoader()); //$NON-NLS-1$
        return true;
      } catch (ClassNotFoundException e) {
        return false;
      }
    }
    return false;
  }

  @Override
  public HttpServletRequest unwrapRequest(HttpServletRequest obj, Class<HttpServletRequest> type) {
    try {
      Class<?> requestStateClass = Class.forName("com.ibm.wsspi.webcontainer.WebContainerRequestState", false, obj.getClass().getClassLoader()); //$NON-NLS-1$
      Method getInstance = requestStateClass.getDeclaredMethod("getInstance", boolean.class); //$NON-NLS-1$
      Object requestState = getInstance.invoke(null, false);
      Method getCurrentThreadsIExtendedRequest = requestStateClass.getDeclaredMethod("getCurrentThreadsIExtendedRequest"); //$NON-NLS-1$
      return (HttpServletRequest)getCurrentThreadsIExtendedRequest.invoke(requestState);
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public HttpServletResponse unwrapResponse(HttpServletResponse obj, Class<HttpServletResponse> type) {
    return obj;
  }

}
