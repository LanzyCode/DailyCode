package com.itheima.controller;



import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description 控制层-用户
 * @Author b0w3n
 * @Date 2020/5/30-4:04
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private static final String SAVE = "save";
    private static final String FIND_ALL = "findAll";
    private static final String DELETE = "delete";
    private static final String FIND_BY_ID = "findById";
    private static final String UPDATE = "update";
    private static final String TO_ADD = "toAdd";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建UserService对象.
        UserService userService = new UserServiceImpl();
        //判断发到后台的请求操作.
        String method = request.getParameter("method");
        if (FIND_ALL.equals(method)) {
            //查询出所有的用户数据返回到视图.
            List<User> userList = userService.findAllUserInfo();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/WEB-INF/pages/User_List.jsp").forward(request, response);
        } else if (FIND_BY_ID.equals(method)) {
            //查询出单个用户数据并返回到视图.
            User user = userService.selectUserById(Integer.valueOf(request.getParameter("id")));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/pages/User_Update.jsp").forward(request, response);
        } else if (UPDATE.equals(method)) {
            //封装User对象并传递到Model层.
            User u = new User(Integer.valueOf(request.getParameter("id")), request.getParameter("username"), request.getParameter("email"));
            userService.updateUserInfo(u);
            //查询出所有的用户数据返回到视图.
            List<User> userList = userService.findAllUserInfo();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/WEB-INF/pages/User_List.jsp").forward(request, response);
        } else if (TO_ADD.equals(method)) {
            request.getRequestDispatcher("/WEB-INF/pages/User_Add.jsp").forward(request, response);
        } else if (SAVE.equals(method)) {
            //封装User对象并传递到Model层.
            User u = new User(null, request.getParameter("username"), request.getParameter("email"));
            userService.saveUserInfo(u);
            //查询出所有的用户数据返回到视图.
            List<User> userList = userService.findAllUserInfo();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/WEB-INF/pages/User_List.jsp").forward(request, response);
        } else if (DELETE.equals(method)) {
            Integer userId = Integer.valueOf(request.getParameter("id"));
            userService.deleteUserInfo(userId);
            //查询出所有的用户数据返回到视图.
            List<User> userList = userService.findAllUserInfo();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/WEB-INF/pages/User_List.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
