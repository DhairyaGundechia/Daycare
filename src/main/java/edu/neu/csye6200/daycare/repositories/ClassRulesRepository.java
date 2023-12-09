package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.ClassRules;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

public class ClassRulesRepository {

    public ClassRules findTopByMinAgeBeforeAndMaxAgeAfter(int age1, int age2) {
        Session session = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
       session.beginTransaction();

        TypedQuery<ClassRules> query = session.createQuery(
                "SELECT cr FROM classRules cr WHERE cr.minAge < :age2 AND cr.maxAge > :age1 ORDER BY cr.id DESC",
                ClassRules.class);
        query.setParameter("age1", age1);
        query.setParameter("age2", age2);
        query.setMaxResults(1);

        ClassRules result = query.getSingleResult();

        session.getTransaction().commit();
        return result;
    }
}

