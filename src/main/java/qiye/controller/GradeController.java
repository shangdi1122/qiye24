package qiye.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qiye.entity.Grade;
import qiye.service.GradeService;
import qiye.util.Message;
import qiye.util.PageUtil;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
@Controller
@RequestMapping(value = "grade",produces = "application/json;charset=utf-8")
public class GradeController {

    @Inject
    private GradeService gradeService;

    @GetMapping(value = "toGrade")
    public String toGrade() {
        return "grade/grade";
    }

    @GetMapping(value ="queryAllGrade" )
    @ResponseBody
    public String queryAllGrade(Integer page, Integer rows) {
        PageUtil pageUtil = gradeService.queryAllGrade(page, rows);
        return JSON.toJSONString(pageUtil);
    }

    @PostMapping(value = "addGrade")
    @ResponseBody
    public String addGrade(Grade grade) {
        Integer n = gradeService.addGrade(grade);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @PostMapping(value = "updateGrade")
    @ResponseBody
    public String updateGrade(Grade grade) {
        Integer n = gradeService.updateGrade(grade);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }


    @GetMapping(value = "queryGradeById")
    @ResponseBody
    public String queryGradeById(Integer gradeId) {
        Grade grade = gradeService.queryGradeById(gradeId);
        return JSON.toJSONStringWithDateFormat(grade,"yyyy-MM-dd");
    }

    @GetMapping(value = "deleteGradeById")
    @ResponseBody
    public String deleteGrade(Integer gradeId) {
        Integer n = gradeService.deleteGrade(gradeId);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @GetMapping(value = "deleteSomeGrade")
    @ResponseBody
    public String deleteSomeGrade(String strIds) {
        List<Integer> list = JSON.parseArray(strIds, Integer.class);
        Integer n = gradeService.deleteSomeGrades(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }


    @GetMapping(value = "queryAllGrades")
    @ResponseBody
    public String queryAllGrade1() {
        Grade grade = new Grade();
        grade.setGradeName("--请选择--");
        List<Grade> grades = gradeService.queryAllGrade();
        return JSON.toJSONString(grades);
    }
}
