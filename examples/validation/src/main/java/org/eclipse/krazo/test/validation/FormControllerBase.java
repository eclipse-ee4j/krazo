/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, 2019 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.test.validation;

import jakarta.inject.Inject;
import jakarta.mvc.binding.BindingResult;

/**
 * Class FormControllerBase. Base class for controllers that inherit a BindingResult
 * property.
 *
 * @author Santiago Pericas-Geertsen
 */
public class FormControllerBase {

    private BindingResult br;

    public BindingResult getVr() {
        return br;
    }

    @Inject
    public void setVr(BindingResult br) {
        this.br = br;
    }
}
