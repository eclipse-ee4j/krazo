package ${package}.controller;

import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("app")
@Controller
public class AppController {

    @GET
    public String sayHello() {
        return "hello.jsp";
    }
}
