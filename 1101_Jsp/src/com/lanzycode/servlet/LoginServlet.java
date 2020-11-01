package com.lanzycode.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断用户名
        if (username ==null || "".equals(null)){
            response.sendRedirect("/login.jsp");
        }
        //设置用户名
        request.getSession().setAttribute("username", username);
        //重定向
        response.sendRedirect("/index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
