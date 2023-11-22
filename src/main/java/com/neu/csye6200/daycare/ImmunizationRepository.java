package com.neu.csye6200.daycare;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ImmunizationRepository {

    private final JdbcTemplate jdbcTemplate;

    public ImmunizationRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addImmunization(Immunization immunization) {
        String sql = "INSERT INTO immunization (id, vaccineName, immunizationDate, student_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, immunization.getId(), immunization.getVaccineName(), immunization.getImmunizationDate(), immunization.getStudent().getId());
    }
}
