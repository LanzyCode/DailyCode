package com.lanzycode.servlet;

import com.lanzycode.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        //写入数据到本地
        BufferedWriter bw = new BufferedWriter(new FileWriter(getServletContext().getRealPath("/user.txt"),true));
        bw.write(user.getUsername()+","+user.getPassword());
        bw.newLine();
        bw.close();
        //浏览器跳转
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("注册成功.3秒后自动跳转到首页");
        response.setHeader("Refresh", "3;URL=index.html");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
