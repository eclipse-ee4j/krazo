package org.eclipse.krazo.test.forms;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("forms")
@Controller
public class FormsController {

    @Inject
    private Models models;

    @Inject
    private RedirectModel redirectModel;

    @GET
    public String invokeGET(@QueryParam("without-hidden-field") final boolean withoutHiddenField) {
        if (withoutHiddenField) {
            return "form-without-hidden-field.jsp";
        } else {
            return "form.jsp";
        }
    }

    @GET
    @Path("ok")
    public String invokeGETForOK() {
        models.put("method", redirectModel.getInvokedMethod());
        return "ok.jsp";
    }

    @POST
    public String invokePOST() {
        redirectModel.setInvokedMethod("POST");
        return "redirect:/forms/ok";
    }

    @PUT
    public String invokePUT() {
        redirectModel.setInvokedMethod("PUT");
        return "redirect:/forms/ok";
    }

    @PATCH
    public String invokePATCH() {
        redirectModel.setInvokedMethod("PATCH");
        return "redirect:/forms/ok";
    }

    @DELETE
    public String invokeDELETE() {
        redirectModel.setInvokedMethod("DELETE");
        return "redirect:/forms/ok";
    }
}
