package com.itheima.controller.servlet;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/deleteById")
public class DeleteByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,获取请求参数
        String id = request.getParameter("id");
        //2,创建UserService实现类对象
        UserService userService = new UserServiceImpl();
        //3,调用根据id删除的方法
        userService.deleteById(Integer.parseInt(id));

        //4,资源跳转，跳转findAllServlet资源
        response.sendRedirect(request.getContextPath() + "/user/findAll");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
