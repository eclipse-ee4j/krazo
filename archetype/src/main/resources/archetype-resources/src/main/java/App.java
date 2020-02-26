package ${package};

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Default JAX-RS application listening on /mvc
 */
@ApplicationPath("/mvc")
public class App extends Application {
}