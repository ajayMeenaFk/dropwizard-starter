package dropwizard.app.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
@Produces("application/json")
public class TestResource {
    @GET
    public String test(){
        return "App is UP";
    }
}
