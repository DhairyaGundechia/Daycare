package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.ClassSections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassroomRepository extends JpaRepository<ClassSections, Integer> {

    ClassSections findTopByMinAgeBeforeAndMaxAgeAfterOrderByClassRoomId(int age1, int age2);

    ClassSections findTopByStudentIdsContaining(String studentId);
}
