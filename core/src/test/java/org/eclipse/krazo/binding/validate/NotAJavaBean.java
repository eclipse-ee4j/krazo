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
package org.eclipse.krazo.binding.validate;

import javax.mvc.binding.MvcBinding;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/**
 * A java class that is not a valid java bean.
 */
public class NotAJavaBean {

    @FormParam("name")
    @NotNull
    @Size(max = 10)
    private String name;

    public NotAJavaBean(String name) {
        this.name = name;
    }

    // invalid getter name per java beans spec
    @MvcBinding
    public String name() {
        return name;
    }
}
