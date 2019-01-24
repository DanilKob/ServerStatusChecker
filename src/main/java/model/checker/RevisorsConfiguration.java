package model.checker;

import java.util.List;

public class RevisorsConfiguration {
    private List<RevisorServerConfiguration> revisorServerConfigurations;

    public List<RevisorServerConfiguration> getRevisorServerConfigurations() {
        return revisorServerConfigurations;
    }

    public void setRevisorServerConfigurations(List<RevisorServerConfiguration> revisorServerConfigurations) {
        this.revisorServerConfigurations = revisorServerConfigurations;
    }
}
