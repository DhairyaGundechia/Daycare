package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.ClassRules;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ClassRulesRepository {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public ClassRules findTopByMinAgeBeforeAndMaxAgeAfter(int age1, int age2) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<ClassRules> query = entityManager.createQuery(
                "SELECT cr FROM classRules cr WHERE cr.minAge < :age2 AND cr.maxAge > :age1 ORDER BY cr.id DESC",
                ClassRules.class);
        query.setParameter("age1", age1);
        query.setParameter("age2", age2);
        query.setMaxResults(1);

        ClassRules result = query.getSingleResult();

        transaction.commit();
        return result;
    }

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}

