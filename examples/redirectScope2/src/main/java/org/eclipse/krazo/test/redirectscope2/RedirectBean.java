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
package org.eclipse.krazo.test.redirectscope2;

import java.io.Serializable;
import javax.inject.Named;
import javax.mvc.RedirectScoped;

/**
 * A simple RedirectScoped bean.
 *
 * @author Manfred Riem (manfred.riem at oracle.com)
 */
@Named("redirectBean")
@RedirectScoped
public class RedirectBean implements Serializable {

    private static final long serialVersionUID = 3829085257656402865L;

    /**
     * Stores the value.
     */
    private String value = "Initial value";

    /**
     * Get the value.
     *
     * @return the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
