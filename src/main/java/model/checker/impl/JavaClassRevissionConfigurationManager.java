package model.checker.impl;

import model.checker.ConfigurationManager;
import model.checker.StatusCheckConfiguration;

public abstract class JavaClassRevissionConfigurationManager implements ConfigurationManager<StatusCheckConfiguration> {

    private StatusCheckConfiguration statusCheckConfiguration;

    @Override
    public StatusCheckConfiguration getConfiguration() {
        if (statusCheckConfiguration == null) {

        }
        return statusCheckConfiguration;
    }

    @Override
    public void updateConfiguration(StatusCheckConfiguration configuration) {
        this.statusCheckConfiguration = configuration;
    }

    public abstract StatusCheckConfiguration initRevissionConfig();
}
