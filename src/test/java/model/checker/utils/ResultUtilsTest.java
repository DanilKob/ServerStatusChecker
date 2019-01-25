package model.checker.utils;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import model.checker.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ResultUtilsTest {

    ResultUtils resultUtils = new ResultUtils();
    RevisionResult revisionResult;

    @Before
    public void init() throws MalformedURLException {
        revisionResult = new RevisionResult();
        ServerRevisionResult serverRevisionResult = new ServerRevisionResult();
        ServerRevisionResultItem revisionResultItem = new ServerRevisionResultItem();
        ServerRevisionTask serverRevisionTask = new ServerRevisionTask();

        serverRevisionTask.setCriticalTimeout(500);
        serverRevisionTask.setUrl(new URL("https://www.tutorialspoint.com/javascript/javascript_placement.htm"));
        serverRevisionTask.setErrorTimeout(700);

        revisionResultItem.setResponseTime(100);
        revisionResultItem.setResponseCode(200);
        revisionResultItem.setResponseStatus(ResponseStatus.OK);
        revisionResultItem.setServerRevisionTask(serverRevisionTask);

        List<ServerRevisionResultItem> serverRevisionResultItemList = new LinkedList<>();

        serverRevisionResultItemList.add(revisionResultItem);
        serverRevisionResultItemList.add(revisionResultItem);

        serverRevisionResult.setServerRevisionResultItemList(serverRevisionResultItemList);

        List<ServerRevisionResult> serverRevisionResultList = new LinkedList<>();

        serverRevisionResultList.add(serverRevisionResult);
        serverRevisionResultList.add(serverRevisionResult);

        revisionResult.setServerRevisionResultList(serverRevisionResultList);
    }

    @Test
    public void adaptToJson() {
        System.out.println(resultUtils.adaptToJson(revisionResult).toJSONString());
        Assert.assertTrue(true);
    }
}