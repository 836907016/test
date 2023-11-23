package jdbc;

import java.sql.*;

public class Domain {
    public static void main(String[] args) throws Exception {
        // 1. 注册数据库的驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.通过DriverManager获取数据库连接

        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=true" +
                "&serverTimezone=GMT";
        String username = "root";    //数据库用户名
        String password = "y031214.";    //数据库密码
        Connection connection = DriverManager.getConnection(url, username, password);
        //3. 通过Connection对象获取Statement对象
        String sql = "select * from users";
        PreparedStatement ps = connection.prepareStatement(sql);
        //4. 执行查询操作，返回结果为resultSet对象
        ResultSet resultSet = ps.executeQuery();
        //5. 遍历resultSet，解析结果
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String psw = resultSet.getString("password");
            String email = resultSet.getString("email");
            Date birthday = resultSet.getDate("birthday");
            System.out.println("id="+id+","+"name="+name+","+"psw="+psw+","+"email="+email+","
                    +"birthday="+birthday);
        }
        //回收数据库资源
        resultSet.close();
        ps.close();
        connection.close();
    }
}
