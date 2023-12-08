package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class StudentRepository {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public Student getByEmailIdAndPassword(String emailId, String password) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM student s WHERE s.emailId = :emailId AND s.password = :password",
                Student.class);
        query.setParameter("emailId", emailId);
        query.setParameter("password", password);

        Student result = query.getSingleResult();

        transaction.commit();
        return result;
    }

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}

