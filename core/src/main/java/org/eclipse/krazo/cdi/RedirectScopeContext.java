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

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.AlterableContext;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.CDI;
import javax.mvc.RedirectScoped;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * The CDI context for RedirectScoped beans.
 *
 * @author Manfred Riem (manfred.riem at oracle.com)
 */
public class RedirectScopeContext implements AlterableContext, Serializable {

    /**
     * Stores the serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Stores the manager.
     */
    private transient RedirectScopeManager manager;

    /**
     * Destroy the given contextual.
     *
     * @param contextual the contextual.
     */
    @Override
    public void destroy(Contextual<?> contextual) {
        getManager().destroy(contextual);
    }

    /**
     * Get the instance of a RedirectScoped bean.
     *
     * @param <T> the type.
     * @param contextual the contextual.
     * @return the view scoped bean, or null if not found.
     */
    @Override
    public <T> T get(Contextual<T> contextual) {
        return getManager().get(contextual);
    }

    /**
     * Get the instance of a RedirectScoped bean.
     *
     * @param <T> the type.
     * @param contextual the contextual.
     * @param creational the creational.
     * @return the instance.
     * @throws ContextNotActiveException when the context is not active.
     */
    @Override
    public <T> T get(Contextual<T> contextual, CreationalContext<T> creational) {
        return getManager().get(contextual, creational);
    }

    /**
     * Get the manager.
     *
     * @return the manager.
     */
    public RedirectScopeManager getManager() {
        if (manager == null) {
            manager = CDI.current().select(RedirectScopeManager.class).get();
        }
        return manager;
    }

    /**
     * Get the class of the scope object.
     *
     * @return the class.
     */
    @Override
    public Class<? extends Annotation> getScope() {
        return RedirectScoped.class;
    }

    /**
     * Is the scope active.
     *
     * @return true if it is, false otherwise.
     */
    @Override
    public boolean isActive() {
        return true;
    }
}
