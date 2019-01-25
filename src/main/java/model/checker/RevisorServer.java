package model.checker;

public interface RevisorServer {
    ServerRevisionResult checkServers(RevisionConfiguration revisionConfiguration);
    void setRevisorServerConfiguration(RevisorServerConfiguration revisorServerConfiguration);
    RevisorServerConfiguration getRevisorConfiguration();
}
