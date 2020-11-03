<%@ page import="com.lanzycode.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>查看信息</title>
</head>
<body>
    <table width="600px" border="1px">
        <tr>
            <th>用户名</th>
            <th>密码</th>
        </tr>
        <c:forEach items="${Users}" var="s">
            <tr align="center">
                <td>${s.name}</td>
                <td>${s.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
