package com.hddx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 进行一些初始化操作
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        // 检查请求的URL中是否包含"FilterLoginServlet"
        boolean flag = req.getRequestURL().toString().contains("FilterLoginServlet");

        if (user != null || flag) {
            chain.doFilter(request,response);
        } else {
            req.setAttribute("msg", "您未登录请先登录");
            req.getRequestDispatcher("/filterLogin").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        // 进行一些清理操作
    }
}