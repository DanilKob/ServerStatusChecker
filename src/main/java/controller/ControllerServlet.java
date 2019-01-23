package controller;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    private ApplicationContext springApplicationContext;

    @Override
    public void init() throws ServletException {
        super.init();
        springApplicationContext =
                (ApplicationContext) super.getServletContext().getAttribute(SpringContexConstants.APPLICATION_CONTEXT);
        AutowireCapableBeanFactory autowireCapableBeanFactory = springApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
