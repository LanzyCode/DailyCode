package com.lanzycode.servlet;

import com.lanzycode.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("address");

        User user = new User();
        user.setName(username);
        user.setAddress(password);

        BufferedWriter bw = new BufferedWriter(new FileWriter(getServletContext().getRealPath("/user.txt"),true));
        bw.write(user.getName() + ","+user.getAddress());
        bw.newLine();
        bw.close();

        resp.getWriter().write("添加成功。2秒后自动跳转到首页...");
        resp.setHeader("Refresh","2;URL="+req.getContextPath()+"/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
