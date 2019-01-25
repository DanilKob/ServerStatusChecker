package model.checker;

public class ServerRevisionResultItem {
    private ServerRevisionTask serverRevisionTask;
    private double responseTime;
    private int responseCode;
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    private String serverDescription;

    public ServerRevisionTask getServerRevisionTask() {
        return serverRevisionTask;
    }

    public void setServerRevisionTask(ServerRevisionTask serverRevisionTask) {
        this.serverRevisionTask = serverRevisionTask;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getServerDescription() {
        return serverDescription;
    }

    public void setServerDescription(String serverDescription) {
        this.serverDescription = serverDescription;
    }
}
