package grade;

import base.TestBase;
import org.junit.Test;
import qiye.entity.Grade;
import qiye.service.GradeService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class TestGrade extends TestBase {

    @Inject
    private GradeService gradeService;

    @Test
    public void queryAllGrade() {
        for (Grade grade : gradeService.queryAllGrade()) {
            System.out.println(grade);

        }
    }

    @Test
    public void queryAllGradeByPage() {
        System.out.println(gradeService.queryAllGrade(1,5));
    }

    @Test
    public void addGrade() {
        Grade grade = new Grade();
        grade.setGradeName("财务白班");
        grade.setDetails("管理财务");
        System.out.println(gradeService.addGrade(grade));
    }

    @Test
    public void updateGrade() {
        Grade grade = new Grade();
        grade.setId(114);
        grade.setGradeName("财务班");
        grade.setDetails("专门管理财务");
        System.out.println(gradeService.updateGrade(grade));
    }

    @Test
    public void deleteGrade() {


        System.out.println(gradeService.deleteGrade(87));
    }


    @Test
    public void queryGradeById() {
        System.out.println(gradeService.queryGradeById(115));
    }

    @Test
    public void deleteSomeGrades() {
        List<Integer> list = new ArrayList<>();
        list.add(116);
        list.add(117);
        System.out.println(gradeService.deleteSomeGrades(list));
    }
}
