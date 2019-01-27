package model.checker;

public interface ExaminerAgent {
    StatusCheckFromAgentResult checkServers(StatusCheckConfiguration statusCheckConfiguration);
    void setExaminerAgentConfiguration(ExaminerAgentConfiguration examinerAgentConfiguration);
    ExaminerAgentConfiguration getExaminerAgentConfiguration();
}
