package model.checker.impl;

import model.checker.RevisorServerConfiguration;
import model.checker.ServerRevisionResult;
import model.checker.RevisorServer;
import model.checker.RevisionConfiguration;
import org.springframework.stereotype.Component;

@Component
public class LocalRevisorServer implements RevisorServer {
    @Override
    public void setRevisorServerConfiguration(RevisorServerConfiguration revisorServerConfiguration) {

    }

    @Override
    public ServerRevisionResult checkServers(RevisionConfiguration revisionConfiguration) {
        return null;
    }
}
