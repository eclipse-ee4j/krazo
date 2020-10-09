package org.eclipse.krazo.test.convert.type;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.binding.MvcBinding;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Controller
@Path("converter")
public class ConverterController {

    @Inject
    private NumberTransporter numberTransporter;

    @Inject
    private Models models;

    @GET
    public String doGetIndex() {
        return "index.jsp";
    }

    @GET
    @Path("result")
    public String doGetResult() {
        models.put("resultNumber", numberTransporter.getNumber());

        return "result.jsp";
    }

    @POST
    public String doPost(@MvcBinding @FormParam("number") final double someNumber) {
        numberTransporter.setNumber(someNumber);
        return "redirect:/converter/result";
    }
}
