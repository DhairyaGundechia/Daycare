package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student getByEmailIdAndPassword(String emailId, String password);
}

