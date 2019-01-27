package model.checker.impl;

import model.checker.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalExaminerAgent implements ExaminerAgent {

    private static final String GET_REQUEST_METHOD = "GET";
    private ExaminerAgentConfiguration examinerAgentConfiguration;

    @Override
    public void setExaminerAgentConfiguration(ExaminerAgentConfiguration examinerAgentConfiguration) {
        this.examinerAgentConfiguration = examinerAgentConfiguration;
    }

    @Override
    public ExaminerAgentConfiguration getExaminerAgentConfiguration() {
        return examinerAgentConfiguration;
    }

    @Override
    public StatusCheckFromAgentResult checkServers(StatusCheckConfiguration statusCheckConfiguration) {
        StatusCheckFromAgentResult statusCheckFromAgentResult = new StatusCheckFromAgentResult();
        // todo implement by Future
        List<StatusCheckTask> statusCheckTaskList = statusCheckConfiguration.getStatusCheckTaskList();
        List<StatusCheckResultItem> statusCheckResultItemList = statusCheckTaskList
                .stream()
                .parallel()
                .map(this::ping)
                .collect(Collectors.toList());

        statusCheckFromAgentResult.setStatusCheckResultItemList(statusCheckResultItemList);
        statusCheckFromAgentResult.setExaminerAgentConfiguration(this.examinerAgentConfiguration);

        return statusCheckFromAgentResult;
    }

    private StatusCheckResultItem ping(StatusCheckTask statusCheckTask) {
        StatusCheckResultItem statusCheckResultItem = new StatusCheckResultItem();
        statusCheckResultItem.setStatusCheckTask(statusCheckTask);

        int criticalTimeout = statusCheckTask.getCriticalTimeout();
        URL url = statusCheckTask.getUrl();
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(criticalTimeout);
            httpURLConnection.setRequestMethod(GET_REQUEST_METHOD);

            long startTime;
            long finishTime;
            double resultTime;

            startTime = System.nanoTime();
            httpURLConnection.connect();
            finishTime = System.nanoTime();

            resultTime = ((finishTime - startTime) / 1000.0 /1000.0); // nano to milli

            int responseCode = httpURLConnection.getResponseCode();
            statusCheckResultItem.setResponseCode(responseCode);
            statusCheckResultItem.setResponseTime(resultTime);

            if (resultTime < criticalTimeout) {
                statusCheckResultItem.setResponseStatus(ResponseStatus.OK);
            } else {
                statusCheckResultItem.setResponseStatus(ResponseStatus.WARNING);
            }


        } catch (IOException e) {
            // todo remove stack trace
            e.printStackTrace();
            statusCheckResultItem.setResponseStatus(ResponseStatus.CRITICAL);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return statusCheckResultItem;
    }
}
