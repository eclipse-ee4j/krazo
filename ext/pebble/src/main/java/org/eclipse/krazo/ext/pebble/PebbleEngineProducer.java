/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018-2021 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.ext.pebble;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.extension.Extension;
import com.mitchellbosecke.pebble.extension.escaper.EscapingStrategy;
import com.mitchellbosecke.pebble.loader.Servlet5Loader;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.krazo.engine.ViewEngineConfig;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

public class PebbleEngineProducer {

    protected Properties pebbleConfiguration;
    protected ServletContext servletContext;

    @Inject
    public PebbleEngineProducer(Properties pebbleConfiguration, ServletContext servletContext) {
        this.pebbleConfiguration = pebbleConfiguration;
        this.servletContext = servletContext;
    }

    protected PebbleEngineProducer(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    protected PebbleEngineProducer() {
    }

    @Produces
    @ViewEngineConfig
    public PebbleEngine pebbleEngine() {
        PebbleEngine.Builder engine = new PebbleEngine.Builder();

        pebbleConfiguration
            .entrySet()
            .stream()
            .filter(e -> String.valueOf(e.getValue()).trim().length() > 0)
            .forEach((e) -> {

                String val = String.valueOf(e.getValue());

                switch (PebbleProperty.fromKey(String.valueOf(e.getKey()))) {
                    case AUTO_ESCAPING:
                        engine.autoEscaping(Boolean.valueOf(val));
                        break;
                    case CACHE_ACTIVE:
                        engine.cacheActive(Boolean.valueOf(val));
                        break;
                    case ESCAPING_STRATEGY:
                        try {
                            String escapingStrategyKey = "userDefinedEscapingStrategy";
                            engine.addEscapingStrategy(escapingStrategyKey, (EscapingStrategy) Class.forName(val).getDeclaredConstructor().newInstance());
                            engine.defaultEscapingStrategy(escapingStrategyKey);
                        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
                            String msg = String.format("Pebble initialization error: Could not register escaping strategy '%s' of type %s", String.valueOf(e.getKey()), val);
                            throw new IllegalArgumentException(msg, ex);
                        }
                        break;
                    case DEFAULT_LOCALE:
                        engine.defaultLocale(Locale.forLanguageTag(val));
                        break;
                    case NEW_LINE_TRIMMING:
                        engine.newLineTrimming(Boolean.valueOf(val));
                        break;
                    case STRICT_VARIABLES:
                        engine.strictVariables(Boolean.valueOf(val));
                        break;
                    case EXECUTOR_SERVICE:
                        try {
                            engine.executorService((ExecutorService) Class.forName(val).getDeclaredConstructor().newInstance());
                        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
                            String msg = String.format("Pebble initialization error: Could not register executor service type %s", val);
                            throw new IllegalArgumentException(msg, ex);
                        }
                        break;
                    case EXTENSION:
                        String[] extensions = val.split(",");

                        Extension[] extensionArray = Stream.of(extensions)
                            .map(clazzName -> {
                                try {
                                    return (Extension) Class.forName(clazzName.trim()).getDeclaredConstructor().newInstance();
                                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
                                    String msg = String.format("Pebble initialization error: Could not register extension of type %s", clazzName);
                                    throw new IllegalArgumentException(msg, ex);
                                }
                            }).toArray(Extension[]::new);

                        engine.extension(extensionArray);
                        break;
                    default:
                        break;
                }
            });

        engine.loader(new Servlet5Loader(servletContext));

        return engine.build();
    }

}
