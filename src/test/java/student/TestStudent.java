package student;

import base.TestBase;
import org.junit.Test;
import qiye.entity.Grade;
import qiye.entity.Student;
import qiye.service.StudentService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by THINKPAD on 2017/9/18.
 */
public class TestStudent extends TestBase {

    @Inject
    private StudentService studentService;

    @Test
    public void queryAllStudent() {
        System.out.println(studentService.queryAllStudents(1, 4));
    }

    @Test
    public void queryStudentById() {
        System.out.println(studentService.queryStudentById(160));
    }

    @Test
    public void queryStudentByGradeId() {
        for (Student student : studentService.queryStudentByGradeId(60)) {
            System.out.println(student);
        }
    }

    @Test
    public void addStudent() {
        Grade grade = new Grade();
        grade.setId(98);
        Student student = new Student(null,97,grade,"李煜","女","62322");

        System.out.println(studentService.addStudent(student));
    }

    @Test
    public void updateStudent() {
        Grade grade = new Grade();
        grade.setId(114);
        Student student = new Student(179,65,grade,"李页","女","000022");

        System.out.println(studentService.updateStudent(student));
    }

    @Test
    public void deleteStudent() {
        System.out.println(studentService.deleteStudent(175));
    }

    @Test
    public void deleteSomeStudent() {
        List<Integer> list = new ArrayList<>();
        list.add(176);
        list.add(177);
        System.out.println(studentService.deleteSomeStudent(list));
    }


}
