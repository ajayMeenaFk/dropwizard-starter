package dropwizard.app.dynamic_feature;


import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

public class AuthDynamicFeature implements DynamicFeature {
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if(resourceInfo.getResourceMethod().isAnnotationPresent(AuthRequired.class)){
            context.register(AuthFilter.class);
        }
    }
}
