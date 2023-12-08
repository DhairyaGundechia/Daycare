package edu.neu.csye6200.daycare.cronservice;

import edu.neu.csye6200.daycare.model.ClassRules;
import edu.neu.csye6200.daycare.model.ClassSections;
import edu.neu.csye6200.daycare.model.Student;
import edu.neu.csye6200.daycare.model.Teacher;
import edu.neu.csye6200.daycare.repositories.ClassRulesRepository;
import edu.neu.csye6200.daycare.repositories.ClassroomRepository;
import edu.neu.csye6200.daycare.repositories.TeacherRepository;

public class ClassroomController {
    private final ClassroomRepository classroomRepository;
    private final ClassRulesRepository classRulesRepository;
    private final TeacherRepository teacherRepository;

    public ClassroomController(ClassroomRepository classroomRepository, ClassRulesRepository classRulesRepository, TeacherRepository teacherRepository) {
        this.classroomRepository = classroomRepository;
        this.classRulesRepository = classRulesRepository;
        this.teacherRepository = teacherRepository;
    }

    public void mapStudentToClass(Student student) {
        ClassSections classSections = classroomRepository.findTopByMinAgeBeforeAndMaxAgeAfterOrderByClassRoomId(student.getAge() + 1, student.getAge() - 1);
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
            finalized.setClassroomId(classSections.getClassRoomId());
            teacherRepository.save(finalized);
            return;
        }
        if (classSections.getCurrentCapacity() % classSections.getGroupSize() != 0) {
            classSections.addStudent(student.getId(), student.getFirstName());
            classroomRepository.save(classSections);
        } else {
            Teacher finalized = teacherRepository.findTopByAssignedClassRoomIdOrderById(0);
            if (finalized == null) {
                System.out.println("No teachers available to assist");
                return;
            }
            classSections.addStudent(student.getId(), student.getFirstName(), finalized.getId(), finalized.getFirstName());
            finalized.setClassroomId(classSections.getClassRoomId());
            classroomRepository.save(classSections);
            teacherRepository.save(finalized);
        }
    }
}
