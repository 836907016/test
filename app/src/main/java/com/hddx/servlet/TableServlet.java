package com.hddx.servlet;

import com.hddx.pojo.TableDemo;
import com.hddx.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/tableServlet")
public class TableServlet extends HttpServlet {
    @Override
    //jdbc查询
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection conn = JDBCUtils.getConnection();
            //3. 通过Connection对象获取Statement对象
            String sql = "select * from users";
            Connection connection = null;
            PreparedStatement ps = connection.prepareStatement(sql);
            //4. 执行查询操作，返回结果为resultSet对象
            ResultSet resultSet = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //向TableDemo对象中填写内容
        TableDemo t1 = new TableDemo(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",true);
        TableDemo t2 = new TableDemo(2,"优衣库","优衣库",10,"优衣库，服适人生",false);
        TableDemo t3 = new TableDemo(3,"小米","小米科技有限公司",1000,"为发烧而生",true);
        //创建集合
        List<TableDemo> demoList = new ArrayList<TableDemo>();
        demoList.add(t1);
        demoList.add(t2);
        demoList.add(t3);
        request.setAttribute("tableDemo",demoList);
        request.setAttribute("flag",false);
        request.getRequestDispatcher("/tabledemo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}