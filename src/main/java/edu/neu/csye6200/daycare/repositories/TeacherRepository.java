package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class TeacherRepository {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public Teacher getByEmailIdAndPassword(String emailId, String password) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Teacher> query = entityManager.createQuery(
                "SELECT t FROM teacher t WHERE t.emailId = :emailId AND t.password = :password",
                Teacher.class);
        query.setParameter("emailId", emailId);
        query.setParameter("password", password);

        Teacher result = query.getSingleResult();

        transaction.commit();
        return result;
    }

    public Teacher findTopByAssignedClassRoomIdOrderById(int assignedClass) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Teacher> query = entityManager.createQuery(
                "SELECT t FROM teacher t WHERE t.assignedClassRoomId = :assignedClass ORDER BY t.id",
                Teacher.class);
        query.setParameter("assignedClass", assignedClass);
        query.setMaxResults(1);

        Teacher result = query.getSingleResult();

        transaction.commit();
        return result;
    }

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
