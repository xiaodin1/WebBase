package com.fibbery.framework.utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 默认使用classpath下的jdbc.properties
 * Created by nenghua_jiang on 2016/3/31.
 */
public class JdbcUtils {

    private static final Logger logger = LoggerFactory.getLogger(JdbcUtils.class);


    private static BasicDataSource ds;

    //使用ThreadLocal存储当前线程中的Connection对象 解决多线程之间的冲突
    private static ThreadLocal<Connection> localThread = new ThreadLocal<Connection>();

    static{
        Properties properties = new Properties();
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("service_jdbc.properties");
        try {
            properties.load(inputStream);
            String driverClass = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String initialSize = properties.getProperty("initialSize");
            String maxActive = properties.getProperty("maxActive");
            String maxIdle = properties.getProperty("maxIdle");
            String minIdle = properties.getProperty("minIdle");
            String maxWait = properties.getProperty("maxWait");
            ds = new BasicDataSource();
            ds.setDriverClassName(driverClass);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            ds.setInitialSize(Integer.parseInt(initialSize));
            ds.setMaxActive(Integer.parseInt(maxActive));
            ds.setMaxIdle(Integer.parseInt(maxIdle));
            ds.setMinIdle(Integer.parseInt(minIdle));
            ds.setMaxWait(Long.parseLong(maxWait));

        } catch (IOException e) {
            logger.error("can't find jdbc.properties in classpath");
        }
    }


    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = localThread.get();
        if (conn == null) {
            conn = getDataSource().getConnection();
            localThread.set(conn);
        }
        return conn;
    }

    /**
     * 只是把连接还给数据库而已
     *
     * @throws java.sql.SQLException
     */
    public static void cleanup(ResultSet rs, Statement stmt) {
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                //logger.error("rs close error", e);
            }
            rs = null;
        }

        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                //logger.error("stmt close error", e);
            }
            stmt = null;
        }

        try {
            Connection conn = localThread.get();
            if (conn != null) {
                conn.close();
                localThread.remove();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void cleanup(ResultSet rs){
        cleanup(rs, null);
    }

    public static void cleanup(Statement stmt){
        cleanup(null, stmt);
    }

    public static void cleanup(){
        cleanup(null, null);
    }

    /**  以下是事物的一些简单的操作 **/

    public static void beginTrasaction() {
        try {
            Connection conn = localThread.get();
            if (conn == null) {
                conn = getDataSource().getConnection();
                localThread.set(conn);
            }
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(){
        try {
            Connection conn = localThread.get();
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void commit(){
        try {
            Connection conn = localThread.get();
            if (conn != null) {
                conn.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement("select 1 from dual");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Object obj = rs.getObject(1);
            System.out.println(obj.toString());
        }
    }
}
