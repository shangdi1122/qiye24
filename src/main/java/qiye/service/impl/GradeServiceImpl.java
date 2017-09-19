package qiye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import qiye.dao.GradeDao;
import qiye.entity.Grade;
import qiye.service.GradeService;
import qiye.util.PageUtil;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Inject
    private GradeDao gradeDao;
    
    public List<Grade> queryAllGrade() {
        return gradeDao.queryAllGrade();
    }

    
    public Integer addGrade(Grade grade) {
        return gradeDao.addGrade(grade);
    }

    
    public Integer deleteGrade(Integer gradeId) {
        return gradeDao.deleteGrade(gradeId);
    }

    
    public Integer updateGrade(Grade grade) {
        return gradeDao.updateGrade(grade);
    }

    
    public PageUtil queryAllGrade(Integer pageNum, Integer pageSize) {
        PageHelper.offsetPage(pageNum, pageSize);
        List<Grade> grades = gradeDao.queryAllGrade();
        PageInfo pageInfo = new PageInfo(grades);
        return new PageUtil(pageInfo);
    }

    @Override
    public Grade queryGradeById(Integer gradeId) {
        return gradeDao.queryGradeById(gradeId);
    }

    @Override
    public Integer deleteSomeGrades(List<Integer> list) {
        return gradeDao.deleteSomeGrades(list);
    }

}
