package model.config;

import model.checker.ConfigurationManager;
import model.checker.RevisionConfiguration;
import model.checker.ServerRevisionTask;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Repository("ConfigurationByJavaBean")
public class JavaClassConfigurationManager implements ConfigurationManager<RevisionConfiguration> {

    private RevisionConfiguration revisionConfiguration = initRevisionConfiguration();

    @Override
    public RevisionConfiguration getConfiguration() {
        return this.revisionConfiguration;
    }

    @Override
    public void updateConfiguration(RevisionConfiguration configuration) {

    }

    private RevisionConfiguration initRevisionConfiguration() {
        RevisionConfiguration revisionConfiguration = new RevisionConfiguration();
        List<ServerRevisionTask> serverRevisionTaskList = new LinkedList<>();
        ServerRevisionTask serverRevisionTask = new ServerRevisionTask();

        try {
            serverRevisionTask.setCriticalTimeout(500);
            serverRevisionTask.setUrl(new URL("https://www.tutorialspoint.com/javascript/javascript_placement.htm"));
            serverRevisionTask.setErrorTimeout(700);


            serverRevisionTaskList.add(serverRevisionTask);
            serverRevisionTaskList.add(serverRevisionTask);

            revisionConfiguration.setServerRevisionTaskList(serverRevisionTaskList);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("List from config" + revisionConfiguration.getServerRevisionTaskList());
        return revisionConfiguration;
    }
}
