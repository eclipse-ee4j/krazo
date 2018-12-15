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
package org.eclipse.krazo.binding;

import javax.mvc.binding.BindingError;

/**
 * Implementation for {@link javax.mvc.binding.BindingError} interface.
 *
 * @author Santiago Pericas-Geertsen
 */
public class BindingErrorImpl implements BindingError {

    private String message;

    private String paramName;

    private String submittedValue;

    public BindingErrorImpl(String message, String paramName, String submittedValue) {
        this.message = message;
        this.paramName = paramName;
        this.submittedValue = submittedValue;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String getSubmittedValue() {
        return submittedValue;
    }
}
