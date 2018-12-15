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

import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.engine.ViewEngine;

/**
 * <p>An abstraction that encapsulates information about a view as well as an instance
 * of {@link javax.mvc.Models} and a {@link javax.mvc.engine.ViewEngine} class, in
 * which only the view information is mandatory.
 *
 * @author Santiago Pericas-Geertsen
 * @see javax.mvc.Models
 * @see Controller
 * @see javax.mvc.engine.ViewEngine
 * @since 1.0
 */
public class Viewable {

    private String view;

    private Models models;

    private Class<? extends ViewEngine> viewEngine;

    /**
     * Constructs an instance specifying only a view.
     *
     * @param view the view.
     */
    public Viewable(String view) {
        this(view, null, null);
    }

    /**
     * Constructs an instance using a view and a view engine.
     *
     * @param view the view.
     * @param viewEngine the view engine class.
     */
    public Viewable(String view, Class<? extends ViewEngine> viewEngine) {
        this(view, null, viewEngine);
    }

    /**
     * Constructs an instance using a view and a models instance.
     *
     * @param view the view.
     * @param models the models instance.
     */
    public Viewable(String view, Models models) {
        this(view, models, null);
    }

    /**
     * Constructs an instance using a view, a models and a view engine instances.
     *
     * @param view the view.
     * @param models the models instance.
     * @param viewEngine the view engine class.
     */
    public Viewable(String view, Models models, Class<? extends ViewEngine> viewEngine) {
        this.view = view;
        this.models = models;
        this.viewEngine = viewEngine;
    }

    /**
     * Get the view.
     *
     * @return the view.
     */
    public String getView() {
        return view;
    }

    /**
     * Set a new view.
     *
     * @param view the new view.
     */
    public void setView(String view) {
        this.view = view;
    }

    /**
     * Get the models instance.
     *
     * @return the models instance or {@code null}.
     */
    public Models getModels() {
        return models;
    }

    /**
     * Set the models instance.
     *
     * @param models the new models instance.
     */
    public void setModels(Models models) {
        this.models = models;
    }

    /**
     * Get the view engine instance.
     *
     * @return the view engine instance or {@code null}.
     */

    public Class<? extends ViewEngine> getViewEngine() {
        return viewEngine;
    }

    /**
     * Set the view engine instance.
     *
     * @param viewEngine the new view engine instance.
     */
    public void setViewEngine(Class<? extends ViewEngine> viewEngine) {
        this.viewEngine = viewEngine;
    }
}
