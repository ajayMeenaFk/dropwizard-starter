package dropwizard.app.dynamic_feature;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

public class AuthFilter implements ContainerRequestFilter{
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        if(headers != null && headers.containsKey("Auth") && headers.get("Auth").equals("token")){
            return;
        }
        throw new WebApplicationException("Auth is not present");
    }
}
