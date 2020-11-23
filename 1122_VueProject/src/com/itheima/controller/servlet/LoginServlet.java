package com.itheima.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        //1,获取请求数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2,创建service对象
        UserService userService = new UserServiceImpl();
        User user = userService.login(username,password);

        //3,判断
        Map map = new HashMap();
        if(user == null) {//说明用户名和密码错误
            map.put("flag",false);
            map.put("message","用户名或者密码错误");
        } else {
            map.put("flag",true);
            //将用户信息存储到session域对象中
            request.getSession().setAttribute("user",user);
        }

        //将map集合转换为json数据响应回给浏览器
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map); // {"flag":true,",message":"用户名或者密码错误"}
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
