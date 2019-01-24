package model.checker;

import java.net.URL;

public class ServerRevisionTask {
    private URL url;
    //private int normalTimeout;
    private int criticalTimeout;
    private int errorTimeout;

    private int minContentSize;
    private int maxConatentSize;

    public ServerRevisionTask (){

    }

    public ServerRevisionTask(URL url, int criticalTimeout, int errorTimeout, int minContentSize, int maxConatentSize) {
        this.url = url;
        this.criticalTimeout = criticalTimeout;
        this.errorTimeout = errorTimeout;
        this.minContentSize = minContentSize;
        this.maxConatentSize = maxConatentSize;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public int getCriticalTimeout() {
        return criticalTimeout;
    }

    public void setCriticalTimeout(int criticalTimeout) {
        this.criticalTimeout = criticalTimeout;
    }

    public int getErrorTimeout() {
        return errorTimeout;
    }

    public void setErrorTimeout(int errorTimeout) {
        this.errorTimeout = errorTimeout;
    }

    public int getMinContentSize() {
        return minContentSize;
    }

    public void setMinContentSize(int minContentSize) {
        this.minContentSize = minContentSize;
    }

    public int getMaxConatentSize() {
        return maxConatentSize;
    }

    public void setMaxConatentSize(int maxConatentSize) {
        this.maxConatentSize = maxConatentSize;
    }
}
