<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addServlet" method="get" autocomplete="off">
    用户名：<input type="text" name="username"> <br>
    密码：<input type="text" name="address"> <br>

    <button type="submit">提交</button>
</form>
</body>
</html>
