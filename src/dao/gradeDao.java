package dao;

import appstu_util.JdbcUtil;
import entity.TbClassinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class gradeDao extends BaseDAO<TbClassinfo>{
    public List<TbClassinfo> selectAllGrade(String gradeID){
        Connection con =null;
        try {
            con= JdbcUtil.getConnection();
            String sql="select *from tb_classinfo where gradeID=?";
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
        return null;}




}
