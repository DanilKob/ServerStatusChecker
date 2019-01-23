package controller;

import controller.filters.EncodingConstants;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerServlet extends HttpServlet {

    private void greetingResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType(EncodingConstants.APPLICATION_JSON);

        // init Map
        Map<String, String> options = new LinkedHashMap<>();
        options.put("value1", "label1");
        options.put("value2", "label2");
        options.put("value3", "label3");

        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(options);
        jsonObject.writeJSONString(response.getWriter());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        greetingResponse(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
