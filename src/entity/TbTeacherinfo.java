package entity;

import java.io.Serializable;

/**
 * (TbTeacherinfo)实体类
 *
 * @author makejava
 * @since 2021-09-24 18:39:02
 */
public class TbTeacherinfo implements Serializable {
    private static final long serialVersionUID = -84560037788821564L;
    /**
     * 教师编号
     */
    private String teaid;
    /**
     * 科目编号
     */
    private String code;
    /**
     * 教师姓名
     */
    private String teaname;
    /**
     * 教师性别
     */
    private String sex;


    public String getTeaid() {
        return teaid;
    }

    public void setTeaid(String teaid) {
        this.teaid = teaid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}

