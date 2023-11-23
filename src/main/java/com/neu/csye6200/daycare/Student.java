package com.neu.csye6200.daycare;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Student extends Person{
    private String fatherName;
    private String motherName;
    private String address;
    private String phoneNumber;
    private double gpa;
    private String teacherAssigned;
    private int groupID;
    private int classroomID;

    private List<Immunization> immunizations = new ArrayList<>();

    public Student() {
        // Default constructor
    }

    public Student(String csvData) {
        String[] data = csvData.split(",");
        super.setName(data[0]);
        super.setEmail(data[1]);
        super.setDateOfBirth(LocalDate.parse(data[2]));
        this.fatherName = data[3];
        this.motherName = data[4];
        this.address = data[5];
        this.phoneNumber = data[6];
        this.gpa = Double.parseDouble(data[7]);
        this.teacherAssigned = data[8];
        this.groupID = Integer.parseInt(data[9]);
        this.classroomID = Integer.parseInt(data[10]);
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
