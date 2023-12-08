package edu.neu.csye6200.daycare.factories;

import edu.neu.csye6200.daycare.model.Person;
import edu.neu.csye6200.daycare.model.Student;
import edu.neu.csye6200.daycare.utils.Utils;


public class StudentFactory extends AbstractPersonFactory {
    private static StudentFactory mInstance;

    private StudentFactory() {
    }

    @Override
    public Person getObject(String firstName, String lastName, String emailId, String dateOfBirth, String parentFullName, String address) {
        return new Student(firstName, lastName, emailId, dateOfBirth, parentFullName, address, 0.0);
    }

    @Override
    public Person getObject() {
        return new Student();
    }

    @Override
    public Person getObject(String line) {
        String[] lines = line.split(",");
        int i = 0;
        Student student = new Student(lines[i++],
                lines[i++],
                lines[i++],
                lines[i++],
                lines[i++],
                lines[i++],
                Utils.parseDouble(lines[i]));
        return student;
    }

    public static StudentFactory getInstance() {
        if (mInstance == null) {
            synchronized (StudentFactory.class) {
                mInstance = new StudentFactory();
            }
        }
        return mInstance;
    }
}
