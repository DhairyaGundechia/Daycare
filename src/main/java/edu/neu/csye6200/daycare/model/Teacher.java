package edu.neu.csye6200.daycare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "teacher")
public class Teacher extends Person {
    @Column(name = "credits")
    private int credits;
    @Column(name = "hourlyWage")
    private int hourlyWage;
    @Column(name = "ClassroomId")
    private int classroomId;

    public Teacher(){
        super();
    }

    public Teacher(String firstName, String lastName, String emailId, String dateOfBirth, String parentFullName, String address, int credits, int hourlyWage) {
        super(firstName, lastName, emailId, dateOfBirth, parentFullName, address);
        this.credits = credits;
        this.hourlyWage = hourlyWage;
    }

    public int getCredits(){
        return credits;
    }

    public void setCredits(int credits){
        this.credits = credits;
    }

    public int getHourlyWage(){
        return hourlyWage;
    }

    public void setHourlyWage(int hourlyWage){
        this.hourlyWage = hourlyWage;
    }

    public int getClassroomId(){
        return classroomId;
    }

    public void setClassroomId(int classroomId){
        this.classroomId = classroomId;
    }
}
