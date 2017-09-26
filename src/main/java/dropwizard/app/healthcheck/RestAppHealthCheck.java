package dropwizard.app.healthcheck;


import com.codahale.metrics.health.HealthCheck;
import dropwizard.app.config.RestAppConfiguration;

public class RestAppHealthCheck extends HealthCheck{
    private final RestAppConfiguration configuration;

    public RestAppHealthCheck(RestAppConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    protected Result check() throws Exception {
        if(configuration.getName().equals("healthy")){
            return Result.healthy();
        }
        return Result.unhealthy("Please set up config name as  healthy");
    }
}
