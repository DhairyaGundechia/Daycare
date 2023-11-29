package com.neu.csye6200.daycare;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/daycare";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "csye6200";

    public static void saveStudent(Student student) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO student (registrationDate, id, name, email, dateOfBirth, fatherName, motherName, address, phoneNumber, gpa, teacherAssigned, groupId, classroomId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setDate(1, Date.valueOf(student.getRegistrationDate()));
            stmt.setInt(2, student.getId());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getEmail());
            stmt.setDate(5, Date.valueOf(student.getDateOfBirth()));
            stmt.setString(6, student.getFatherName());
            stmt.setString(7, student.getMotherName());
            stmt.setString(8, student.getAddress());
            stmt.setString(9, student.getPhoneNumber());
            stmt.setDouble(10, student.getGpa());
            stmt.setString(11, student.getTeacherAssigned());
            stmt.setInt(12, student.getGroupID());
            stmt.setInt(13, student.getClassroomID());

            stmt.executeUpdate();
            System.out.println("Student saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {

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

    public static void saveTeacher(Teacher teacher) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO teacher (id, name, email, dateOfBirth, credits, groupId, classroomId) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setInt(1, teacher.getId());
            stmt.setString(2, teacher.getName());
            stmt.setString(3, teacher.getEmail());
            stmt.setDate(4, Date.valueOf(teacher.getDateOfBirth()));
            stmt.setDouble(5, teacher.getCredits());
            stmt.setInt(6, teacher.getGroupID());
            stmt.setInt(7, teacher.getClassroomID());

            stmt.executeUpdate();
            System.out.println("Teacher saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM teacher")) {

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

    public static void saveImmunizationUnder5(Immunization immunization) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO immunization (id, hib, hibDate, dtap, dtapDate, polio, polioDate, hepatitisB, hepatitisBDate, mmr, mmrDate, varicella, varicellaDate, tdap, tdapDate, meningococcal, meningococcalDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setInt(1, immunization.getId());
            stmt.setInt(2, immunization.getHib());
            stmt.setDate(3, Date.valueOf(immunization.getHibDate()));
            stmt.setInt(4, immunization.getDtap());
            stmt.setDate(5, Date.valueOf(immunization.getDtapDate()));
            stmt.setInt(6, immunization.getPolio());
            stmt.setDate(7, Date.valueOf(immunization.getPolioDate()));
            stmt.setInt(8, immunization.getHepatitisB());
            stmt.setDate(9, Date.valueOf(immunization.getHepatitisBDate()));
            stmt.setInt(10, immunization.getMmr());
            stmt.setDate(11, Date.valueOf(immunization.getMmrDate()));
            stmt.setInt(12, immunization.getVaricella());
            stmt.setDate(13, Date.valueOf(immunization.getVaricellaDate()));
            stmt.setInt(14, 0);
            stmt.setDate(15, null);
            stmt.setInt(16, 0);
            stmt.setDate(17, null);

            stmt.executeUpdate();
            System.out.println("Immunization saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveImmunizationUnder12(Immunization immunization) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO immunization (id, hib, hibDate, dtap, dtapDate, polio, polioDate, hepatitisB, hepatitisBDate, mmr, mmrDate, varicella, varicellaDate, tdap, tdapDate, meningococcal, meningococcalDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setInt(1, immunization.getId());
            stmt.setInt(2, 0);
            stmt.setDate(3, null);
            stmt.setInt(4, immunization.getDtap());
            stmt.setDate(5, Date.valueOf(immunization.getDtapDate()));
            stmt.setInt(6, immunization.getPolio());
            stmt.setDate(7, Date.valueOf(immunization.getPolioDate()));
            stmt.setInt(8, immunization.getHepatitisB());
            stmt.setDate(9, Date.valueOf(immunization.getHepatitisBDate()));
            stmt.setInt(10, immunization.getMmr());
            stmt.setDate(11, Date.valueOf(immunization.getMmrDate()));
            stmt.setInt(12, immunization.getVaricella());
            stmt.setDate(13, Date.valueOf(immunization.getVaricellaDate()));
            stmt.setInt(14, 0);
            stmt.setDate(15, null);
            stmt.setInt(16, 0);
            stmt.setDate(17, null);

            stmt.executeUpdate();
            System.out.println("Immunization saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveImmunization(Immunization immunization) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO immunization (id, hib, hibDate, dtap, dtapDate, polio, polioDate, hepatitisB, hepatitisBDate, mmr, mmrDate, varicella, varicellaDate, tdap, tdapDate, meningococcal, meningococcalDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setInt(1, immunization.getId());
            stmt.setInt(2, 0);
            stmt.setDate(3, null);
            stmt.setInt(4, 0);
            stmt.setDate(5, null);
            stmt.setInt(6, immunization.getPolio());
            stmt.setDate(7, Date.valueOf(immunization.getPolioDate()));
            stmt.setInt(8, immunization.getHepatitisB());
            stmt.setDate(9, Date.valueOf(immunization.getHepatitisBDate()));
            stmt.setInt(10, immunization.getMmr());
            stmt.setDate(11, Date.valueOf(immunization.getMmrDate()));
            stmt.setInt(12, immunization.getVaricella());
            stmt.setDate(13, Date.valueOf(immunization.getVaricellaDate()));
            stmt.setInt(14, immunization.getTdap());
            stmt.setDate(15, Date.valueOf(immunization.getTdapDate()));
            stmt.setInt(16, immunization.getMeningococcal());
            stmt.setDate(17, Date.valueOf(immunization.getMeningococcalDate()));

            stmt.executeUpdate();
            System.out.println("Immunization saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
