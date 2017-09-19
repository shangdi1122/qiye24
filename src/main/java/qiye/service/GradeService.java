package qiye.service;

import qiye.entity.Grade;
import qiye.util.PageUtil;

import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public interface GradeService {

    List<Grade> queryAllGrade();

    Integer addGrade(Grade grade);

    Integer deleteGrade(Integer gradeId);

    Integer updateGrade(Grade grade);

    PageUtil queryAllGrade(Integer pageNum, Integer pageSize);

    Grade queryGradeById(Integer gradeId);

    Integer deleteSomeGrades(List<Integer> list);
}
