package com.lanzycode.servlet;

import com.lanzycode.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(getServletContext().getRealPath("/user.txt")));
        ArrayList<User> list = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null) {
            User user = new User();
            String[] arr = line.split(",");
            user.setName(arr[0]);
            user.setAddress(arr[1]);
            list.add(user);
        }
        req.getSession().setAttribute("Users",list);
        resp.sendRedirect(req.getContextPath() + "/listUser.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
