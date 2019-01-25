package model.checker;

import java.util.List;

public class RevisionResult {
    private List<ServerRevisionResult> serverRevisionResultList;

    public List<ServerRevisionResult> getServerRevisionResultList() {
        return serverRevisionResultList;
    }

    public void setServerRevisionResultList(List<ServerRevisionResult> serverRevisionResultList) {
        this.serverRevisionResultList = serverRevisionResultList;
    }
}
