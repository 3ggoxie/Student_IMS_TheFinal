package entity;

import java.io.Serializable;

/**
 * (TbUserinfo)实体类
 *
 * @author makejava
 * @since 2021-09-24 18:39:07
 */
public class TbUserinfo implements Serializable {
    private static final long serialVersionUID = -98303999030134486L;
    /**
     * 用户编号
     */
    private String userid;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户口令
     */
    private String pass;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}

