<%--
  Created by IntelliJ IDEA.
  User: 83690
  Date: 2023/10/30
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo测试</title>
</head>
<body>
    <h1>你好,世界</h1>
    <%--jsp本质是Servlet,jsp中可以写java代码    --%>
        <%--如果用<%=..  %>将会显示在浏览器页面中      --%>
    <%--如果用<%!..  %>定义的变量会在成员变量中      --%>
<%
    System.out.println("hello world");
%>

<%="hello.world"%>

<%!
    int sum = 30;
%>
</body>
</html>
