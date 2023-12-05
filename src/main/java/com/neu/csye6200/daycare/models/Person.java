package com.neu.csye6200.daycare.models;

import javax.persistence.*;
import com.neu.csye6200.daycare.utils.Utils;

@MappedSuperclass
public class Person {
//    private static final AtomicInteger count = new AtomicInteger(10000);
//    private int id;
//    private String Name;
//    private String Email;
//    private LocalDate dateOfBirth; ;

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "emailId", unique = true, nullable = false)
    private String emailId;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "dateOfBirth", nullable = false)
    private String dateOfBirth;
    @Column(name = "parentFullName", nullable = false)
    private String parentFullName;
    @Column(name = "created_on", nullable = false)
    private String createdOn;
    @Column(name = "address")
    private String address;
    @Column(name = "age", nullable = false)
    private int age;

    public Person() {
//        this.id = count.incrementAndGet();
    }

    public Person(String firstName, String lastName, String emailId, String dateOfBirth, String parentFullName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
        this.parentFullName = parentFullName;
        this.address = address;
        this.age = Utils.GET_AGE(dateOfBirth);
    }

    public int getId() {
        return id;
    }

    public String getfirstName() {
        return firstName;
    }
    public String getLastName() { return lastName; }
    public String getEmail() {
        return emailId;
    }
    public String getPassword() { return password; }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getParentFullName() { return parentFullName; }
    public String getCreatedOn() { return createdOn; }
    public String getAddress() { return address; }
    public int getAge() { return age; }
    public void setId(int Id) {
        this.id = Id;
    }
    public void setName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmailId(String emailId) { this.emailId = emailId; }
    public void setPassword(String password) { this.password = password; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setParentFullName(String parentFullName) { this.parentFullName = parentFullName; }
    public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }
    public void setAddress(String address) { this.address = address; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Person Details: " +
                "\nID=" + id +
                "\n, Name=" + firstName + lastName +
                "\n, Email=" + emailId +
                "\n, Date of Birth=" + dateOfBirth;
    }
}
