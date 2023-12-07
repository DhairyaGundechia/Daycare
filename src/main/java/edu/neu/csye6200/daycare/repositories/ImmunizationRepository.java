package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Immunization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmunizationRepository extends JpaRepository<Immunization, Integer> {
    Immunization findByVaccineName(String name);
}
