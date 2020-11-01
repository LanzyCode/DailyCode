<%@ page import="com.lanzycode.bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: shawn
  Date: 2020/11/1
  Time: 4:17 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%request.setAttribute("username", "lanzy");%>
    <%out.println(request.getAttribute("username"));%><br/>
    <%=request.getAttribute("username")%><br/>
    ${username}<br/>
    基本数据类型：
    <%pageContext.setAttribute("num", 10);%>
    ${num}<br/>
    对象类型:
    <%
        User user = new User("lanzy","123");
        pageContext.setAttribute("user", user);
    %>
    ${user}<br/>
    用户名:${user.username}<br/>
    密码:${user.password}<br/>
    数组类型：
    <%
        String[] arr={"hello","lanzy"};
        pageContext.setAttribute("arr", arr);
    %>
    ${arr[0]}<br/>
    ${arr[1]}<br/>
    单列集合类型：
    <%
        ArrayList<String> list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        pageContext.setAttribute("list", list);
    %>
    ${list}<br/>
    双列集合类型：
    <%
        Map<String, User> map = new HashMap<>();
        map.put("user01", new User("lanzy1","345"));
        map.put("user02", new User("lanzy2","345"));
        pageContext.setAttribute("map", map);
    %>
    ${map}<br/>
    ${map.user01}<br/>
    ${map.user01.username}<br/>
</body>
</html>
