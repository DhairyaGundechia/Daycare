package edu.neu.csye6200.daycare.repositories;


import edu.neu.csye6200.daycare.model.ImmunizationTracker;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ImmunizationTrackerRepository {

        public ImmunizationTracker findTopByStudentId(int studentId) {
            Session session = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory()
                    .openSession();
            session.beginTransaction();

            TypedQuery<ImmunizationTracker> query = session.createQuery(
                    "SELECT i FROM immunizationTracker i WHERE i.studentId = :studentId ORDER BY i.id DESC",
                    ImmunizationTracker.class);
            query.setParameter("studentId", studentId);
            query.setMaxResults(1);

            ImmunizationTracker result = query.getSingleResult();

            session.getTransaction().commit();
            return result;
        }

        public static ImmunizationTracker findByStudentId(int studentId) {
            Session session = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory()
                    .openSession();
            session.beginTransaction();

            TypedQuery<ImmunizationTracker> query = session.createQuery(
                    "SELECT i FROM immunizationTracker i WHERE i.studentId = :studentId",
                    ImmunizationTracker.class);
            query.setParameter("studentId", studentId);

            ImmunizationTracker result = query.getSingleResult();

            session.getTransaction().commit();
            return result;
        }
}


