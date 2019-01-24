package model.checker;



public interface RevisionOrchestrator {
    RevisionResult checkServers(RevisionConfiguration revisionConfiguration);

    void addRevisor(RevisorServer revisorServer);

    void update(RevisorServer revisorServer);
}
