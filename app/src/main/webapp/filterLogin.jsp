<%--
  Created by IntelliJ IDEA.
  User: 83690
  Date: 2023/11/13
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="loginServlet" method="post">
    <div style="color: red"></div>
    <p>用户名:<input id="username" name="username" type="text" value="${cookie.username.value}"></p >
    <p>密码:<input id="password" name="password" type="password" value="${cookie.password.value}"></p >
    <p>记住我:<input id="remember" name="remember" type="checkbox"></p >
    <input type="submit" class="button" value="登录">
    <input type="reset" class="button" value="重置">
    没有账号？
    <a href="register.jsp">注册</a>
</form>
</body>
</html>
