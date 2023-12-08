package edu.neu.csye6200.daycare;


import edu.neu.csye6200.daycare.view.LandingPageLayout;
import edu.neu.csye6200.daycare.view.TeacherDashboardLayout;


public class Driver {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LandingPageLayout().setVisible(true));
    }
}

