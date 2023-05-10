package org.eclipse.krazo.test.defaultview;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Controller
@RequestScoped
@Path("default-view")
public class DefaultViewController {

    @GET
    public String index() {
        return "index";
    }
}
