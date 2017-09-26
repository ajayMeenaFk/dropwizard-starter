package dropwizard.app.resource;

import dropwizard.app.dynamic_feature.AuthRequired;

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
    @Path("/auth")
    @GET
    @AuthRequired
    public String testAuth(){
        return "Auth passed";
    }
}
