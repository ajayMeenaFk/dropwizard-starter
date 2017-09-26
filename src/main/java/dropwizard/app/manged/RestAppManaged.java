package dropwizard.app.manged;

import io.dropwizard.lifecycle.Managed;
import lombok.extern.slf4j.Slf4j;

/**
 * This class instance created before dropwizard application starts and call its start method.
 * It is usefull when server needs to do some task before app gets ready to serve requests
 */
@Slf4j
public class RestAppManaged implements Managed{
    @Override
    public void start() throws Exception {
       log.info("RestApp managed objects method started");
    }

    @Override
    public void stop() throws Exception {
        log.info("This method called when dropwizard application stops");
    }
}
