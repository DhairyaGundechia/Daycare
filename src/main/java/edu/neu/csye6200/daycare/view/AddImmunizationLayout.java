/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.neu.csye6200.daycare.view;

import edu.neu.csye6200.daycare.model.ImmunizationTracker;
import edu.neu.csye6200.daycare.model.Student;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author dhairya
 */
public class AddImmunizationLayout extends javax.swing.JFrame {

    private Student student;
    /**
     * Creates new form AddImmunizationLayout
     */
    public AddImmunizationLayout(Student student) {
        this.student= student;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Immunization Records");

        jLabel2.setText("Hib 1");

        jLabel3.setText("Hib 2");

        jLabel4.setText("Hib 3");

        jLabel5.setText("Hib 4");

        jLabel6.setText("DTaP 1");

        jLabel7.setText("DTaP 2");

        jLabel8.setText("DTaP 3");

        jLabel9.setText("DTaP 4");

        jLabel10.setText("Hepatitis 1");

        jLabel11.setText("Hepatitis 2");

        jLabel12.setText("Hepatitis 3");

        jLabel13.setText("MMR 1");

        jLabel14.setText("Varicella");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jTextField7.setText("jTextField7");

        jTextField8.setText("jTextField8");

        jTextField9.setText("jTextField9");

        jTextField10.setText("jTextField10");

        jTextField11.setText("jTextField11");

        jTextField12.setText("jTextField12");

        jTextField13.setText("jTextField13");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel1)
                        .addGap(0, 263, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField13))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField11))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField12)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Hib1 = jTextField1.getText();
        String Hib2 = jTextField2.getText();
        String Hib3 = jTextField3.getText();
        String Hib4 = jTextField4.getText();
        String DTaP1 = jTextField5.getText();
        String DTaP2 = jTextField6.getText();
        String DTaP3 = jTextField7.getText();
        String DTaP4 = jTextField8.getText();
        String Hepatitis1 = jTextField9.getText();
        String Hepatitis2 = jTextField10.getText();
        String Hepatitis3 = jTextField11.getText();
        String MMR1 = jTextField12.getText();
        String Varicella = jTextField13.getText();

        String immunizationDetails = Hib1 + "," + Hib2 + "," + Hib3 + "," + Hib4 + "," + DTaP1 + "," + DTaP2 + "," + DTaP3 + "," + DTaP4 + "," + Hepatitis1 + "," + Hepatitis2 + "," + Hepatitis3 + "," + MMR1 + "," + Varicella;

        ImmunizationTracker immunizationTracker = new ImmunizationTracker();
        immunizationTracker.setStudentId(student.getId());
        immunizationTracker.setImmunizationDetails(immunizationDetails);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dueDateHib1 = String.format("%02d", LocalDate.parse(Hib1,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(Hib1,formatter).getDayOfMonth()) + "/" + Year.now();
        String dueDateHib2 = String.format("%02d", LocalDate.parse(Hib2,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(Hib2,formatter).getDayOfMonth()) + "/" + Year.now();
        String dueDateHib3 = String.format("%02d", LocalDate.parse(Hib3,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(Hib3,formatter).getDayOfMonth()) + "/" + Year.now();
        String dueDateHib4 = String.format("%02d", LocalDate.parse(Hib4,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(Hib4,formatter).getDayOfMonth()) +"/" + Year.now();
        String dueDateDTaP1 = String.format("%02d", LocalDate.parse(DTaP1,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(DTaP1,formatter).getDayOfMonth())+ "/" + Year.now();
        String dueDateDTaP2 = String.format("%02d", LocalDate.parse(DTaP2,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(DTaP2,formatter).getDayOfMonth()) +"/" + Year.now();
        String dueDateDTaP3 = String.format("%02d", LocalDate.parse(DTaP3,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(DTaP3,formatter).getDayOfMonth()) +"/" + Year.now();
        String dueDateDTaP4 = String.format("%02d", LocalDate.parse(DTaP4,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(DTaP4,formatter).getDayOfMonth())+"/" + Year.now();
        String dueDateHepatitis1 = String.format("%02d", LocalDate.parse(Hepatitis1,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(Hepatitis1,formatter).getDayOfMonth())+ "/" +Year.now();
        String dueDateHepatitis2 = String.format("%02d", LocalDate.parse(Hepatitis2,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(Hepatitis2,formatter).getDayOfMonth()) + "/" +Year.now();
        String dueDateHepatitis3 = String.format("%02d", LocalDate.parse(Hepatitis3,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(Hepatitis3,formatter).getDayOfMonth())+"/" + Year.now();
        String dueDateMMR1 = String.format("%02d", LocalDate.parse(MMR1,formatter).getMonthValue()) + "/" +  String.format("%02d", LocalDate.parse(MMR1,formatter).getDayOfMonth())+ "/" + Year.now();
        String dueDateVaricella = String.format("%02d", LocalDate.parse(Varicella,formatter).getMonthValue()) + "/" + String.format("%02d", LocalDate.parse(Varicella,formatter).getDayOfMonth())+ "/" + Year.now();

        String dueDate = dueDateHib1 + "," + dueDateHib2 + "," + dueDateHib3 + "," + dueDateHib4 + "," + dueDateDTaP1 + "," + dueDateDTaP2 + "," + dueDateDTaP3 + "," + dueDateDTaP4 + "," + dueDateHepatitis1 + "," + dueDateHepatitis2 + "," + dueDateHepatitis3 + "," + dueDateMMR1 + "," + dueDateVaricella;
        immunizationTracker.setUpcomingDueDate(dueDate);

        String dueDateMessageHib1, dueDateMessageHib2, dueDateMessageHib3, dueDateMessageHib4, dueDateMessageDTaP1, dueDateMessageDTaP2, dueDateMessageDTaP3, dueDateMessageDTaP4, dueDateMessageHepatitis1, dueDateMessageHepatitis2, dueDateMessageHepatitis3, dueDateMessageMMR1, dueDateMessageVaricella;
        if(LocalDate.parse(dueDateHib1,formatter).isBefore(LocalDate.now()))
            dueDateMessageHib1 = "Hib1 Vaccine Over Due";
        else
            dueDateMessageHib1 = "Hib1 Vaccine Due on" + dueDateHib1;
        if(LocalDate.parse(dueDateHib2,formatter).isBefore(LocalDate.now()))
            dueDateMessageHib2 = "Hib2 Vaccine Over Due";
        else
            dueDateMessageHib2 = "Hib2 Vaccine Due on" + dueDateHib2;
        if(LocalDate.parse(dueDateHib3,formatter).isBefore(LocalDate.now()))
            dueDateMessageHib3 = "Hib3 Vaccine Over Due";
        else
            dueDateMessageHib3 = "Hib3 Vaccine Due on" + dueDateHib3;
        if(LocalDate.parse(dueDateHib4,formatter).isBefore(LocalDate.now()))
            dueDateMessageHib4 = "Hib4 Vaccine Over Due";
        else
            dueDateMessageHib4 = "Hib4 Vaccine Due on" + dueDateHib4;
        if(LocalDate.parse(dueDateDTaP1,formatter).isBefore(LocalDate.now()))
            dueDateMessageDTaP1 = "DTaP1 Vaccine Over Due";
        else
            dueDateMessageDTaP1 = "DTaP1 Vaccine Due on" + dueDateDTaP1;
        if(LocalDate.parse(dueDateDTaP2,formatter).isBefore(LocalDate.now()))
            dueDateMessageDTaP2 = "DTaP2 Vaccine Over Due";
        else
            dueDateMessageDTaP2 = "DTaP2 Vaccine Due on" + dueDateDTaP2;
        if(LocalDate.parse(dueDateDTaP3,formatter).isBefore(LocalDate.now()))
            dueDateMessageDTaP3 = "DTaP3 Vaccine Over Due";
        else
            dueDateMessageDTaP3 = "DTaP3 Vaccine Due on" + dueDateDTaP3;
        if(LocalDate.parse(dueDateDTaP4,formatter).isBefore(LocalDate.now()))
            dueDateMessageDTaP4 = "DTaP4 Vaccine Over Due";
        else
            dueDateMessageDTaP4 = "DTaP4 Vaccine Due on" + dueDateDTaP4;
        if(LocalDate.parse(dueDateHepatitis1,formatter).isBefore(LocalDate.now()))
            dueDateMessageHepatitis1 = "Hepatitis1 Vaccine Over Due";
        else
            dueDateMessageHepatitis1 = "Hepatitis1 Vaccine Due on" + dueDateHepatitis1;
        if(LocalDate.parse(dueDateHepatitis2,formatter).isBefore(LocalDate.now()))
            dueDateMessageHepatitis2 = "Hepatitis2 Vaccine Over Due";
        else
            dueDateMessageHepatitis2 = "Hepatitis2 Vaccine Due on" + dueDateHepatitis2;
        if(LocalDate.parse(dueDateHepatitis3,formatter).isBefore(LocalDate.now()))
            dueDateMessageHepatitis3 = "Hepatitis3 Vaccine Over Due";
        else
            dueDateMessageHepatitis3 = "Hepatitis3 Vaccine Due on" + dueDateHepatitis3;
        if(LocalDate.parse(dueDateMMR1,formatter).isBefore(LocalDate.now()))
            dueDateMessageMMR1 = "MMR1 Vaccine Over Due";
        else
            dueDateMessageMMR1 = "MMR1 Vaccine Due on" + dueDateMMR1;
        if(LocalDate.parse(dueDateVaricella,formatter).isBefore(LocalDate.now()))
            dueDateMessageVaricella = "Varicella Vaccine Over Due";
        else
            dueDateMessageVaricella = "Varicella Vaccine Due on" + dueDateVaricella;

        String dueDateMessage = dueDateMessageHib1 + "," + dueDateMessageHib2 + "," + dueDateMessageHib3 + "," + dueDateMessageHib4 + "," + dueDateMessageDTaP1 + "," + dueDateMessageDTaP2 + "," + dueDateMessageDTaP3 + "," + dueDateMessageDTaP4 + "," + dueDateMessageHepatitis1 + "," + dueDateMessageHepatitis2 + "," + dueDateMessageHepatitis3 + "," + dueDateMessageMMR1 + "," + dueDateMessageVaricella;
        immunizationTracker.setUpcomingDueDateMessage(dueDateMessage);
        immunizationTracker.setImmunizationDetails(immunizationDetails);
        Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                        .buildSessionFactory()
                                .openSession();
        session.beginTransaction();
        session.persist(immunizationTracker);
        session.getTransaction().commit();

        dispose();
        LandingPageLayout landingPageLayout = new LandingPageLayout();
        landingPageLayout.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
