<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.bean.Users" %>
<%@ page import="java.util.Iterator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 24211
  Date: 2022/9/17
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center><h1>用户信息</h1>
    <table border="1" align="center">
        <tr>
            <th width="200">用户名</th><th width="200">ID</th><th width="200">年龄</th>
            <th width="200">操作</th>
        </tr>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user.uname}</td><td>${user.id}</td><td>${user.uage}</td>
                <td><a href="">修改</a>&nbsp;&nbsp;<a href=""> 删除</a></td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
