package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Immunization;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

public class ImmunizationRepository {

    public Immunization findByVaccineName(String name) {
        Session session = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
        session.beginTransaction();

        TypedQuery<Immunization> query = session.createQuery(
                "SELECT v FROM immunization v WHERE v.vaccineName = :vaccineName",
                Immunization.class);
        query.setParameter("vaccineName", name);

        Immunization result = query.getSingleResult();

        session.getTransaction().commit();
        return result;
    }
}
