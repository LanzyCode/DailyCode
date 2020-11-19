package com.lanzycode03.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanzycode03.bean.User;
import com.lanzycode03.service.UserService;
import com.lanzycode03.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应的编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //1.获取请求参数
        String username = req.getParameter("username");

        //2.调用业务层的模糊查询方法得到数据
        UserService service = new UserServiceImpl();
        List<User> users = service.selectLike(username);

        //3.将数据转成JSON，响应到客户端
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(users);
        resp.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
