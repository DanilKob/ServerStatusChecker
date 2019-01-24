package controller.response.processors;

import controller.commands.CommandConstants;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(CommandConstants.FORWARD)
public class ForwardResponseProcessor implements ResponseProcessor{
    public void process(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        request.getRequestDispatcher(page).forward(request,response);
    }
}
