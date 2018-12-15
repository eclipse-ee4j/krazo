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
package org.eclipse.krazo.ext.jade;

import de.neuland.jade4j.Jade4J.Mode;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.filter.Filter;
import org.eclipse.krazo.engine.ViewEngineConfig;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

/**
 * The JadeKrazoConfiguration. The configuration properties are qualified by
 * <code>org.eclipse.krazo.ext.jade</code>. Following precedence is used:
 * <ol>
 * <li>System Properties</li>
 * <li>Properties defined in a file named jade.properties in the classpath.</li>
 * <li>Defaults</li>
 * </ol>
 *
 * @author Florian Hirsch
 */
public class JadeKrazoConfiguration {

    /**
     * One of HTML, XML, XHTML. Default: XHTML
     */
    public static final String MODE = "org.eclipse.krazo.ext.jade.mode";

    /**
     * Parsed templates will be cached unless this property is set to false.
     */
    public static final String CACHING = "org.eclipse.krazo.ext.jade.caching";

    /**
     * Jade will produce compressed HTML unless this property is set to true.
     */
    public static final String PRETTY_PRINT = "org.eclipse.krazo.ext.jade.prettyPrint";

    /**
     * Qualifier for a {@link Filter} which shall be used by the Jade Engine.
     * The key part after the qualifier will be used as name for the filter. The
     * value should be a fully qualified class name of the filter. Example:      <code>
	 * org.eclipse.krazo.ext.jade.filter.shiny=com.foo.bar.ShinyFilter
     * </code> Jade4J by default registers following filters: cdata, css, js
     */
    public static final String FILTER_QUALIFIER = "org.eclipse.krazo.ext.jade.filter";

    /**
     * Qualifier for a Helper. The key part after the qualifier will be used as
     * name for the helper. The value should be a fully qualified class name of
     * the filter.      <code>
	 * org.eclipse.krazo.ext.jade.helper.math=com.foo.bar.MathHelper
     * </code>
     */
    public static final String HELPER_QUALIFIER = "org.eclipse.krazo.ext.jade.helper";

    /**
     * The encoding used for the templates. Defaults to UTF-8.
     */
    public static final String ENCODING = "org.eclipse.krazo.ext.jade.encoding";

    private Properties configFile;

    @Inject
    private ServletContext servletContext;

    @Produces
    @ViewEngineConfig
    JadeConfiguration produce() {
        loadConfig();
        JadeConfiguration jade = new JadeConfiguration();
        jade.setMode(Mode.valueOf(property(MODE).orElse("XHTML")));
        jade.setCaching(Boolean.valueOf(property(CACHING).orElse("true")));
        jade.setPrettyPrint(Boolean.valueOf(property(PRETTY_PRINT).orElse("false")));
        getExtensions(FILTER_QUALIFIER).entrySet().forEach(filter -> {
            jade.setFilter(filter.getKey(), (Filter) filter.getValue());
        });
        jade.setSharedVariables(getExtensions(HELPER_QUALIFIER));
        String encoding = property(ENCODING).orElse("UTF-8");
        jade.setTemplateLoader(new ServletContextTemplateLoader(servletContext, encoding));
        return jade;
    }

    private void loadConfig() {
        configFile = new Properties();
        InputStream config = Thread.currentThread().getContextClassLoader().getResourceAsStream("jade.properties");
        if (config != null) {
            try {
                configFile.load(config);
            } catch (IOException ignored) {
                // ignored
            }
        }
    }

    private Optional<String> property(String key) {
        String property = System.getProperty(key, configFile.getProperty(key));
        return Optional.ofNullable(property);
    }

    private Map<String, Object> getExtensions(String qualifier) {
        Map<String, String> properties = new HashMap<>();
        properties.putAll(filterProps(configFile, qualifier));
        properties.putAll(filterProps(System.getProperties(), qualifier));
        Map<String, Object> extensions = new HashMap<>();
        properties.forEach((key, value) -> {
            try {
                Class<?> filter = Class.forName(value);
                extensions.put(key, filter.newInstance());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
                String msg = String.format("Jade initialization error: Could not register extension '%s' of type %s", key, value);
                throw new IllegalArgumentException(msg, ex);
            }
        });
        return extensions;
    }

    private Map<String, String> filterProps(Properties props, String qualifier) {
        Map<String, String> filters = new HashMap<>();
        props.entrySet().stream()
                .filter(prop -> prop.getKey().toString().startsWith(qualifier))
                .forEach(prop -> {
                    String key = prop.getKey().toString();
                    filters.put(key.substring(key.indexOf(qualifier) + qualifier.length() + 1), prop.getValue().toString());
                });
        return filters;
    }

    void dispose(@Disposes @ViewEngineConfig JadeConfiguration jade) {
        jade.clearCache();
    }
}
