package model.checker;

public class RevisorServerConfiguration {
    private String host;
    private int port;
    private boolean isActive;

    public RevisorServerConfiguration () {

    }

    public RevisorServerConfiguration(String host, int port, boolean isActive) {
        this.host = host;
        this.port = port;
        this.isActive = isActive;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
