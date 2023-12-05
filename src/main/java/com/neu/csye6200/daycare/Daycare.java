package com.neu.csye6200.daycare;

import com.neu.csye6200.daycare.factories.ClassroomFactory;
import com.neu.csye6200.daycare.models.Classroom;
import com.neu.csye6200.daycare.models.Student;
import com.neu.csye6200.daycare.models.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Daycare {
    private int classId;
    private int groupId;
    private static List<Classroom> classList = new ArrayList<>();
    private static List<Group> groupList = new ArrayList<>();

    public Daycare() {
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getClassId() {
        return classId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void addGroup(Group g) {
        groupList.add(g);
    }

    public static List<Group> getGroup(){
        return groupList;
    }

    public static void addClassroom(Classroom c) {
        classList.add(c);
    }

    public static List<Classroom> getClassroom(){
        return classList;
    }

    public static void groupMe(){
        List<Student> students;
        List<Teacher> teachers;

        students = FileUtil.getAllStudents();
        teachers = FileUtil.getAllTeachers();

        List<Student> sixToTwelve = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) < 1).collect(Collectors.toList());
        List<Student> thirteenToTwentyFour = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) == 1).collect(Collectors.toList());
        List<Student> twentyFiveToThirtyFive = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) == 2).collect(Collectors.toList());
        List<Student> thirtySixToFortySeven = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) == 3).collect(Collectors.toList());
        List<Student> fortyEightToFiftyNine = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) == 4).collect(Collectors.toList());
        List<Student> sixtyAndUp = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) >= 5).collect(Collectors.toList());

        List<List<Student>> studentAgeGroups = new ArrayList<>();

        studentAgeGroups.add(sixToTwelve);
        studentAgeGroups.add(thirteenToTwentyFour);
        studentAgeGroups.add(twentyFiveToThirtyFive);
        studentAgeGroups.add(thirtySixToFortySeven);
        studentAgeGroups.add(fortyEightToFiftyNine);
        studentAgeGroups.add(sixtyAndUp);

        studentAgeGroups.removeIf(List::isEmpty);

        int flag = 0;
        while(flag < studentAgeGroups.size()) {
            if( flag == 0){
                parseAndAdd(studentAgeGroups.get(flag), 4, 3);
            } else if(flag == 1) {
                parseAndAdd(studentAgeGroups.get(flag), 5, 3);
            } else if(flag == 2) {
                parseAndAdd(studentAgeGroups.get(flag), 6, 3);
            } else if(flag == 3) {
                parseAndAdd(studentAgeGroups.get(flag), 8, 3);
            } else if(flag == 4) {
                parseAndAdd(studentAgeGroups.get(flag), 12, 3);
            } else if(flag == 5) {
                parseAndAdd(studentAgeGroups.get(flag), 15, 3);
            }
            flag = flag + 1;
        }
        parseAddTeacher(teachers, getClassroom());
    }

    public static void parseAndAdd(List<Student> studs, int size, int classSize){
        int numGroups = 0;
        if(studs.size() % size == 0) {
            numGroups = studs.size() / size;
        } else {
            numGroups = (studs.size() / size) + 1;
        }
        List<Group> groups = new ArrayList<>();
        int temp = 0;
        for(int i = 0; i < numGroups; i++) {
            groups.add(GroupFactory.getInstance().getObject());
            for(int j = 0; j < size; j++) {
                if(temp < studs.size()) {
                    groups.get(i).addStudents(studs.get(temp));
                }
            }
            temp = temp + size;
        }

        List<Classroom> classes = new ArrayList<>();
        int tempC = 0;
        int numClassrooms = 0;
        if(groups.size()%classSize == 0) {
            numClassrooms = groups.size()/classSize;

        } else {
            numClassrooms = groups.size()/classSize + 1;
        }

        for(int i = 0; i<numClassrooms; i++) {
            classes.add(ClassroomFactory.getInstance().getObject());
            for(int j = 0; j < classSize; j++) {
                if((tempC+j) < groups.size()) {
                    classes.get(i).addGroups(groups.get(tempC + j));
                }
            }

            tempC = tempC + classSize;
        }

        classes.forEach(Daycare::addClassroom);
    }

    public static void parseAddTeacher(List<Teacher> t, List<Classroom> c) {
        int currTF = 0;
        for(Classroom cl : c) {
            for(Group g : cl.getGroups()) {
                g.assignTeacher(t.get(currTF));
                currTF = currTF + 1;
                if(currTF == t.size()) {
                    currTF = 0;
                }
            }
        }
    }
}
