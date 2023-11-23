package com.neu.csye6200.daycare;


import java.time.LocalDate;

public class Teacher extends Person{
    private double credits;
    private int groupID;
    private int classroomID;

    public Teacher(){
        // Default constructor
    }

    public Teacher(String csvData) {
        String[] data = csvData.split(",");
        super.setName(data[0]);
        super.setEmail(data[1]);
        super.setDateOfBirth(LocalDate.parse(data[2]));
        this.credits = Double.parseDouble(data[3]);
        this.groupID = Integer.parseInt(data[4]);
        this.classroomID = Integer.parseInt(data[5]);
    }

    public void setCredits(double credits){
        this.credits = credits;
    }

    public void setGroupID(int groupID){
        this.groupID = groupID;
    }

    public void setClassroomID(int classroomID){
        this.classroomID = classroomID;
    }

    public double getCredits(){
        return credits;
    }

    public int getGroupID(){
        return groupID;
    }

    public int getClassroomID(){
        return classroomID;
    }

    @Override
    public String toString() {
        return "Teacher Details: " +
                super.toString() +
                "\n, Credits=" + credits +
                "\n, GroupID=" + groupID +
                "\n, ClassroomID=" + classroomID + '}';
    }
}
