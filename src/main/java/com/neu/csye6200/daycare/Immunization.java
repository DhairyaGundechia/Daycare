package com.neu.csye6200.daycare;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Immunization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vaccineName;
    private LocalDate immunizationDate;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Immunization() {
    }

    public Immunization(String vaccineName, LocalDate immunizationDate, Student student) {
        this.vaccineName = vaccineName;
        this.immunizationDate = immunizationDate;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
    	return student;
    }

    public void setStudent(Student student) {
    	this.student = student;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getImmunizationDate() {
        return immunizationDate;
    }

    public void setImmunizationDate(LocalDate immunizationDate) {
        this.immunizationDate = immunizationDate;
    }
}
