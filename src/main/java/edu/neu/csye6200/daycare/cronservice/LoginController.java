package edu.neu.csye6200.daycare.cronservice;

import edu.neu.csye6200.daycare.model.Person;
import edu.neu.csye6200.daycare.model.Student;
import edu.neu.csye6200.daycare.model.Teacher;
import edu.neu.csye6200.daycare.repositories.StudentRepository;
import edu.neu.csye6200.daycare.repositories.TeacherRepository;
import edu.neu.csye6200.daycare.view.LoginPageLayout;
import edu.neu.csye6200.daycare.view.StudentDashboardLayout;
import edu.neu.csye6200.daycare.view.TeacherDashboardLayout;

import javax.swing.*;

public class LoginController {

    public static void login(String Email, String Password){
        Person currentPerson = null;
        currentPerson = TeacherRepository.getByEmailIdAndPassword(Email, Password);
        if (currentPerson != null) {
            TeacherDashboardLayout teacherDashboardLayout = new TeacherDashboardLayout((Teacher) currentPerson);
            teacherDashboardLayout.setVisible(true);
            return;
        }
        currentPerson = StudentRepository.getByEmailIdAndPassword(Email, Password);
        if (currentPerson != null) {
            StudentDashboardLayout studentDashboardLayout=  new StudentDashboardLayout((Student) currentPerson);
            studentDashboardLayout.setVisible(true);
        }
        if(currentPerson == null){
            System.out.println("Invalid Credentials");
            LoginPageLayout loginPageLayout = LoginPageLayout.getInstance();
            loginPageLayout.setVisible(true);
            JOptionPane.showMessageDialog(new JFrame(), "Invalid UserName/Password", "Error!!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
