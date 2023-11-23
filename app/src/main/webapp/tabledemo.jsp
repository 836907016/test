<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hddx.pojo.TableDemo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 83690
  Date: 2023/10/30
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>



<html>
<head>
    <title>tableDemo</title>
</head>
<body>
<%--${tableDemo}--%>
    <button >新增</button>
    <hr>
    <table width="800px" border="1px" cellspacing="0">
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <%--jstl标签完成迭代循环    --%>
        <c:forEach items="${tableDemo}" var="demo" varStatus="status">
            <tr align="center">
                    <%--<td>${brand.id}</td>--%>
                <td>${demo.id}</td>
                <td>${demo.proName}</td>
                <td>${demo.comName}</td>
                <td>${demo.order}</td>
                <td>${demo.proDesc}</td>
                        <td>${demo.status==true?"启用":"禁用"}</td>
                <td><a href="#">修改</a>
                    <a href="#">删除</a></td>
            </tr>
        </c:forEach>

<%--        <%--%>
<%--            //向TableDemo对象中填写内容--%>
<%--            TableDemo t1 = new TableDemo(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",true);--%>
<%--            TableDemo t2 = new TableDemo(2,"优衣库","优衣库",10,"优衣库，服适人生",false);--%>
<%--            TableDemo t3 = new TableDemo(3,"小米","小米科技有限公司",1000,"为发烧而生",true);--%>
<%--            //创建集合--%>
<%--            List<TableDemo> demoList = new ArrayList<TableDemo>();--%>
<%--            demoList.add(t1);--%>
<%--            demoList.add(t2);--%>
<%--            demoList.add(t3);--%>
<%--        %>--%>
<%--        <%--%>
<%--        for(TableDemo tableDemo:demoList){--%>
<%--        %>--%>
<%--        <tr align="center">--%>
<%--            <td><%=tableDemo.getId()%></td>--%>
<%--            <td><%=tableDemo.getProName()%></td>--%>
<%--            <td><%=tableDemo.getComName()%></td>--%>
<%--            <td><%=tableDemo.getOrder()%></td>--%>
<%--            <td><%=tableDemo.getProDesc()%></td>--%>
<%--            <td><%=tableDemo.isStatus()==true?"启用":"禁用"%></td>--%>
<%--            <td>--%>
<%--                修改--%>
<%--                删除--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <%}%>--%>

    </table>
<script>

</script>
</body>

</html>
