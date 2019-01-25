package controller.commands.impl;

import controller.commands.Command;
import controller.commands.CommandConstants;
import model.checker.*;
import model.checker.utils.ResultUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RevisionOnLocalServerCommand implements Command {

    private ConfigurationManager<RevisionConfiguration> revisionConfigurationConfigurationManager;
    //private ConfigurationManager<RevisorsConfiguration> revisorsConfigurationConfigurationManager;

    @Autowired
    private RevisionOrchestrator revisionOrchestrator;

    @Autowired
    private RevisorServerFactory revisorServerFactory;

    @Autowired
    ResultUtils resultUtils;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        RevisionConfiguration revisionConfiguration = revisionConfigurationConfigurationManager.getConfiguration();
        RevisionResult revisionResult = revisionOrchestrator.checkServers(revisionConfiguration);

        JSONObject jsonObject = resultUtils.adaptToJson(revisionResult);
        jsonObject.writeJSONString(response.getWriter());

        return CommandConstants.JSON_RESPONSE;
    }

    @PostConstruct
    private void initRevisorServer() {
        RevisorServer localRevisorServer = revisorServerFactory.build();
        revisionOrchestrator.addRevisor(localRevisorServer);
    }
}
