package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Student;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import org.hibernate.cfg.Configuration;

public class StudentRepository {

    public static Student getByEmailIdAndPassword(String emailId, String password) {
        Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
        session.beginTransaction();

        TypedQuery<Student> query = session.createQuery(
                "SELECT s FROM student s WHERE s.emailId = :emailId AND s.password = :password",
                Student.class);
        query.setParameter("emailId", emailId);
        query.setParameter("password", password);

        Student result = query.getSingleResult();

        session.getTransaction().commit();
        return result;
    }
}

