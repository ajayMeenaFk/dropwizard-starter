package dropwizard.app.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class AppFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filters init method called");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Request start time {}", new Date());
        chain.doFilter(request, response);
        log.info("Request complete time {}", new Date());
    }

    @Override
    public void destroy() {
        log.info("Filters destroy method called");
    }
}
