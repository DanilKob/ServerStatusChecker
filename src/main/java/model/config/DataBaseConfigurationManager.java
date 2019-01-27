package model.config;

import model.checker.ConfigurationManager;
import model.checker.StatusCheckConfiguration;
import model.checker.StatusCheckTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DataBaseConfigurationManager implements ConfigurationManager<StatusCheckConfiguration> {

    private final static String DB_CONFIG = "hibernate.cfg.xml";
    private SessionFactory sessionFactory = this.initSessionFactory();

    @Override
    public StatusCheckConfiguration getConfiguration() {
        StatusCheckConfiguration statusCheckConfiguration = new StatusCheckConfiguration();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<StatusCheckTask> statusCheckTasks = session
                .createQuery("from model.checker.StatusCheckTask", StatusCheckTask.class)
                .getResultList();
        session.getTransaction().commit();
        statusCheckConfiguration.setStatusCheckTaskList(statusCheckTasks);
        return statusCheckConfiguration;
    }

    @Override
    public void updateConfiguration(StatusCheckConfiguration configuration) {

    }

    private SessionFactory initSessionFactory() {
        Configuration configuration = new Configuration().configure(DB_CONFIG);

        configuration.addAnnotatedClass(StatusCheckTask.class);

        return configuration.buildSessionFactory();
    }
}
