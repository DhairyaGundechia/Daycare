package com.neu.csye6200.daycare;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/daycare";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "csye6200";

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                LocalDate dob = rs.getDate("dateOfBirth").toLocalDate();
                String fatherName = rs.getString("fatherName");
                String motherName = rs.getString("motherName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                double gpa = rs.getDouble("gpa");
                String teacherAssigned = rs.getString("teacherAssigned");
                int groupId = rs.getInt("groupId");
                int classroomId = rs.getInt("classroomId");
                String csvData = String.valueOf(id) + "," + name + "," + email + "," + String.valueOf(dob) + "," + fatherName + "," + motherName + "," + address + "," + phoneNumber + "," + String.valueOf(gpa) + "," + teacherAssigned + "," + String.valueOf(groupId) + "," + String.valueOf(classroomId); 
                Student student = new Student(csvData);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM teachers")) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                LocalDate dob = rs.getDate("dateOfBirth").toLocalDate();
                double credits = rs.getDouble("credits");
                int groupId = rs.getInt("groupId");
                int classroomId = rs.getInt("classroomId");
                String csvData = String.valueOf(id) + "," + name + "," + email + "," + String.valueOf(dob) + "," + String.valueOf(credits) + "," + String.valueOf(groupId) + "," + String.valueOf(classroomId);
                Teacher teacher = new Teacher(csvData);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teachers;
    }
}
