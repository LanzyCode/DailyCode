<%--
  Created by IntelliJ IDEA.
  User: shawn
  Date: 2020/11/1
  Time: 3:30 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form action="/jsp/loginServlet" method="get" autocomplete="off">
        用户名：<input type="text" name="username">
        密码：<input type="text" name="password">
        <button TYPE="submit">提交</button>
    </form>
</body>
</html>
