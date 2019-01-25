package model.checker;

import java.util.List;

public class RevisionConfiguration {
    private List<ServerRevisionTask> serverRevisionTaskList;
    private int frequance;



    public List<ServerRevisionTask> getServerRevisionTaskList() {
        return serverRevisionTaskList;
    }

    public void setServerRevisionTaskList(List<ServerRevisionTask> serverRevisionTaskList) {
        this.serverRevisionTaskList = serverRevisionTaskList;
    }

    public int getFrequance() {
        return frequance;
    }

    public void setFrequance(int frequance) {
        this.frequance = frequance;
    }
}
