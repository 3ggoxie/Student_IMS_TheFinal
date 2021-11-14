package dao;

import appstu_util.JdbcUtil;
import entity.TbStudentinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class studentDao extends BaseDAO<TbStudentinfo>{
    /**
     * 按学号查询一条数据
     * @param stuid
     * @return
     */
    public TbStudentinfo select(String stuid){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_studentinfo where stuid=?";
            return query(con,sql,stuid);
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

    /**
     * 查询所有数据
     * @return
     */
    // TODO: 2021-9-23 0023 增加查询方式，实现按年级查找所有数据
    public List<TbStudentinfo>selectAllinClass(String classID){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select * from tb_studentinfo where classID=?";
            return queryAll(con,sql,classID);
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

    /**
     * 查找所有数据
     * @return
     */
    public List<TbStudentinfo> selectAll(){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_studentinfo";
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

    /**
     * 删除一条数据
     * @param stuid
     * @return
     */
    public int delete(String stuid){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="delete from tb_studentinfo where stuid=?";
            return update(con,sql,stuid);
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

    /**
     * 增加一条数据
     * @param stuid
     * @return
     */
    public int insert(String stuid,String classID,String stuname,String sex,int age){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="insert into tb_studentinfo(stuid,classID,stuname,sex,age) values(?,?,?,?,?)";
            return update(con,sql,stuid,classID,stuname,sex,age);
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

    /**
     * 修改学生信息
     * @param stuup
     * @return
     */
    public int update(TbStudentinfo stuup){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="update tb_studentinfo set classID = ?,stuname=?,sex=?,age=? where stuid=?";
            return update(con,sql,stuup.getclassID(),stuup.getStuname(),stuup.getSex(),stuup.getAge(),stuup.getStuid());
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
    public TbStudentinfo selectinName(String stuname){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_studentinfo where stuname=?";
            return query(con,sql,stuname);
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
