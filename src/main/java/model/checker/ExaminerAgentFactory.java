package model.checker;

import java.util.List;

public interface ExaminerAgentFactory {
    ExaminerAgent build();
    ExaminerAgent build(ExaminerAgentConfiguration examinerAgentConfiguration);
    List<ExaminerAgent> build(OverallExaminerAgentsConfiguration overallExaminerAgentsConfiguration);
}
