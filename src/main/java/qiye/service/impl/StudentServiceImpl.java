package qiye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import qiye.dao.StudentDao;
import qiye.entity.Student;
import qiye.service.StudentService;
import qiye.util.PageUtil;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by THINKPAD on 2017/9/18.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Inject
    private StudentDao studentDao;

    @Override
    public PageUtil queryAllStudents(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentDao.queryAllStudents();
        PageInfo pageInfo = new PageInfo(students);

        return new PageUtil(pageInfo);
    }

    @Override
    public Student queryStudentById(Integer id) {
        return studentDao.queryStudentById(id);
    }

    @Override
    public List<Student> queryStudentByGradeId(Integer gradeId) {
        return studentDao.queryStudentByGradeId(gradeId);
    }

    @Override
    public Integer addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public Integer deleteStudent(Integer id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public Integer updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Integer deleteSomeStudent(List<Integer> list) {
        return studentDao.deleteSomeStudent(list);
    }
}
