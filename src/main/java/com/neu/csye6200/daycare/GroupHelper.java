package com.neu.csye6200.daycare;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class GroupHelper {

    static int currentTeacherIndexFlag = 0;
    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();

    public static void groupMe() {

        students.clear();
        teachers.clear();
        students = FileUtil.getAllStudents();
        teachers = FileUtil.getAllTeachers();

        List<Student> sixToTwelve = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) < 1).collect(Collectors.toList());
        List<Student> thirteenToTwentyfour = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) == 1).collect(Collectors.toList());
        List<Student> twentyfiveToThirtyFive = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) == 2).collect(Collectors.toList());
        List<Student> thirtySixToFortySeven = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) == 3).collect(Collectors.toList());
        List<Student> fortyEightToFiftyNine = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) == 4).collect(Collectors.toList());
        List<Student> sixtyAndUp = students.stream().filter(student -> (student.getDateOfBirth().getYear() - LocalDate.now().getYear()) >= 5).collect(Collectors.toList());

        List<List<Student>> studentAgeGroups = new ArrayList<>();

        studentAgeGroups.add(sixToTwelve);
        studentAgeGroups.add(thirteenToTwentyfour);
        studentAgeGroups.add(twentyfiveToThirtyFive);
        studentAgeGroups.add(thirtySixToFortySeven);
        studentAgeGroups.add(fortyEightToFiftyNine);
        studentAgeGroups.add(sixtyAndUp);

        ListIterator<List<Student>> li = studentAgeGroups.listIterator();
        while(li.hasNext()) {
            List<Student> s = li.next();
            if(s.size() == 0) {
                li.remove();
            }
        }

        for(List<Student> s : studentAgeGroups) {
            System.out.println(s);
        }

        int flag = 0;
        while(flag < studentAgeGroups.size()) {
            if( flag == 0){
                System.out.println("Calling 0");
                parseAndAdd(studentAgeGroups.get(flag), 4, 3);
            } else if(flag == 1) {
                System.out.println("Calling 1");
                parseAndAdd(studentAgeGroups.get(flag), 5, 3);
            } else if(flag == 2) {
                System.out.println("Calling 2");
                parseAndAdd(studentAgeGroups.get(flag), 6, 3);
            } else if(flag == 3) {
                System.out.println("Calling 3");
                parseAndAdd(studentAgeGroups.get(flag), 8, 3);
            } else if(flag == 4) {
                System.out.println("Calling 4");
                parseAndAdd(studentAgeGroups.get(flag), 12, 3);
            } else if(flag == 5) {
                System.out.println("Calling 5");
                parseAndAdd(studentAgeGroups.get(flag), 15, 3);
            }
            flag = flag + 1;
        }
        parseAddTeacher(teachers, Daycare.getClassroom());
    }

    public static void parseAndAdd(List<Student> studs, int size, int classSize){
        System.out.println("parseAndAdd");
        System.out.println(studs);
        System.out.println(size);
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

        System.out.println("number of classrooms");
        System.out.println(groups.size());
        System.out.println(numClassrooms);
        for(int i = 0; i<numClassrooms; i++) {
            classes.add(ClassroomFactory.getInstance().getObject());
            for(int j = 0; j < classSize; j++) {
                if((tempC+j) < groups.size()) {
                    classes.get(i).addGroups(groups.get(tempC + j));
                }
            }

            tempC = tempC + classSize;
        }

        classes.forEach(c -> Daycare.addClassroom(c));

    }

    public static void parseAddTeacher(List<Teacher> t, List<Classroom> c) {
        int currTF = 0;
        for(Classroom cl : c) {
            for(Group g : cl.getGroups()) {
                g.assignTeacher(t.get(currTF));
                System.out.println("i am  in parseaddteacher");
                System.out.println(g);
                System.out.println(t.get(currTF));
                currTF = currTF + 1;
                if(currTF == t.size()) {
                    currTF = 0;
                }
            }
        }

    }
}
