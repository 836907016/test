package com.hddx.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    static {
        try {
            //注册驱动,当JDBCUtils类加载就执行,并且执行一次
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=true&serverTimezone=GMT", "root", "y031214.");
        return connection;
    }
}
