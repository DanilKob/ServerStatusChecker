package controller.commands.impl;

import controller.commands.Command;
import controller.commands.CommandConstants;
import model.checker.*;
import model.checker.utils.ResultUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("getResult")
public class ExamineStatusesCommand implements Command {

    @Autowired
    @Qualifier("configurationByJavaBean")
    //@Qualifier("configurationByDataBaseBean")
    // Can be configuratin manager that read config from DataBase, XML, Json
    private ConfigurationManager<StatusCheckConfiguration> revisionConfigurationConfigurationManager;

    @Autowired
    private StatusCheckOrchestrator statusCheckOrchestrator;

    @Autowired
    private ExaminerAgentFactory examinerAgentFactory;

    @Autowired
    ResultUtils resultUtils;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StatusCheckConfiguration statusCheckConfiguration = revisionConfigurationConfigurationManager.getConfiguration();
        OverallStatusCheckResult overallStatusCheckResult = statusCheckOrchestrator.checkServers(statusCheckConfiguration);

        JSONObject jsonObject = resultUtils.adaptToJson(overallStatusCheckResult);
        jsonObject.writeJSONString(response.getWriter());

        return CommandConstants.JSON_RESPONSE;
    }

    @PostConstruct
    private void initRevisorServer() {
        ExaminerAgent localExaminerAgent = examinerAgentFactory.build();
        statusCheckOrchestrator.addExaminerAgent(localExaminerAgent);
    }
}
