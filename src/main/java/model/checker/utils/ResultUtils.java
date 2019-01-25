package model.checker.utils;

import model.checker.RevisionResult;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ResultUtils {
    public JSONObject adaptToJson(RevisionResult revisionResult) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        // todo implement
        return jsonObject;
    }
}
