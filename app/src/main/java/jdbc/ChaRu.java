package jdbc;

import java.sql.*;

public class ChaRu {
    public static void main(String[] args) throws Exception {
        // 1. 注册数据库的驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.通过DriverManager获取数据库连接
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=true" +
                "&serverTimezone=GMT";
        String username = "root";    //数据库用户名
        String password = "y031214.";    //数据库密码
        Connection connection = DriverManager.getConnection(url, username, password);

        //3. 通过Connection对象获取PreparedStatement对象
        String sql = "insert into users(`name`, `password`, `email`, `birthday`) values('老李', '123', 'laoli@163.com', '2003-08-01')";
        PreparedStatement ps = connection.prepareStatement(sql);

        //4. 执行更新操作，返回受影响的行数
        int rowsAffected = ps.executeUpdate();

        System.out.println("插入了 " + rowsAffected + " 行数据");
        //查询excuteQuery,增,删,改都用executeUpdate
        //回收数据库资源
        ps.close();
        connection.close();
    }
}