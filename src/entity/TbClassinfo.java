package entity;

import java.io.Serializable;

/**
 * (TbClassinfo)实体类
 *
 * @author makejava
 * @since 2021-09-24 18:04:27
 */
public class TbClassinfo implements Serializable {
    private static final long serialVersionUID = -56722994267207317L;
    /**
     * 班级编号
     */
    private String classID;
    /**
     * 年级编号
     */
    private String gradeID;


    public String getclassID() {
        return classID;
    }

    public void setClassid(String classid) {
        this.classID = classid;
    }

    public String getGradeid() {
        return gradeID;
    }

    public void setGradeid(String gradeid) {
        this.gradeID = gradeid;
    }

}

