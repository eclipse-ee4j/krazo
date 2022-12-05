package org.eclipse.krazo.test.redirectboundaryonroot;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/a")
@RequestScoped
@Controller
public class RedirectBoundaryAController {

    @Inject
    RedirectBean bean;

    @Inject
    Models models;

    @GET
    public String index() {
        models.put("redirectBeanValue", bean.getMessage());
        return "a.jsp";
    }

    @POST
    @Path("/toA")
    public String postA() {
        bean.setMessage("Redirect to A!");

        return "redirect:/a";
    }

    @POST
    @Path("/toB")
    public String postB() {
        bean.setMessage("Redirect to B!");

        return "redirect:/b";
    }
}
