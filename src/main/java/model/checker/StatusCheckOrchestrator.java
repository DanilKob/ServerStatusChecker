package model.checker;



public interface StatusCheckOrchestrator {
    OverallStatusCheckResult checkServers(StatusCheckConfiguration statusCheckConfiguration);

    void addExaminerAgent(ExaminerAgent examinerAgent);

    void update(ExaminerAgent examinerAgent);
}
