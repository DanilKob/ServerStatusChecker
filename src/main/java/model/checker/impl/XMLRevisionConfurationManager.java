package model.checker.impl;

import model.checker.ConfigurationManager;
import model.checker.RevisionConfiguration;
import org.springframework.stereotype.Component;

@Component
public class XMLRevisionConfurationManager implements ConfigurationManager<RevisionConfiguration> {
    @Override
    public RevisionConfiguration getConfiguration() {
        return null;
    }

    @Override
    public void updateConfiguration(RevisionConfiguration configuration) {

    }

    @Override
    public void isCached(boolean isCached) {

    }

}
