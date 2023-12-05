package com.neu.csye6200.daycare.factories;

import com.neu.csye6200.daycare.models.Person;
import com.neu.csye6200.daycare.models.Teacher;

public class TeacherFactory {
    private static TeacherFactory instance;
    private TeacherFactory() {
        instance = null;
    }
    public static TeacherFactory getInstance() {
        if(instance == null) {
            instance = new TeacherFactory();
        }

        return instance;
    }

    public Person getObject(String csvData) {
        return new Teacher(csvData);
    }
    public Person getObject() {
        return new Teacher();
    }
}
