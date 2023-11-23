package com.neu.csye6200.daycare;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addStudent(Student student) {

        String sql = "INSERT INTO student (id, name, email, dateOfBirth, fatherName, motherName, address, phoneNumber, gpa, teacherAssigned, groupID, classroomID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,student.getId(), student.getName(), student.getDateOfBirth(), student.getFatherName(), student.getMotherName(), student.getAddress(), student.getPhoneNumber(), student.getGpa(), student.getTeacherAssigned(), student.getGroupID(), student.getClassroomID());
    }
}

