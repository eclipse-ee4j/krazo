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
package org.eclipse.krazo;

/**
 * Interface Properties. Application-level properties used to configure Krazo.
 *
 * @author Santiago Pericas-Geertsen
 */
public interface Properties {

    /**
     * Boolean property that when set to {@code true} indicates Krazo to
     * use cookies instead of the default URL re-write mechanism to implement
     * redirect scope.
     */
    String REDIRECT_SCOPE_COOKIES = "org.eclipse.krazo.redirectScopeCookies";

    /**
     * The implementation of {@link org.eclipse.krazo.security.CsrfTokenStrategy}
     * to use for storing tokens.
     */
    String CSRF_TOKEN_STRATEGY = "org.eclipse.krazo.csrfTokenStrategy";

    /**
     * Property for defining default file extension for usage in views
     */
    String DEFAULT_VIEW_FILE_EXTENSION = "org.eclipse.krazo.defaultViewFileExtension";

}
