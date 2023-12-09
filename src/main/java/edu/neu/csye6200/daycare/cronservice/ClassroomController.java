package edu.neu.csye6200.daycare.cronservice;

import edu.neu.csye6200.daycare.model.ClassRules;
import edu.neu.csye6200.daycare.model.ClassSections;
import edu.neu.csye6200.daycare.model.Student;
import edu.neu.csye6200.daycare.model.Teacher;
import edu.neu.csye6200.daycare.repositories.ClassRulesRepository;
import edu.neu.csye6200.daycare.repositories.ClassroomRepository;
import edu.neu.csye6200.daycare.repositories.TeacherRepository;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ClassroomController {
    private final ClassroomRepository classroomRepository;
    private final ClassRulesRepository classRulesRepository;
    private final TeacherRepository teacherRepository;
    private ClassSections classSections;

    public ClassroomController(ClassroomRepository classroomRepository, ClassRulesRepository classRulesRepository, TeacherRepository teacherRepository) {
        this.classroomRepository = classroomRepository;
        this.classRulesRepository = classRulesRepository;
        this.teacherRepository = teacherRepository;
    }

    public void mapStudentToClass(Student student) {
        try {
            classSections = classroomRepository.findTopByMinAgeBeforeAndMaxAgeAfterOrderByClassRoomId(student.getAge() + 1, student.getAge() - 1);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (classSections == null || classSections.getCurrentCapacity() >= classSections.getMaxCapacity()) {
            ClassRules classRules = classRulesRepository.findTopByMinAgeBeforeAndMaxAgeAfter(student.getAge() + 1, student.getAge() - 1);
            Teacher finalized = teacherRepository.findTopByAssignedClassRoomIdOrderById(0);
            if (finalized == null) {
                System.out.println("No teachers available to assist");
                return;
            }
            classSections = new ClassSections(classRules.getClassId(), classRules.getMinAge(),
                    classRules.getMaxAge(), classRules.getMaxGroupsPerClassRoom() * classRules.getStudentTeacherRation(),
                    classRules.getStudentTeacherRation(), String.format("#%d#", student.getId()),
                    student.getFirstName(), String.format("#%d#", finalized.getId()), finalized.getFirstName());
            classroomRepository.save(classSections);

            Session session = new Configuration()
                    .configure("hibernate.cfg.xml")
                            .buildSessionFactory()
                                    .openSession();
            session.beginTransaction();
            Teacher teacher = session.get(Teacher.class,finalized.getId());
            teacher.setClassroomId(classSections.getClassRoomId());
            session.persist(teacher);
            session.getTransaction().commit();
            //teacherRepository.save(finalized);
            return;
        }
        if (classSections.getCurrentCapacity() % classSections.getGroupSize() != 0) {
            Session session = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory()
                    .openSession();
            session.beginTransaction();
            ClassSections updatedClassSections= session.get(ClassSections.class,classSections.getClassRoomId());
            updatedClassSections.addStudent(student.getId(), student.getFirstName());
            session.persist(updatedClassSections);
            session.getTransaction().commit();
        } else {
            Teacher finalized = teacherRepository.findTopByAssignedClassRoomIdOrderById(0);
            if (finalized == null) {
                System.out.println("No teachers available to assist");
                return;
            }
            Session session = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory()
                    .openSession();
            session.beginTransaction();
            ClassSections updatedClassSections= session.get(ClassSections.class,classSections.getClassRoomId());
            updatedClassSections.addStudent(student.getId(), student.getFirstName(), finalized.getId(), finalized.getFirstName());
            session.persist(updatedClassSections);
            Teacher updatedTeacher = session.get(Teacher.class,finalized.getId());
            updatedTeacher.setClassroomId(classSections.getClassRoomId());
            session.persist(updatedTeacher);
            session.getTransaction().commit();
            //classroomRepository.save(classSections);
            //teacherRepository.save(finalized);
        }
    }
}
