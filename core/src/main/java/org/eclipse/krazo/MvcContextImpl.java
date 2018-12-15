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

import org.eclipse.krazo.jaxrs.JaxRsContext;
import org.eclipse.krazo.uri.ApplicationUris;
import org.eclipse.krazo.util.PathUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mvc.MvcContext;
import javax.mvc.security.Csrf;
import javax.mvc.security.Encoders;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Implementation of {@link javax.mvc.MvcContext}.
 *
 * @author Santiago Pericas-Geertsen
 */
@Named("mvc")
@RequestScoped
public class MvcContextImpl implements MvcContext {

    private static final Logger log = Logger.getLogger(MvcContextImpl.class.getName());

    @Inject
    private Csrf csrf;

    @Inject
    private Encoders encoders;

    @Inject
    private ServletContext servletContext;

    @Inject
    private ApplicationUris applicationUris;

    @Inject
    @JaxRsContext
    private Configuration configuration;

    @Inject
    @JaxRsContext
    private UriInfo uriInfo;

    private Locale locale;

    private String applicationPath;

    @PostConstruct
    public void init() {

        Objects.requireNonNull(configuration, "Cannot obtain JAX-RS Configuration instance");
        Objects.requireNonNull(uriInfo, "Cannot obtain JAX-RS UriInfo instance");
        Objects.requireNonNull(servletContext, "Cannot obtain ServletContext");

        applicationPath = PathUtils.normalizePath(
                uriInfo.getBaseUri().getPath().substring(servletContext.getContextPath().length())
        );

    }

    @Override
    public String getBasePath() {
        if (applicationPath != null) {
            return servletContext.getContextPath() + applicationPath;
        }
        return servletContext.getContextPath();
    }

    @Override
    public Csrf getCsrf() {
        return csrf;
    }

    @Override
    public Encoders getEncoders() {
        return encoders;
    }

    @Override
    public Configuration getConfig() {
        return configuration;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public URI uri(String identifier) {
        return applicationUris.get(identifier);
    }

    @Override
    public URI uri(String identifier, Map<String, Object> params) {
        return applicationUris.get(identifier, params);
    }

    @Override
    public UriBuilder uriBuilder(String identifier) {
        return applicationUris.getUriBuilder(identifier);
    }

}
