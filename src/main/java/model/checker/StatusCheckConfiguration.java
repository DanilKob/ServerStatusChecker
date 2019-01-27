package model.checker;

import java.util.List;

public class StatusCheckConfiguration {
    private List<StatusCheckTask> statusCheckTaskList;
    private int frequance;



    public List<StatusCheckTask> getStatusCheckTaskList() {
        return statusCheckTaskList;
    }

    public void setStatusCheckTaskList(List<StatusCheckTask> statusCheckTaskList) {
        this.statusCheckTaskList = statusCheckTaskList;
    }

    public int getFrequance() {
        return frequance;
    }

    public void setFrequance(int frequance) {
        this.frequance = frequance;
    }
}
