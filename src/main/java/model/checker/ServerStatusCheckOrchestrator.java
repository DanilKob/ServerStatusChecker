package model.checker;

public interface ServerStatusCheckOrchestrator {
    void setRevisionConfigurationManager(ConfigurationManager<RevisionConfiguration> revisionConfigurationManager);
    void setRevisorConfigurationManager(ConfigurationManager<RevisorServerConfiguration> revisorConfigurationManager);
    void checkServers();
}
