package edu.neu.csye6200.daycare.repositories;


import edu.neu.csye6200.daycare.model.ImmunizationTracker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ImmunizationTrackerRepository {

        private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

        public ImmunizationTracker findTopByStudentId(int studentId) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<ImmunizationTracker> query = entityManager.createQuery(
                    "SELECT i FROM immunizationTracker i WHERE i.studentId = :studentId ORDER BY i.someField DESC",
                    ImmunizationTracker.class);
            query.setParameter("studentId", studentId);
            query.setMaxResults(1);

            ImmunizationTracker result = query.getSingleResult();

            transaction.commit();
            return result;
        }

        public ImmunizationTracker findByStudentId(int studentId) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<ImmunizationTracker> query = entityManager.createQuery(
                    "SELECT i FROM immunizationTracker i WHERE i.studentId = :studentId",
                    ImmunizationTracker.class);
            query.setParameter("studentId", studentId);

            ImmunizationTracker result = query.getSingleResult();

            transaction.commit();
            return result;
        }

        public void closeEntityManager() {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
}


