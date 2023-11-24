package com.neu.csye6200.daycare;

//@SpringBootApplication
public class Driver {

    public static void main(String[] args) {
        //SpringApplication.run(Driver.class, args);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
}
