package org.eclipse.krazo.test.defaultview;

import jakarta.mvc.engine.ViewEngine;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.Map;

@ApplicationPath("mvc")
public class DefaultViewApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        return Map.of(ViewEngine.VIEW_EXTENSION, ".jsp");
    }
}
