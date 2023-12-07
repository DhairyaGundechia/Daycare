package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Immunization;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ImmunizationRepository {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public Immunization findByVaccineName(String name) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Immunization> query = entityManager.createQuery(
                "SELECT v FROM immunization v WHERE v.vaccineName = :vaccineName",
                Immunization.class);
        query.setParameter("vaccineName", name);

        Immunization result = query.getSingleResult();

        transaction.commit();
        return result;
    }

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
