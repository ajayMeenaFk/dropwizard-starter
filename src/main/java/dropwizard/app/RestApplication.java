package dropwizard.app;


import dropwizard.app.config.RestAppConfiguration;
import dropwizard.app.dynamic_feature.AuthDynamicFeature;
import dropwizard.app.healthcheck.RestAppHealthCheck;
import dropwizard.app.manged.RestAppManaged;
import dropwizard.app.resource.TestResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestApplication extends Application<RestAppConfiguration> {

    @Override
    public void run(RestAppConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(TestResource.class);
        environment.healthChecks().register("healthcheck", new RestAppHealthCheck(configuration));
        environment.lifecycle().manage(new RestAppManaged());
        environment.jersey().register(AuthDynamicFeature.class);
    }

    @Override
    public void initialize(Bootstrap<RestAppConfiguration> bootstrap){
        //configuration related things goes here
    }

    public static void main(String [] args) throws Exception{
        RestApplication restApplication = new RestApplication();
        restApplication.run(args);

    }
}
