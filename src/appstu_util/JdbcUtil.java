package appstu_util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
/*    private static DataSource dataSource;*/
    private JdbcUtil(){}
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");
        var p = new Properties();

        p.load(is);
        String url = p.getProperty("url");
        String user = p.getProperty("username");
        String password = p.getProperty("password");
        String driverPath = p.getProperty("driver");
        Class.forName(driverPath);
        return DriverManager.getConnection(url, user, password);

    }

    public static void close(final Connection c, final Statement p) {

        if (p != null) {
            try {
                p.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (c != null) {
            try {
                c.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭流
     *
     * @param c
     * @param p
     * @param rs
     */
    public static void close(final Connection c, final Statement p, final ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(c,p);
    }
}
