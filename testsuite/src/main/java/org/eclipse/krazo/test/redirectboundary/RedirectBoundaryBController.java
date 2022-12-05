package org.eclipse.krazo.test.redirectboundary;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/b")
@RequestScoped
@Controller
public class RedirectBoundaryBController {

    @Inject
    RedirectBean bean;

    @Inject
    Models models;

    @GET
    public String index() {
        models.put("redirectBeanValue", bean.getMessage());
        return "b.jsp";
    }
}
