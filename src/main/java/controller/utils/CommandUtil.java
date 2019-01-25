package controller.utils;

import controller.Parameters;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CommandUtil {
    //private Pattern pattern = Pattern.compile(".*/");

    public String getCommandBeanName(HttpServletRequest request) {
        return request.getParameter(Parameters.ACTION_PARAM);
    }

    public String getResponseProcessorBeanName(String responseType) {
        return responseType.split("/")[0];
    }

    public String getResponsePage(String responseType) {
        return responseType.substring(responseType.indexOf("/"));
    }
}
