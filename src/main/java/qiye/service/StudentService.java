package qiye.service;

import qiye.entity.Student;
import qiye.util.PageUtil;

import java.util.List;

/**
 * Created by THINKPAD on 2017/9/18.
 */
public interface StudentService {
    PageUtil queryAllStudents(Integer pageNum,Integer pageSize);

    Student queryStudentById(Integer id);

    List<Student> queryStudentByGradeId(Integer gradeId);

    Integer addStudent(Student student);

    Integer deleteStudent(Integer id);

    Integer updateStudent(Student student);

    Integer deleteSomeStudent(List<Integer> list);
}
