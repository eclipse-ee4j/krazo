package org.eclipse.krazo.test.redirectboundaryonroot;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.krazo.Properties;

@ApplicationPath("")
public class RedirectApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        final Map<String, Object> props = new HashMap<>();
        props.put(Properties.REDIRECT_SCOPE_COOKIES, true);
        props.put(Properties.REDIRECT_SCOPE_COOKIE_NAME, "custom_cookie");
        return props;
    }
}
