package model.checker.impl;

import model.checker.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RevisorOrchestratorImpl implements RevisionOrchestrator {

    private Map<RevisorServerConfiguration, RevisorServer> revisorServerMap = new HashMap<>();

    @Override
    public RevisionResult checkServers(RevisionConfiguration revisionConfiguration) {
        System.out.println("Check servers ... ");
        List<ServerRevisionResult> serverRevisionResults = revisorServerMap.values()
                .stream()
                .map(revisorServer -> revisorServer.checkServers(revisionConfiguration))
                .collect(Collectors.toList());
        RevisionResult revisionResult = new RevisionResult();
        revisionResult.setServerRevisionResultList(serverRevisionResults);
        return revisionResult;
    }

    @Override
    public void addRevisor(RevisorServer revisorServer) {
        revisorServerMap.put(revisorServer.getRevisorConfiguration(), revisorServer);
    }

    @Override
    public void update(RevisorServer revisorServer) {
        revisorServerMap.put(revisorServer.getRevisorConfiguration(), revisorServer);
    }
}
