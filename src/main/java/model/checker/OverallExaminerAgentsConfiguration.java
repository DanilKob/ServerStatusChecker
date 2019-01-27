package model.checker;

import java.util.List;

public class OverallExaminerAgentsConfiguration {
    private List<ExaminerAgentConfiguration> examinerAgentConfigurations;

    public List<ExaminerAgentConfiguration> getExaminerAgentConfigurations() {
        return examinerAgentConfigurations;
    }

    public void setExaminerAgentConfigurations(List<ExaminerAgentConfiguration> examinerAgentConfigurations) {
        this.examinerAgentConfigurations = examinerAgentConfigurations;
    }
}
