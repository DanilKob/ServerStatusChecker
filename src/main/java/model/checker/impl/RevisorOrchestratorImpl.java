package model.checker.impl;

import model.checker.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RevisorOrchestratorImpl implements RevisionOrchestrator {

    private Map<RevisorServerConfiguration, RevisorServer> revisorServerMap = new HashMap<>();

    @Override
    public RevisionResult checkServers(RevisionConfiguration revisionConfiguration) {
        return null;
    }

    @Override
    public void addRevisor(RevisorServer revisorServer) {
        revisorServerMap.putIfAbsent(revisorServer.getRevisorConfiguration(), revisorServer);
    }

    @Override
    public void update(RevisorServer revisorServer) {
        revisorServerMap.put(revisorServer.getRevisorConfiguration(), revisorServer);
    }
}
