package spring.security.authentication.config.core;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import spring.security.authentication.config.DataBaseConfig;
import spring.security.authentication.config.SecurityConfig;
import spring.security.authentication.config.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        context.register(SecurityConfig.class);
        context.register(DataBaseConfig.class);

        container.addListener(new ContextLoaderListener(context));

        context.setServletContext(container);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        final ServletRegistration.Dynamic servlet = container.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
