package edu.neu.csye6200.daycare;


import edu.neu.csye6200.daycare.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Driver {

    public static void main(String[] args) {
      //  ConfigurableApplicationContext context = new SpringApplicationBuilder(Driver.class).headless(false).run(args);
        Configuration configuration = new Configuration();
        try {
            configuration.configure("hibernate.cfg.xml");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        configuration.addAnnotatedClass(ClassRules.class);

        SessionFactory sessionFactory
                = null;
        try {
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        session.beginTransaction();

        session.getTransaction().commit();
        session.close();
    }
}
