package model.checker;

import java.util.List;

public class ServerRevisionResult {
    List<ServerRevisionResultItem> serverRevisionResultItemList;
    private String serverDescription;

    public List<ServerRevisionResultItem> getServerRevisionResultItemList() {
        return serverRevisionResultItemList;
    }

    public void setServerRevisionResultItemList(List<ServerRevisionResultItem> serverRevisionResultItemList) {
        this.serverRevisionResultItemList = serverRevisionResultItemList;
    }

    public String getServerDescription() {
        return serverDescription;
    }

    public void setServerDescription(String serverDescription) {
        this.serverDescription = serverDescription;
    }
}
