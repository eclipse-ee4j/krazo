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
package org.eclipse.krazo.cdi;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class RedirectScopeManagerInjectionVerifyTest {

  @Rule
  public final ExpectedException expectedException = ExpectedException.none();

  @Test
  public void shouldFailInitializationIfContextInjectionFailed() {

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("@Context injection");

    RedirectScopeManager redirectScopeManager = new RedirectScopeManager();
    // nothing injected here, so all fields are null
    redirectScopeManager.init();

  }

  @Test
  public void shouldNotFailInitializationIfContextInjectionHappened() {

    RedirectScopeManager redirectScopeManager = new RedirectScopeManager();
    setFieldValue(redirectScopeManager, "config", createDummyInstance(Configuration.class));
    setFieldValue(redirectScopeManager, "response", createDummyInstance(HttpServletResponse.class));
    redirectScopeManager.init();

  }

  @SuppressWarnings("unchecked")
  private <T> T createDummyInstance(Class<T> type) {
    return (T) Proxy.newProxyInstance(
        Thread.currentThread().getContextClassLoader(),
        new Class[]{type},
        (o, method, objects) -> null
    );
  }

  private void setFieldValue(Object instance, String name, Object value) {

    try {

      Field field = instance.getClass().getDeclaredField(name);
      if (field == null) {
        throw new IllegalStateException("Cannot find field: " + name);
      }

      field.setAccessible(true);

      field.set(instance, value);

    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new IllegalStateException(e);
    }

  }

}
