package qiye.entity;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class Student {
    private Integer id,age;
    private Grade grade;
    private String studentName,gender,studentNum;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", grade=" + grade +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", studentNum='" + studentNum + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public Student() {
    }

    public Student(Integer id, Integer age, Grade grade, String studentName, String gender, String studentNum) {
        this.id = id;
        this.age = age;
        this.grade = grade;
        this.studentName = studentName;
        this.gender = gender;
        this.studentNum = studentNum;
    }
}
