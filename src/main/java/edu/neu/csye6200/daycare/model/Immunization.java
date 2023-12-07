package edu.neu.csye6200.daycare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "immunization")
public class Immunization {

    @Id
    @GeneratedValue
    @Column(name = "vaccine_id")
    private int vaccineId;
    @Column(name = "vaccine_name")
    private String vaccineName;
    @Column(name = "no_of_doses")
    private int noOfDoses;


    public Immunization() {
    }

    public Immunization(String vaccineName, int noOfDoses) {
        this.vaccineName = vaccineName;
        this.noOfDoses = noOfDoses;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public int getNoOfDoses() {
        return noOfDoses;
    }

    public void setNoOfDoses(int noOfDoses) {
        this.noOfDoses = noOfDoses;
    }
}
