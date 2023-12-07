package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.ImmunizationTracker;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImmunizationTrackerRepository extends JpaRepository<ImmunizationTracker, Integer> {
    ImmunizationTracker findTopByStudentId(int studentId);

    ImmunizationTracker findByStudentId(int studentId);
}
