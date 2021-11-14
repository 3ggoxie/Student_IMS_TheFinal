package dao;

import appstu_util.JdbcUtil;
import entity.TbGradeinfoSub;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class subjectGradeDao extends BaseDAO<TbGradeinfoSub> {
    public List<TbGradeinfoSub> selectinstuid(String stuid){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_gradeinfo_sub where stuid=?";
            return queryAll(con,sql,stuid);
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
    public List<TbGradeinfoSub> selectAllinClass(String classID){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select * from tb_gradeinfo_sub where classID=?";
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
    public List<TbGradeinfoSub> selectAll(){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_gradeinfo_sub";
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
    public  int delete(String stuid,String code){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="delete from tb_gradeinfo_sub where stuid=? and code=?";
            return update(con,sql,stuid,code);
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
    public int insert(String classID,String gradeID,String stuid,String stuname,String code,float grade,String subject){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="insert into tb_gradeinfo_sub(classID,gradeID,stuid,stuname,code,grade,subject) values(?,?,?,?,?,?,?)";
            return update(con,sql,classID,gradeID,stuid,stuname,code,grade,subject);
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
     * 修改学生成绩信息
     * @param grade
     * @param stuid
     * @param code
     * @return
     */
    public int update(float grade ,String stuid,String code){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection( );
            String sql="update tb_gradeinfo_sub set grade=? where stuid=?and code=?";
            return update(con,sql,grade,stuid,code);
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

    public List<TbGradeinfoSub> selectAllinGrade(String gradeID){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select * from tb_gradeinfo_sub where gradeID=?";
            return queryAll(con,sql,gradeID);
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

    public TbGradeinfoSub selectone(String stuid){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select * from tb_gradeinfo_sub where stuid=?";
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
    public List<TbGradeinfoSub> selectAllPerGrade(String username){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_gradeinfo_sub where stuname=?";
            return queryAll(con,sql,username);
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
        return null;}
}
