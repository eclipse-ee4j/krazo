package ${package}.controller;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("app")
@Controller
public class AppController {

  @GET
  public String sayHello() {
    return "hello.jsp";
  }
}
