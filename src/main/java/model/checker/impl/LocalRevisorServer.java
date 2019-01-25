package model.checker.impl;

import model.checker.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalRevisorServer implements RevisorServer {

    private RevisorServerConfiguration revisorServerConfiguration;

    @Override
    public void setRevisorServerConfiguration(RevisorServerConfiguration revisorServerConfiguration) {
        this.revisorServerConfiguration = revisorServerConfiguration;
    }

    @Override
    public RevisorServerConfiguration getRevisorConfiguration() {
        return revisorServerConfiguration;
    }

    @Override
    public ServerRevisionResult checkServers(RevisionConfiguration revisionConfiguration) {
        ServerRevisionResult serverRevisionResult = new ServerRevisionResult();
        // todo implement by Future
        List<ServerRevisionTask> serverRevisionTaskList = revisionConfiguration.getServerRevisionTaskList();
        List<ServerRevisionResultItem> serverRevisionResultItemList = serverRevisionTaskList
                .stream()
                .parallel()
                .map(this::ping)
                .collect(Collectors.toList());
        serverRevisionResult.setServerRevisionResultItemList(serverRevisionResultItemList);

        return serverRevisionResult;
    }

    private ServerRevisionResultItem ping(ServerRevisionTask serverRevisionTask) {
        ServerRevisionResultItem serverRevisionResultItem = new ServerRevisionResultItem();
        serverRevisionResultItem.setServerRevisionTask(serverRevisionTask);

        int criticalTimeout = serverRevisionTask.getCriticalTimeout();
        URL url = serverRevisionTask.getUrl();

        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(criticalTimeout);
            httpURLConnection.setRequestMethod("GET");

            long startTime;
            long finishTime;
            double resultTime;

            startTime = System.nanoTime();
            httpURLConnection.connect();
            finishTime = System.nanoTime();

            resultTime = ((finishTime - startTime) / 1000.0);

            int responseCode = httpURLConnection.getResponseCode();
            serverRevisionResultItem.setResponseCode(responseCode);
            serverRevisionResultItem.setResponseTime(resultTime);


        } catch (IOException e) {
            // todo remove stack trace
            e.printStackTrace();
            serverRevisionResultItem.setResponseStatus(ResponseStatus.CRITICAL);
        }

        return serverRevisionResultItem;
    }
}
