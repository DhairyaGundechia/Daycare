package com.neu.csye6200.daycare;


import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;


public class Person {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String Name;
    private String Email;
    private LocalDate dateOfBirth; ;

    public Person() {
        this.id = count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setId(int Id) {
        this.id = Id;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person Details: " +
                "\nID=" + id +
                "\n, Name=" + Name +
                "\n, Email=" + Email +
                "\n, Date of Birth=" + dateOfBirth;
    }
}
