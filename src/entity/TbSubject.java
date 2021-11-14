package entity;

import java.io.Serializable;

/**
 * (TbSubject)实体类
 *
 * @author makejava
 * @since 2021-09-24 18:38:53
 */
public class TbSubject implements Serializable {
    private static final long serialVersionUID = 825598949238987300L;
    /**
     * 科目编号
     */
    private String code;
    /**
     * 科目名称
     */
    private String subject;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}

