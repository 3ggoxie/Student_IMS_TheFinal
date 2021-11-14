package entity;

import java.io.Serializable;

/**
 * (TbGradeinfoSub)实体类
 *
 * @author makejava
 * @since 2021-09-25 17:19:58
 */
public class TbGradeinfoSub implements Serializable {
    private static final long serialVersionUID = 909134393638182894L;
    /**
     * 学生编号
     */
    private String stuid;
    /**
     * 学生姓名
     */
    private String stuname;
    /**
     * 考试科目编号
     */
    private String code;
    /**
     * 考试成绩
     */
    private Float grade;
    /**
     * 科目名称
     */
    private String subject;
    /**
     * 班级编号
     */
    private String classID;
    /**
     * 年级编号
     */
    private String gradeID;


    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getGradeID() {
        return gradeID;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

}

