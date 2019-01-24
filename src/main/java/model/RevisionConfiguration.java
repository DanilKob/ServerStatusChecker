package model;

import java.util.List;

public class RevisionConfiguration {
    private List<ServerRevisionTask> serverRevisionTaskList;

    private int lastChecked; // Should be date
    private int frequance;
}
