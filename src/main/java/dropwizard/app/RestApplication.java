package dropwizard.app;


import com.google.inject.Guice;
import com.hubspot.dropwizard.guice.GuiceBundle;
import dropwizard.app.config.RestAppConfiguration;
import dropwizard.app.dynamic_feature.AuthDynamicFeature;
import dropwizard.app.filter.AppFilter;
import dropwizard.app.healthcheck.RestAppHealthCheck;
import dropwizard.app.manged.RestAppManaged;
import dropwizard.app.module.RestAppModule;
import dropwizard.app.resource.BookStoreResource;
import dropwizard.app.resource.TestResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class RestApplication extends Application<RestAppConfiguration> {
    private GuiceBundle<RestAppConfiguration> guiceBundle;

    @Override
    public void run(RestAppConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(TestResource.class);
        environment.jersey().register(BookStoreResource.class);
        environment.healthChecks().register("healthcheck", new RestAppHealthCheck(configuration));
        environment.lifecycle().manage(new RestAppManaged());
        environment.jersey().register(AuthDynamicFeature.class);
        environment.servlets().addFilter("requestStartAndEndTime", new AppFilter()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

    @Override
    public void initialize(Bootstrap<RestAppConfiguration> bootstrap){
        guiceBundle = GuiceBundle.<RestAppConfiguration>newBuilder()
                .addModule(new RestAppModule())
                .setConfigClass(RestAppConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);

    }

    public static void main(String [] args) throws Exception{
        RestApplication restApplication = new RestApplication();
        restApplication.run(args);

    }
}
