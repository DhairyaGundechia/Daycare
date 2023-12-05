package com.neu.csye6200.daycare;

import com.neu.csye6200.daycare.models.Student;
import com.neu.csye6200.daycare.models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Teacher teacher;
    private int groupSize;
    private int id=0;
    private final List<Student> students = new ArrayList<>();

    public Group() {
        id += 1;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return this.groupSize;
    }

    public void addStudents(Student s) {
        students.add(s);
    }

    public void assignTeacher(Teacher t) {
        teacher = t;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getId() {
    	return this.id;
    }




    @Override
    public String toString() {
        return teacher.getName();
    }
}
