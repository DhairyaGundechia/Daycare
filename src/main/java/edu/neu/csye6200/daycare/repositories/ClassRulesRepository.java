package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.ClassRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRulesRepository extends JpaRepository<ClassRules, Integer> {
    ClassRules findTopByMinAgeBeforeAndMaxAgeAfter(int age1, int age2);
}
