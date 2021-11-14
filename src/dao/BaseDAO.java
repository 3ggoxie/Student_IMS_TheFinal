package dao;

import appstu_util.JdbcUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



@SuppressWarnings("all")
public abstract class BaseDAO<T> {
    private Class<T> clazz = null;
//    private QueryRunner queryRunner = null;

    /**
     * 获取泛型的类名
     */
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
//        queryRunner = new QueryRunner();
    }

    /**
     * @param [conn, sql, arg]
     * @return void
     * @throws
     * @since 自己写的增删改操作
     */
    public int update(Connection conn, String sql, Object... arg) {

        PreparedStatement p = null;
        try {
            p = conn.prepareStatement(sql);
            for (int i = 0; i < arg.length; i++) {
                p.setObject(i + 1, arg[i]);
            }
            return p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(null, p);
        }
        return 0;
    }


    /**
     * @param [connection, sql, args]
     * @return T
     * @throws
     * @since 自己写的查询操作
     */
    public T query(Connection connection, String sql, Object... args) {
        ResultSet resultSet = null;
        PreparedStatement p = null;
        try {
            p = filling(connection, sql, args);
            resultSet = p.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                T t = getT(clazz, resultSet, metaData, columnCount);
                return t;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, p, resultSet);
        }

        return null;
    }


//    public T getInstance(Connection conn, String sql, Object... args) {
//        /**
//         * @author lkp
//         * @date 2021/5/15 12:39
//         * @param [connection, sql, args]
//         * @return T
//         * @throws
//         * @since import org.apache.commons.dbutils.QueryRunner的查询操作
//         */
//
//        try {
//            BeanHandler<T> rsh = new BeanHandler<>(clazz);
//            T query = queryRunner.query(conn, sql, rsh, args);
//            return query;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return null;
//    }

    /**
     * @param [connection, sql, args]
     * @return java.util.List<T>
     * @throws
     * @since 自己写的查询所有的操作
     */
    public List<T> queryAll(Connection connection, String sql, Object... args) {

        ResultSet resultSet = null;
        PreparedStatement p = null;
        try {
            p = filling(connection, sql, args);
            resultSet = p.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<T> ts = new ArrayList<>();
            while (resultSet.next()) {
                T t = getT(clazz, resultSet, metaData, columnCount);

                ts.add(t);
            }
            return ts;
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, p, resultSet);
        }

        return null;
    }

//    public List<T> getForList(Connection conn, String sql, Object... args) {
//        /**
//         * @author lkp
//         * @date 2021/5/15 12:40
//         * @param [connection, sql, args]
//         * @return java.util.List<T>
//         * @throws
//         * @since org.apache.commons.dbutils.QueryRunner写的查询所有的操作
//         */
//        try {
//            BeanListHandler<T> rsh = new BeanListHandler<>(clazz);
//            List<T> query = queryRunner.query(conn, sql, rsh, args);
//            return query;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }


    private <T> T getT(Class<T> clazz, ResultSet resultSet, ResultSetMetaData metaData, int columnCount) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SQLException, NoSuchFieldException {
        T t = clazz.getDeclaredConstructor().newInstance();
        for (int i = 0; i < columnCount; i++) {
            String columnClassName = metaData.getColumnLabel(i + 1);
            Field declaredField = clazz.getDeclaredField(columnClassName);
            declaredField.setAccessible(true);
            declaredField.set(t, resultSet.getObject(i + 1));
        }
        return t;
    }

    public <E> E getValue(Connection conn,String sql,Object ...args){
        ResultSet resultSet = null;
        PreparedStatement p = null;
        try {

            p = filling(conn, sql, args);
            resultSet = p.executeQuery();
            if (resultSet.next()){
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(null, p,resultSet);
        }
        return null;
    }


    /**
     * 填充占位符
     * @param connection
     * @param sql
     * @param args
     * @return
     */
    private PreparedStatement filling(Connection connection, String sql, Object... args) {

        PreparedStatement p = null;
        try {
            p = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                p.setObject(i + 1, args[i]);
            }
            return p;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

//    public int Count(Connection connection, String sql){
//        PreparedStatement p = null;
//
//        try {
//            p = connection.prepareStatement(sql);
//            ResultSet resultSet = p.executeQuery();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

}
