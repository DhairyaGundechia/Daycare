package com.neu.csye6200.daycare;

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
        return null;
    }
}
