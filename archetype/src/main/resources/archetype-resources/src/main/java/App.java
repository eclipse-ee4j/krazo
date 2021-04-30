package ${package};

import java.util.Map;

import jakarta.mvc.security.Csrf;
import jakarta.mvc.security.Csrf.CsrfOptions;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Default JAX-RS application listening on /mvc
 */
@ApplicationPath("/mvc")
public class App extends Application {

    @Override
    public Map<String, Object> getProperties() {
        return Map.of(Csrf.CSRF_PROTECTION, CsrfOptions.IMPLICIT);
    }
}
