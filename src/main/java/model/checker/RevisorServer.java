package model.checker;

public interface RevisorServer {
    void setRevisorServerConfiguration(RevisorServerConfiguration revisorServerConfiguration);
    ServerRevisionResult checkServers(RevisionConfiguration revisionConfiguration);
}
