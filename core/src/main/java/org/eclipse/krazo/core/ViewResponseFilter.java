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

import org.eclipse.krazo.KrazoConfig;
import org.eclipse.krazo.event.AfterControllerEventImpl;
import org.eclipse.krazo.event.ControllerRedirectEventImpl;

import javax.annotation.Priority;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import org.eclipse.krazo.engine.Viewable;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.ControllerRedirectEvent;
import javax.mvc.event.MvcEvent;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Variant;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.*;
import static org.eclipse.krazo.cdi.KrazoCdiExtension.isEventObserved;
import static org.eclipse.krazo.util.AnnotationUtils.getAnnotation;
import static org.eclipse.krazo.util.PathUtils.*;

/**
 * <p>A JAX-RS response filter that fires a {@link javax.mvc.event.AfterControllerEvent}
 * event. It also verifies the static return type of the controller method is correct,
 * and ensures that the entity is a {@link Viewable} to be processed by
 * {@link ViewableWriter}.</p>
 *
 * <p>The class uses {@link javax.ws.rs.core.Request} which implements the algorithm in
 * Section 3.8 of the JAX-RS specification to compute the final Content-Type when
 * the method returns void (no entity). If unable to compute the final Content-Type,
 * e.g. if the controller method is not annotated by {@code @Produces}, it defaults to
 * {@code text/html}. If the method does not return void (has an entity), the computation
 * of the Content-Type is done by JAX-RS and is available via {@code responseContext}.</p>
 *
 * <p>Given that this filter is annotated with {@link Controller}, it
 * will be called after every controller method returns. Priority is set to
 * {@link javax.ws.rs.Priorities#ENTITY_CODER} which means it will be executed
 * after user-defined response filters (response filters are sorted in reverse order).</p>
 *
 * @author Santiago Pericas-Geertsen
 */
@Controller
@Priority(Priorities.ENTITY_CODER)
public class ViewResponseFilter implements ContainerResponseFilter {

    private static final String REDIRECT = "redirect:";

    @Context
    private UriInfo uriInfo;

    @Context
    private ResourceInfo resourceInfo;

    @Context
    private HttpServletRequest request;

    @Inject
    private Event<MvcEvent> dispatcher;

    @Inject
    private Messages messages;

    @Inject
    private KrazoConfig krazoConfig;

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {
        // Fire AfterControllerEvent event
        if (isEventObserved(AfterControllerEvent.class)) {
            final AfterControllerEventImpl event = new AfterControllerEventImpl();
            event.setUriInfo(uriInfo);
            event.setResourceInfo(resourceInfo);
            event.setContainerRequestContext(requestContext);
            event.setContainerResponseContext(responseContext);
            dispatcher.fire(event);
        }

        final Method method = resourceInfo.getResourceMethod();
        final Class<?> returnType = method.getReturnType();

        // Wrap entity type into Viewable, possibly looking at @View
        Object entity = responseContext.getEntity();
        final Class<?> entityType = entity != null ? entity.getClass() : null;
        if (entityType == null) {       // NO_CONTENT
            View an = getAnnotation(method, View.class);
            if (an == null) {
                an = getAnnotation(resourceInfo.getResourceClass(), View.class);
            }
            if (an != null) {
                MediaType contentType = selectVariant(requestContext.getRequest(), resourceInfo);
                if (contentType == null) {
                    contentType = MediaType.TEXT_HTML_TYPE;     // default
                }
                responseContext.setEntity(new Viewable(appendExtensionIfRequired(an.value())), null, contentType);
                // If the entity is null the status will be set to 204 by Jersey. For void methods we need to
                // set the status to 200 unless no other status was set by e.g. throwing an Exception.

                // Don't use equals() on the result of getStatusInfo(), because it doesn't work on CXF
                if (responseContext.getStatusInfo().getStatusCode() == Response.Status.NO_CONTENT.getStatusCode()) {
                    responseContext.setStatusInfo(Response.Status.OK);
                }
                
            } else if (returnType == Void.TYPE) {
                throw new ServerErrorException(messages.get("VoidControllerNoView", resourceInfo.getResourceMethod()), INTERNAL_SERVER_ERROR);
            }
        } else {
            final String view = appendExtensionIfRequired(entityType == Viewable.class ? ((Viewable) entity).getView() : entity.toString());
            if (view == null) {
                throw new ServerErrorException(messages.get("EntityToStringNull", resourceInfo.getResourceMethod()), INTERNAL_SERVER_ERROR);
            }
            responseContext.setEntity(new Viewable(view), null, responseContext.getMediaType());
        }

        // Redirect logic, entity must be a Viewable if not null
        entity = responseContext.getEntity();
        if (entity != null) {
            final String view = appendExtensionIfRequired(((Viewable) entity).getView());
            final String uri = uriInfo.getBaseUri() + noStartingSlash(noPrefix(view, REDIRECT));
            if (view.startsWith(REDIRECT)) {
                responseContext.setStatusInfo(SEE_OTHER);
                responseContext.getHeaders().putSingle(HttpHeaders.LOCATION, uri);
                responseContext.setEntity(null);
            }
        }

        // Fire ControllerRedirectEvent event
        if (isEventObserved(ControllerRedirectEvent.class)) {
            final int status = responseContext.getStatus();
            if (status == SEE_OTHER.getStatusCode() || status == MOVED_PERMANENTLY.getStatusCode()
                    || status == FOUND.getStatusCode() || status == TEMPORARY_REDIRECT.getStatusCode()) {
                final ControllerRedirectEventImpl event = new ControllerRedirectEventImpl();
                event.setUriInfo(uriInfo);
                event.setResourceInfo(resourceInfo);
                event.setLocation(URI.create(responseContext.getHeaderString(HttpHeaders.LOCATION)));
                event.setContainerRequestContext(requestContext);
                event.setContainerResponseContext(responseContext);
                dispatcher.fire(event);
            }
        }
    }

    private String appendExtensionIfRequired(String viewName) {
        return appendExtensionIfRequired(viewName, krazoConfig.getDefaultViewFileExtension());
    }

    /*
     * Append to view name default extension if one available and applicable.
     */
    static String appendExtensionIfRequired(String viewName, String defaultExtension) {
        if (viewName == null || viewName.startsWith(REDIRECT)
            || defaultExtension == null || defaultExtension.length() == 0) {
            return viewName;
        }

        String resultView = viewName;
        if (!viewName.contains(".")) {
            resultView += "." + defaultExtension;
        }
        return resultView;
    }

    private static MediaType selectVariant(Request request, ResourceInfo resourceInfo) {

        Produces produces = resourceInfo.getResourceMethod().getAnnotation(Produces.class);
        if (produces == null) {
            produces = getAnnotation(resourceInfo.getResourceClass(), Produces.class);
        }

        if (produces != null) {

            List<Variant> variants = Arrays.stream(produces.value())
                .map((String mt) -> Variant.mediaTypes(MediaType.valueOf(mt)).build().get(0))
                .collect(Collectors.toList());

            Variant variant = request.selectVariant(variants);
            if (variant != null) {
                return variant.getMediaType();
            }

        }

        return null;

    }

}
