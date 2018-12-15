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
import javax.ws.rs.FormParam;

/**
 * Example MVC extension of BaseUser. The scenario is we have been provided the
 * User class in some external library, and we're creating an MVC friendly
 * model from that base object.
 */
public class MvcUser extends BaseUser {

    @MvcBinding
    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @FormParam("firstName")
    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @MvcBinding
    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @FormParam("lastName")
    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }
}
