package model.config;

import model.checker.ConfigurationManager;
import model.checker.RevisionConfiguration;
import model.checker.ServerRevisionTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("configurationByDataBaseBean")
public class DataBaseConfigurationManager implements ConfigurationManager<RevisionConfiguration> {

    private final static String DB_CONFIG = "hibernate.cfg.xml";
    private SessionFactory sessionFactory;

    @Override
    public RevisionConfiguration getConfiguration() {
        RevisionConfiguration revisionConfiguration = new RevisionConfiguration();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<ServerRevisionTask> serverRevisionTasks = session
                .createQuery("from model.checker.ServerRevisionTask", ServerRevisionTask.class)
                .getResultList();
        session.getTransaction().commit();
        revisionConfiguration.setServerRevisionTaskList(serverRevisionTasks);
        return revisionConfiguration;
    }

    @Override
    public void updateConfiguration(RevisionConfiguration configuration) {

    }

    private SessionFactory initSessionFactory() {
        Configuration configuration = new Configuration().configure(DB_CONFIG);

        configuration.addAnnotatedClass(ServerRevisionTask.class);

        return configuration.buildSessionFactory();
    }
}
