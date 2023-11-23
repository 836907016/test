package com.hddx.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        //用户名=zhangsan,密码123
        if("zhangsan".equals(username)&&"123".equals(password)){
            //用户名和密码输入正确
            if ("remeber".equals(remember)){
                Cookie username1 = new Cookie("username", username);
                Cookie password1 = new Cookie("password", password);
                        username1.setMaxAge(2*60);
                        password1.setMaxAge(2*60);
                        response.addCookie(username1);
                        response.addCookie(password1);
            }
           // 保存登录状态
            HttpSession session = request.getSession();
            String id = session.getId();
            session.setAttribute("loginMsg",true);
            session.setMaxInactiveInterval(30);
            //将session的id存放才cookie中
            Cookie cookie = new Cookie("JSESSIONID", id);
            //分配生命周期,不要让cook在关闭浏览器的时候死亡
            cookie.setMaxAge(120);
            //把cookie加入浏览器中
            response.addCookie(cookie);

            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}