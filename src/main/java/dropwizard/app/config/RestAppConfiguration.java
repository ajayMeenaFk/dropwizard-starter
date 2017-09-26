package dropwizard.app.config;

import io.dropwizard.Configuration;
import lombok.Getter;


public class RestAppConfiguration extends Configuration{
    @Getter
    private String name;
}
