package model.checker.utils;

import model.checker.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultUtils {
    public JSONObject adaptToJson(RevisionResult revisionResult) {
        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        List<JSONArray> serverResults = revisionResult.getServerRevisionResultList()
                .stream()
                .map(this::serverResultToJson)
                .collect(Collectors.toList());

        jsonArray.addAll(serverResults);
        jsonObject.put(JsonResponseContants.RESULT, jsonArray);
        // todo implement
        return jsonObject;
    }


    private JSONArray serverResultToJson(ServerRevisionResult serverRevisionResult) {
        List<JSONObject> jsonObjects = serverRevisionResult.getServerRevisionResultItemList()
                .stream()
                .map(this::serverResultItemToJson)
                .collect(Collectors.toList());

        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(jsonObjects);
        return jsonArray;
    }

    private JSONObject serverResultItemToJson(ServerRevisionResultItem serverRevisionResultItem) {
        ServerRevisionTask serverRevisionTask = serverRevisionResultItem.getServerRevisionTask();
        String url = serverRevisionTask.getUrl().toString();
        int criticalTimeout = serverRevisionTask.getCriticalTimeout();
        int errorTimeout = serverRevisionTask.getErrorTimeout();

        int responseCode = serverRevisionResultItem.getResponseCode();
        double responseTime = serverRevisionResultItem.getResponseTime();
        String status = serverRevisionResultItem.getResponseStatus().toString();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put(JsonResponseContants.URL, url);
        jsonObject.put(JsonResponseContants.CRITICAL_TIMEOUT, criticalTimeout);
        jsonObject.put(JsonResponseContants.ERROR_TIMEOUT, errorTimeout);
        jsonObject.put(JsonResponseContants.RESPONSE_CODE, responseCode);
        jsonObject.put(JsonResponseContants.RESPONSE_TIME, responseTime);
        jsonObject.put(JsonResponseContants.STATUS, status);

        return jsonObject;
    }
}
