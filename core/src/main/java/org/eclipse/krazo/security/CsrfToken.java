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
package org.eclipse.krazo.security;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents a CSRF token.
 *
 * @author Christian Kaltepoth
 */
public class CsrfToken implements Serializable {

    private static final long serialVersionUID = -8566501367004693995L;

    private final String headerName;
    private final String paramName;
    private final String value;

    public CsrfToken(String headerName, String paramName, String value) {
        this.headerName = Objects.requireNonNull(headerName, "Header name must not be null");
        this.paramName = Objects.requireNonNull(paramName, "Parameter name must not be null");
        this.value = Objects.requireNonNull(value, "Value must not be null");
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getParamName() {
        return paramName;
    }

    public String getValue() {
        return value;
    }

}
