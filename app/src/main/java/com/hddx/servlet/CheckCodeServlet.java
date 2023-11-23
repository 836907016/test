package com.hddx.servlet;

import com.hddx.utils.CheckCodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1.response输出流对象
        ServletOutputStream os = response.getOutputStream();
        //2.调用验证码工具类方法
        String result = CheckCodeUtil.outputVerifyImage(120, 40, os, 4);
        System.out.println(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}