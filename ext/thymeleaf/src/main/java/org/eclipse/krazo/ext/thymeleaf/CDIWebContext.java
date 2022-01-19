/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, 2022 Eclipse Krazo committers and contributors
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
package org.eclipse.krazo.ext.thymeleaf;

import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.LazyContextVariable;
import org.thymeleaf.web.IWebExchange;

import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.util.AnnotationLiteral;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Thymeleaf context for resolving variables from the model or cdi context. In addition to the functions provided by
 * {@link org.thymeleaf.context.WebContext} this allows to resolve beans annotated with {@linkplain jakarta.inject.Named}
 * from the cdi context.
 * <p>
 * Beans will be resolved in this order:
 * <ol>
 * <li>special variables (like "request")</li>
 * <li>variables from the model</li>
 * <li>named beans from the cdi context</li>
 * </ol>
 * </p>
 *
 * @author Gregor Tudan
 */
class CDIWebContext implements IWebContext {

    private final IWebExchange exchange;
    private final Locale locale;

    private final BeanManager beanManager;
    private final Set<String> cdiNamedBeans;

    /** keeps track of creational contexts, so beans can get disposed by calling {@link #close()} */
    private final Queue<CreationalContext<?>> contexts = new LinkedList<>();

    private final Map<String, Object> variables = new HashMap<>();

    CDIWebContext(BeanManager beanManager, IWebExchange exchange, Locale locale) {
        this.beanManager = beanManager;
        this.exchange = exchange;
        this.locale = locale;
        this.cdiNamedBeans = enumerateNamedBeans();
    }

    @SuppressWarnings("serial")
    private Set<String> enumerateNamedBeans() {
        Set<Bean<?>> beans = beanManager.getBeans(Object.class, new AnnotationLiteral<Any>() {
        });
        return beans.stream().map(Bean::getName).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public boolean containsVariable(String name) {
        Objects.requireNonNull(name, "The variable name must not be null");
        if (variables.containsKey(name)) {
            return true;
        }
        return cdiNamedBeans.contains(name);
    }

    @Override
    public Set<String> getVariableNames() {
        final Set<String> variableNames = new HashSet<>(variables.keySet());
        variableNames.addAll(this.cdiNamedBeans);
        return variableNames;
    }

    @Override
    public Object getVariable(String name) {
        Objects.requireNonNull(name, "The variable name must not be null");
        if (variables.containsKey(name)) {
            return variables.get(name);
        } else if (cdiNamedBeans.contains(name)) {
            return getCdiBean(name);
        } else {
            return null;
        }
    }

    private Object getCdiBean(String name) {
        return new LazyContextVariable<Object>() {
            @Override
            protected Object loadValue() {
                jakarta.enterprise.inject.spi.Bean<?> bean = beanManager.getBeans(name).iterator().next();
                CreationalContext<?> ctx = beanManager.createCreationalContext(bean);
                // push the context a list so they can be disposed after the template has been processed
                contexts.add(ctx);
                return beanManager.getReference(bean, bean.getBeanClass(), ctx);
            }
        };
    }

    void setVariables(Map<String, Object> variables) {
        this.variables.clear();
        if (variables != null) {
            this.variables.putAll(variables);
        }
    }

    /**
     * Dispose all CDI creational contexts to depdenent scoped beans get disposed.
     * <p>
     * MUST be called after the template has been processed
     */
    void close() {
        for (CreationalContext<?> ctx : contexts) {
            ctx.release();
        }
    }

    @Override
    public IWebExchange getExchange() {
        return this.exchange;
    }
}
