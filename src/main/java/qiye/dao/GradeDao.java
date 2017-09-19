package qiye.dao;

import qiye.entity.Grade;

import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public interface GradeDao {

    List<Grade> queryAllGrade();

    Integer addGrade(Grade grade);

    Integer deleteGrade(Integer gradeId);

    Integer updateGrade(Grade grade);

    Grade queryGradeById(Integer gradeId);

    Integer deleteSomeGrades(List<Integer> list);

    
}
