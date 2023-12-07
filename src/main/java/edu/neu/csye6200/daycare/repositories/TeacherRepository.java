package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher getByEmailIdAndPassword(String emailId, String password);

    Teacher findTopByAssignedClassRoomIdOrderById(int assignedClass);
}
