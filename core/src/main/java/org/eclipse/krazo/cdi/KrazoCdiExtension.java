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
package org.eclipse.krazo.cdi;

import org.eclipse.krazo.MvcContextImpl;
import org.eclipse.krazo.KrazoConfig;
import org.eclipse.krazo.binding.BeanValidationProducer;
import org.eclipse.krazo.binding.BindingResultManager;
import org.eclipse.krazo.binding.ConstraintViolationTranslator;
import org.eclipse.krazo.binding.convert.ConverterRegistry;
import org.eclipse.krazo.binding.convert.MvcConverterProvider;
import org.eclipse.krazo.cdi.types.AnnotatedTypeProcessor;
import org.eclipse.krazo.core.*;
import org.eclipse.krazo.engine.FaceletsViewEngine;
import org.eclipse.krazo.engine.JspViewEngine;
import org.eclipse.krazo.engine.ViewEngineFinder;
import org.eclipse.krazo.event.*;
import org.eclipse.krazo.jaxrs.JaxRsContextProducer;
import org.eclipse.krazo.locale.DefaultLocaleResolver;
import org.eclipse.krazo.locale.LocaleRequestFilter;
import org.eclipse.krazo.locale.LocaleResolverChain;
import org.eclipse.krazo.security.CsrfImpl;
import org.eclipse.krazo.security.CsrfProtectFilter;
import org.eclipse.krazo.security.CsrfTokenManager;
import org.eclipse.krazo.security.CsrfValidateInterceptor;
import org.eclipse.krazo.security.EncodersImpl;
import org.eclipse.krazo.uri.ApplicationUris;
import org.eclipse.krazo.uri.UriTemplateParser;
import org.eclipse.krazo.util.CdiUtils;
import org.eclipse.krazo.binding.validate.ValidationInterceptor;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.*;
import javax.interceptor.Interceptor;
import javax.mvc.Controller;
import javax.mvc.RedirectScoped;
import javax.mvc.event.MvcEvent;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class KrazoCdiExtension. Initialize redirect scope as CDI scope. Collect information
 * about all MVC events being observed by the application to optimize event creation
 * and firing.
 *
 * @author Santiago Pericas-Geertsen
 * @author Manfred Riem
 * @author Christian Kaltepoth
 */
@SuppressWarnings("unchecked")
public class KrazoCdiExtension implements Extension {

    private static final Logger log = Logger.getLogger(KrazoCdiExtension.class.getName());

    private static Set<Class<? extends MvcEvent>> observedEvents;

    private final AnnotatedTypeProcessor annotatedTypeProcessor = new AnnotatedTypeProcessor();

    /**
     * Before bean discovery.
     *
     * @param event the event.
     * @param beanManager the bean manager.
     */
    public void beforeBeanDiscovery(@Observes final BeforeBeanDiscovery event, BeanManager beanManager) {

        log.fine("Observed BeforeBeanDiscovery event, registering scopes and beans...");

        event.addScope(RedirectScoped.class, true, true);

        CdiUtils.addAnnotatedTypes(event, beanManager,

                // .
                MvcContextImpl.class,
                KrazoConfig.class,

                // binding
                BeanValidationProducer.class,
                BindingResultManager.class,
                ConstraintViolationTranslator.class,
                ConverterRegistry.class,
                MvcConverterProvider.class,

                // core
                Messages.class,
                ModelsImpl.class,
                ViewableWriter.class,
                ViewRequestFilter.class,
                ViewResponseFilter.class,

                // engine
                FaceletsViewEngine.class,
                JspViewEngine.class,
                ViewEngineFinder.class,

                // security
                CsrfImpl.class,
                CsrfProtectFilter.class,
                CsrfValidateInterceptor.class,
                CsrfTokenManager.class,
                EncodersImpl.class,

                // util
                CdiUtils.class,

                // cdi
                RedirectScopeManager.class,
                ValidationInterceptor.class,

                //event
                AfterControllerEventImpl.class,
                AfterProcessViewEventImpl.class,
                BeforeControllerEventImpl.class,
                BeforeProcessViewEventImpl.class,
                ControllerRedirectEventImpl.class,

                //locale
                LocaleRequestFilter.class,
                LocaleResolverChain.class,
                DefaultLocaleResolver.class,

                // jaxrs
                JaxRsContextProducer.class,

                // uri
                ApplicationUris.class,
                UriTemplateParser.class

        );
    }

    /**
     * After bean discovery.
     *
     * @param event the event.
     * @param beanManager the bean manager.
     */
    public void afterBeanDiscovery(@Observes final AfterBeanDiscovery event, BeanManager beanManager) {
        event.addContext(new RedirectScopeContext());
    }

    /**
     * Search for {@link Controller} annotation and patch AnnotatedType.
     * Note: PLATFORM_AFTER is required so we execute AFTER the Hibernate Validator Extension
     */
    public <T> void processAnnotatedType(
            @Observes @Priority(Interceptor.Priority.PLATFORM_AFTER) @WithAnnotations({Controller.class})
                    ProcessAnnotatedType<T> pat) {

        AnnotatedType<T> replacement = annotatedTypeProcessor.getReplacement(pat.getAnnotatedType());
        if (replacement != null) {
            log.log(Level.FINE, "Replacing AnnotatedType of class: {0}", replacement.getJavaClass().getName());
            pat.setAnnotatedType(replacement);
        }

    }

    /**
     * Gather set of event types that are observed by MVC application. This info is later
     * used to optimize event creation and firing.
     *
     * @param pom process observer method object.
     * @param beanManager the bean manager.
     * @param <T> the type of the event being observed.
     * @param <X> the bean type containing the observer method.
     */
    public <T, X> void processObserverMethod(@Observes ProcessObserverMethod<T, X> pom, BeanManager beanManager) {
        final Type type = pom.getObserverMethod().getObservedType();
        if (type instanceof Class<?>) {
            final Class<?> clazz = (Class<?>) type;
            if (MvcEvent.class.isAssignableFrom(clazz)) {
                addObservedEvent((Class<? extends MvcEvent>) type);
            }
        }
    }

    /**
     * Add MVC event type to set of observed events.
     *
     * @param eventType event type.
     */
    public static synchronized void addObservedEvent(Class<? extends MvcEvent> eventType) {
        if (observedEvents == null) {
            observedEvents = new HashSet<>();
        }
        observedEvents.add(eventType);
    }

    /**
     * Determine if an event type is being observed.
     *
     * @param eventType event type.
     * @return outcome of test.
     */
    public static synchronized boolean isEventObserved(Class<? extends MvcEvent> eventType) {
        return observedEvents == null ? false : observedEvents.contains(eventType);
    }
}
