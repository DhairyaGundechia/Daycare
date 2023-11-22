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
        // Insert into person table
        String sql1 = "INSERT INTO person (Id,name, email, dateOfBirth) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql1,student.getId(), student.getName(), student.getEmail(), student.getDateOfBirth());

        String sql2 = "INSERT INTO student (Id, fatherName, motherName, address, phoneNumber, gpa, teacherAssigned, groupID, classroomID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql2,student.getId(), student.getFatherName(), student.getMotherName(), student.getAddress(), student.getPhoneNumber(), student.getGpa(), student.getTeacherAssigned(), student.getGroupID(), student.getClassroomID());
    }
}

