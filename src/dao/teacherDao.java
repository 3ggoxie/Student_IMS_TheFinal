package dao;

import appstu_util.JdbcUtil;
import entity.TbTeacherinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class teacherDao extends BaseDAO<TbTeacherinfo>{

    public int insert(String teaid,String code,String teaname,String sex){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="insert into tb_teacherinfo(teaid, code, teaname, sex) values(?,?,?,?)";
            return update(con,sql,teaid, code, teaname, sex);
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
        return 0;
    }

    public TbTeacherinfo select(String teaid){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_teacherinfo where teaid=?";
            return query(con,sql,teaid);
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
    public List<TbTeacherinfo> selectAll(){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_teacherinfo";
            return queryAll(con,sql);
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

    public int delete(String teaid){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="delete from tb_teacherinfo where teaid=?";
            return update(con,sql,teaid);
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
        return 0;
    }

}
