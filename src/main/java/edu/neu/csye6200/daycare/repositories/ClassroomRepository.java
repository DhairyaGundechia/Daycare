package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.ClassSections;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClassroomRepository {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public ClassSections findTopByMinAgeBeforeAndMaxAgeAfterOrderByClassRoomId(int age1, int age2) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        ClassSections result = entityManager.createQuery("SELECT c FROM ClassSections c WHERE c.minAge < :age2 AND c.maxAge > :age1 ORDER BY c.classRoomId", ClassSections.class)
                .setParameter("age1", age1)
                .setParameter("age2", age2)
                .setMaxResults(1)
                .getSingleResult();

        transaction.commit();
        return result;
    }

    public ClassSections findTopByStudentIdsContaining(String studentId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        ClassSections result = entityManager.createQuery("SELECT c FROM ClassSections c WHERE :studentId MEMBER OF c.studentIds", ClassSections.class)
                .setParameter("studentId", studentId)
                .setMaxResults(1)
                .getSingleResult();

        transaction.commit();
        return result;
    }

    // Add other methods as needed

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
