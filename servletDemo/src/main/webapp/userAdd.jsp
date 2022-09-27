<%--
  Created by IntelliJ IDEA.
  User: 24211
  Date: 2022/9/27
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<center>
    <h1>添加用户信息</h1>
    <form action="UserAdd" method="post">
        用户名：<input type="text" name="uname"><br />
        年龄：<input type="text" name="uage"><br />
        <input type="submit" value="提交">
        <input type="reset" value="清空">
    </form>
</body>
</html>
