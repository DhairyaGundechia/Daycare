package edu.neu.csye6200.daycare;


import edu.neu.csye6200.daycare.model.*;
import edu.neu.csye6200.daycare.view.AddStudentLayout;
import edu.neu.csye6200.daycare.view.AddTeacherLayout;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Driver {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTeacherLayout().setVisible(true);
            }
        });

    }
}

