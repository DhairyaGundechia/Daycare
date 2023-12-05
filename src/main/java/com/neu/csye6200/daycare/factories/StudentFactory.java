package com.neu.csye6200.daycare.factories;

import com.neu.csye6200.daycare.models.Person;
import com.neu.csye6200.daycare.models.Student;

public class StudentFactory extends PersonFactory {
    private static StudentFactory instance;
    private StudentFactory() {
        instance = null;
    }
    public static StudentFactory getInstance() {
        if(instance == null) {
            instance = new StudentFactory();
        }

        return instance;
    }

    public Person getObject(String csvData) {
        return new Student(csvData);
    }
    @Override
    public Person getObject() {
        return new Student();
    }
}
