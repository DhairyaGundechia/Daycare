package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Teacher;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import org.hibernate.cfg.Configuration;

public class TeacherRepository {

    public static Teacher getByEmailIdAndPassword(String emailId, String password) {
        Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
        session.beginTransaction();

        TypedQuery<Teacher> query = session.createQuery(
                "SELECT t FROM teacher t WHERE t.emailId = :emailId AND t.password = :password",
                Teacher.class);
        query.setParameter("emailId", emailId);
        query.setParameter("password", password);

        Teacher result = query.getSingleResult();

        session.getTransaction().commit();
        return result;
    }

    public Teacher findTopByAssignedClassRoomIdOrderById(int assignedClass) {
        Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
        session.beginTransaction();

        TypedQuery<Teacher> query = session.createQuery(
                "SELECT t FROM teacher t WHERE t.classroomId = :assignedClass ORDER BY t.id",
                Teacher.class);
        query.setParameter("assignedClass", assignedClass);
        query.setMaxResults(1);

        Teacher result = query.getSingleResult();

        session.getTransaction().commit();
        return result;
    }

    public void save(Teacher teacher) {
        Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
        session.beginTransaction();
        session.persist(teacher);
        session.getTransaction().commit();
    }
}
