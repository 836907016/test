package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class XiuGai {
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
        String sql = "UPDATE users SET `name`='小李3',`email`='xiaoli@163.com' where id=4;";
        PreparedStatement ps = connection.prepareStatement(sql);

        //4. 执行修改操作，返回受影响的行数
        int rowsAffected = ps.executeUpdate();

        System.out.println("修改了 " + rowsAffected + " 行数据");
        //查询excuteQuery,增,删,改都用executeUpdate
        //回收数据库资源
        ps.close();
        connection.close();
    }
}
