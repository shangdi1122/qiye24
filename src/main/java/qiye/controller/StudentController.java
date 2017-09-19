package qiye.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qiye.entity.Student;
import qiye.service.StudentService;
import qiye.util.Message;
import qiye.util.PageUtil;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by THINKPAD on 2017/9/18.
 */
@Controller
@RequestMapping(value = "student",produces = "application/json;charset=utf-8")
public class StudentController {

    @Inject
    private StudentService studentService;

    @GetMapping(value = "toStudent")
    public String toStudent() {
        return "student/student";
    }

    @GetMapping(value = "queryAllStudents")
    @ResponseBody
    public String queryAllStudent(Integer page, Integer rows) {
        PageUtil pageUtil = studentService.queryAllStudents(page, rows);
        return JSON.toJSONString(pageUtil);
    }

    @GetMapping(value = "queryStudentById")
    @ResponseBody
    public String queryStudentById(Integer id) {
        Student student = studentService.queryStudentById(id);
        return JSON.toJSONString(student);
    }

    @PostMapping(value = "addStudent")
    @ResponseBody
    public String addStudent(Student student) {
        Integer n = studentService.addStudent(student);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @RequestMapping(value = "updateStudentController",method = RequestMethod.POST)
    @ResponseBody
    public String updateStudent(Student student) {
        Integer n = studentService.updateStudent(student);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());

    }

    @GetMapping(value = "deleteStudent")
    @ResponseBody
    public String deleteStudent(Integer id) {
        Integer n = studentService.deleteStudent(id);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @GetMapping(value = "deleteSomeStudent")
    @ResponseBody
    public String deleteSomeStudent(String strIds) {
        List<Integer> list = JSON.parseArray(strIds, Integer.class);
        Integer n = studentService.deleteSomeStudent(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @GetMapping(value = "queryStudentByGradeId")
    @ResponseBody
    public String queryStudentByGradeId(Integer gradeId) {
        List<Student> students = studentService.queryStudentByGradeId(gradeId);
        return JSON.toJSONString(students);
    }
}
