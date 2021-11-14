package entity;

import java.io.Serializable;

/**
 * (TbStudentinfo)实体类
 *
 * @author makejava
 * @since 2021-09-23 17:06:11
 */
public class TbStudentinfo implements Serializable {
    private static final long serialVersionUID = -18498329565295515L;
    /**
     * 学生编号
     */
    private String stuid;
    /**
     * 班级编号
     */
    private String classID;
    /**
     * 学生姓名
     */
    private String stuname;
    /**
     * 学生性别
     */
    private String sex;
    /**
     * 学生年龄
     */
    private Integer age;


    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getclassID() {
        return classID;
    }

    public void setclassID(String classid) {
        this.classID = classid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TbStudentinfo{" +
                "stuid='" + stuid + '\'' +
                ", classID='" + classID + '\'' +
                ", stuname='" + stuname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

}

