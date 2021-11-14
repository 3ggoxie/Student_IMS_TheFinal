package entity;

import java.io.Serializable;

/**
 * (TbGradeinfo)实体类
 *
 * @author makejava
 * @since 2021-09-24 18:04:41
 */
public class TbGradeinfo implements Serializable {
    private static final long serialVersionUID = 407471852695295509L;
    /**
     * 年级编号
     */
    private String gradeid;
    /**
     * 年级名称
     */
    private String gradename;


    public String getGradeid() {
        return gradeid;
    }

    public void setGradeid(String gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

}

