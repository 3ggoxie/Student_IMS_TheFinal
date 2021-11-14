package dao;

import appstu_util.JdbcUtil;
import entity.TbUserinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class userDao extends BaseDAO<TbUserinfo>{
    public List<TbUserinfo> selectAll(String username,String pass){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_userinfo where username=?and pass=?";
            return queryAll(con,sql,username,pass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(con,null);
        }
        return null;
    }
    public TbUserinfo select(String username){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_userinfo where username=?";
            return query(con,sql,username);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(con,null);
        }
        return null;
    }

    public TbUserinfo selectinPass(String pass){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_userinfo where pass=?";
            return query(con,sql,pass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(con,null);
        }
        return null;
    }

}
