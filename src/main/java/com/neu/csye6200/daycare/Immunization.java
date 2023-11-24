package com.neu.csye6200.daycare;

import java.time.LocalDate;

public class Immunization {

    private int id;

    private String vaccineName;
    private LocalDate immunizationDate;

    private Student student;

    public Immunization() {
    }

    public Immunization(String vaccineName, LocalDate immunizationDate, Student student) {
        this.vaccineName = vaccineName;
        this.immunizationDate = immunizationDate;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String printImmunization(Student student) {
        return "Immunization{" +
                "vaccineName='" + vaccineName + '\'' +
                ", immunizationDate=" + immunizationDate +
                ", student=" + student +
                '}';
    }
}
