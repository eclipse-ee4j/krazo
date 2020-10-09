package org.eclipse.krazo.test.forms;

import org.eclipse.krazo.Properties;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

@ApplicationPath("resources")
public class MyApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        final Map<String, Object> props = new HashMap<>();
        props.put(Properties.HIDDEN_METHOD_FILTER_ACTIVE, true);

        return props;
    }
}
