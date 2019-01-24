package controller.response.processors;

import controller.commands.CommandConstants;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(CommandConstants.REDIRECT)
public class RedirectResponseProcessor implements ResponseProcessor{
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        response.sendRedirect(page);
    }
}
