package model.checker;

import java.util.List;

public class OverallStatusCheckResult {
    private List<StatusCheckFromAgentResult> statusCheckFromAgentResultList;

    public List<StatusCheckFromAgentResult> getStatusCheckFromAgentResultList() {
        return statusCheckFromAgentResultList;
    }

    public void setStatusCheckFromAgentResultList(List<StatusCheckFromAgentResult> statusCheckFromAgentResultList) {
        this.statusCheckFromAgentResultList = statusCheckFromAgentResultList;
    }
}
