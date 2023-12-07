package edu.neu.csye6200.daycare;


import edu.neu.csye6200.daycare.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



//@SpringBootApplication
public class Driver {

    public static void main(String[] args) {
      //  ConfigurableApplicationContext context = new SpringApplicationBuilder(Driver.class).headless(false).run(args);
        Configuration configuration = new Configuration();
        try {
            configuration.configure("hibernate.cfg.xml");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory
                = null;
        try {
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setAge(5);
        student.setParentFullName("John Doe Sr.");
        student.setEmailId("abc@gmail.com");
        student.setDateOfBirth("01/01/2016");
        student.setAddress("123, Main Street, Boston, MA");
        student.setCreatedOn("01/01/2021");
        student.setGpa(3.5);
        student.setPassword("123456");

        session.beginTransaction();

        session.save(student);

        session.getTransaction().commit();
        session.close();
    }
}
