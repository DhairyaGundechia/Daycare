package edu.neu.csye6200.daycare.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EntityManagerUtil {

    public static Session getSession() {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            return sessionFactory.openSession();
        }
    }
}
