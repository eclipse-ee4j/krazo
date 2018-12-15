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
package org.eclipse.krazo.core;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class Messages.
 *
 * @author Santiago Pericas-Geertsen
 */
@ApplicationScoped
public class Messages {

    private static final String BASENAME = "krazo";

    @Inject
    private HttpServletRequest request;

    /**
     * Get a message given its key and using the locales in the current request 'Accept-Language'
     * header. If no bundle or key found, try using the {@link java.util.Locale#ENGLISH} locale in
     * an attempt to produce some message.
     *
     * @param key The key to search.
     * @param params Message parameters.
     * @return Message or {@code null} if bundle or key not found for any locale.
     */
    public String get(String key, Object... params) {
        if (request != null) {
            final Enumeration<Locale> locales = request.getLocales();
            while (locales.hasMoreElements()) {
                final String message = get(key, locales.nextElement(), params);
                if (message != null) {
                    return message;
                }
            }
        }
        // English message better than no message
        return get(key, Locale.ENGLISH, params);
    }

    /**
     * Get a message given its key and a locale.
     *
     * @param key The key to search.
     * @param locale The locale.
     * @param params Message parameters.
     * @return Formatted message or {@code null} if bundle or key not found.
     */
    public String get(String key, Locale locale, Object... params) {
        try {
            final ResourceBundle rb = ResourceBundle.getBundle(BASENAME, locale);
            final String pattern = rb.getString(key);
            return MessageFormat.format(pattern, params);
        } catch (MissingResourceException e) {
            return null;
        }
    }
}
