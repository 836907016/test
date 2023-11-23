<%--
  Created by IntelliJ IDEA.
  User: 83690
  Date: 2023/11/23
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/uploadServlet" method="post" enctype="multipart/form-data">
        <table width="600">
            <tr>
                <td>上传者</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>文件上传</td>
                <td><input type="file" name="myfile"></td>
            </tr>
            <tr>

                <td colspan="2">
                    <input type="submit" value="上传">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
