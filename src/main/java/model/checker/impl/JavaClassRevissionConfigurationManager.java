package model.checker.impl;

import model.checker.ConfigurationManager;
import model.checker.RevisionConfiguration;

public abstract class JavaClassRevissionConfigurationManager implements ConfigurationManager<RevisionConfiguration> {

    private RevisionConfiguration revisionConfiguration;

    @Override
    public RevisionConfiguration getConfiguration() {
        if (revisionConfiguration == null) {

        }
        return revisionConfiguration;
    }

    @Override
    public void updateConfiguration(RevisionConfiguration configuration) {
        this.revisionConfiguration = configuration;
    }

    public abstract RevisionConfiguration initRevissionConfig();
}
