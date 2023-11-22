package com.neu.csye6200.daycare;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TeacherRepository {

    private final JdbcTemplate jdbcTemplate;

    public TeacherRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addTeacher(Teacher teacher) {
        String sql1 = "INSERT INTO person (id, name, email, dateOfBirth) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO teacher (id, credits, groupID, classroomID) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql1, teacher.getId(),teacher.getName(), teacher.getEmail(), teacher.getDateOfBirth());
        jdbcTemplate.update(sql2, teacher.getId(), teacher.getCredits(), teacher.getGroupID(), teacher.getClassroomID());
    }
}
