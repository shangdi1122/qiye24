package qiye.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class Grade {
    private Integer id;
    private String gradeName,details;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date createDate;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                ", details='" + details + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Grade() {
    }

    public Grade(Integer id, String gradeName, String details, Date createDate) {
        this.id = id;
        this.gradeName = gradeName;
        this.details = details;
        this.createDate = createDate;
    }
}
