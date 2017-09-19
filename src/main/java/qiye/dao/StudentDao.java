package qiye.dao;

import qiye.entity.Student;

import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public interface StudentDao {
    List<Student> queryAllStudents();

    Student queryStudentById(Integer id);

    List<Student> queryStudentByGradeId(Integer gradeId);

    Integer addStudent(Student student);

    Integer deleteStudent(Integer id);

    Integer updateStudent(Student student);

    Integer deleteSomeStudent(List<Integer> list);
}
