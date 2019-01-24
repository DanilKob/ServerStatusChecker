package model.checker.impl;

import model.checker.RevisionConfiguration;
import model.checker.RevisorServerConfiguration;
import model.checker.ServerRevisionResult;
import model.checker.RevisorServer;

public class RemoteRevisorServer implements RevisorServer {
    @Override
    public void setRevisorServerConfiguration(RevisorServerConfiguration revisorServerConfiguration) {

    }

    @Override
    public ServerRevisionResult checkServers(RevisionConfiguration revisionConfiguration) {
        return null;
    }
}
