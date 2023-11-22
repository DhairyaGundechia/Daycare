package com.neu.csye6200.daycare;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Teacher extends Person{
    private double credits;
    private int groupID;
    private int classroomID;
    @OneToOne
    @JoinColumn(name = "Id", unique = true)
    private Person person;

    public Teacher(){
        // Default constructor
    }

    public Teacher(double credits, int groupID, int classroomID, Person person){
        this.credits = credits;
        this.groupID = groupID;
        this.classroomID = classroomID;
        this.person = person;
    }

    public void setPerson(Person person){
        this.person = person;
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

    public Person getPerson(){
        return person;
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
