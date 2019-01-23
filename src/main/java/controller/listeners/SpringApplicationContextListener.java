package controller.listeners;

import controller.SpringContexConstants;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringApplicationContextListener implements ServletContextListener {

    private ClassPathXmlApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.context = new ClassPathXmlApplicationContext(SpringContexConstants.CONFIGURATION_XML_PATH);
        servletContextEvent.getServletContext().setAttribute(SpringContexConstants.APPLICATION_CONTEXT, context);
        System.out.println("Init Contex");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.context.close();
    }
}
