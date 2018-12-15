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
package org.eclipse.krazo.jersey.model;

import org.glassfish.jersey.server.model.ModelProcessor;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceMethod;
import org.glassfish.jersey.server.model.ResourceModel;

import javax.mvc.Controller;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;

/**
 * A Jersey model processor to ensure that all controller methods whose {@code @Produces}
 * list are empty are set to "text/html", which is the default for MVC.
 *
 * @author Santiago Pericas-Geertsen
 */
public class KrazoModelProcessor implements ModelProcessor {

    @Override
    public ResourceModel processResourceModel(ResourceModel resourceModel, Configuration configuration) {
        ResourceModel.Builder rmb = new ResourceModel.Builder(false);
        resourceModel.getResources().forEach(r -> {
            rmb.addResource(processResource(r));
        });
        return rmb.build();
    }

    @Override
    public ResourceModel processSubResource(ResourceModel subResourceModel, Configuration configuration) {
        return subResourceModel;
    }

    /**
     * Updates the default {@code @Produces} list of every controller method whose list is empty.
     * The new list contains a single media type: "text/html".
     *
     * @param r resource to process.
     * @return newly updated resource.
     */
    private static Resource processResource(Resource r) {
        final boolean isControllerClass = isController(r);
        Resource.Builder rb = Resource.builder(r);
        r.getAllMethods().forEach(
                (ResourceMethod m) -> {
                    if ((isController(m) || isControllerClass) && m.getProducedTypes().isEmpty()) {
                        final ResourceMethod.Builder rmb = rb.updateMethod(m);
                        rmb.produces(MediaType.TEXT_HTML_TYPE);
                        rmb.build();
                    }
                }
        );
        r.getChildResources().forEach(cr -> {
            rb.replaceChildResource(cr, processResource(cr));
        });
        return rb.build();
    }

    /**
     * Determines if a resource method is a controller.
     *
     * @param method resource method to test.
     * @return outcome of controller test.
     */
    private static boolean isController(ResourceMethod method) {
        return method.getInvocable().getDefinitionMethod().isAnnotationPresent(Controller.class);
    }

    /**
     * Determines if a resource is a controller.
     *
     * @param resource resource to test.
     * @return outcome of controller test.
     */
    private static boolean isController(Resource resource) {
        final Boolean b1 = resource.getHandlerClasses().stream()
                .map(c -> c.isAnnotationPresent(Controller.class))
                .reduce(Boolean.FALSE, Boolean::logicalOr);
        final Boolean b2 = resource.getHandlerInstances().stream()
                .map(o -> o.getClass().isAnnotationPresent(Controller.class))
                .reduce(Boolean.FALSE, Boolean::logicalOr);
        return b1 || b2;
    }
}
