package com.neu.csye6200.daycare;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Student extends Person{
    private String fatherName;
    private String motherName;
    private String address;
    private String phoneNumber;
    private double gpa;
    private String teacherAssigned;
    private int groupID;
    private int classroomID;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Immunization> immunizations = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "Id", unique = true)
    private Person person;

    public Student() {
        // Default constructor
    }

    public Student(String fatherName, String motherName, String address, String phoneNumber,
                   double gpa, String teacherAssigned, int groupID, int classroomID,
                   Person person) {
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gpa = gpa;
        this.teacherAssigned = teacherAssigned;
        this.groupID = groupID;
        this.classroomID = classroomID;
        this.person = person;
    }

    public void setFatherName(String fatherName){
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName){
        this.motherName = motherName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setGPA(double GPA){
        this.gpa = GPA;
    }

    public void setTeacherAssigned(String teacherAssigned){
        this.teacherAssigned = teacherAssigned;
    }

    public void setGroupID(int groupID){
        this.groupID = groupID;
    }

    public void setClassroomID(int classroomID){
        this.classroomID = classroomID;
    }

    public String getFatherName(){
        return fatherName;
    }

    public String getMotherName(){
        return motherName;
    }

    public String getAddress(){
        return address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public double getGpa(){
        return gpa;
    }

    public String getTeacherAssigned(){
        return teacherAssigned;
    }

    public int getGroupID(){
        return groupID;
    }

    public int getClassroomID(){
        return classroomID;
    }

    public void addImmunization(Immunization immunization) {
        immunizations.add(immunization);
        immunization.setStudent(this);
    }

    public void removeImmunization(Immunization immunization) {
        immunizations.remove(immunization);
        immunization.setStudent(null);
    }

    public List<Immunization> getImmunizations() {
        return immunizations;
    }

    @Override
    public String toString(){
        return "Student Details: " +
                super.toString() +
                "\nFather Name: " + fatherName +
                "\nMother Name: " + motherName +
                "\nAddress: " + address +
                "\nPhone Number: " + phoneNumber +
                "\nGPA: " + gpa +
                "\nTeacher Assigned: " + teacherAssigned +
                "\nGroup ID: " + groupID +
                "\nClassroom ID: " + classroomID;
    }
}
