package org.eclipse.krazo.test.forms;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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
