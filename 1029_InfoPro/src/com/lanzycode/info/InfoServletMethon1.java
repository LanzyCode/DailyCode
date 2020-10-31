package com.lanzycode.info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/add")
public class InfoServletMethon1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取浏览器数据
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String realPath = getServletContext().getRealPath("/info.txt");
        String[] hobbies = req.getParameterValues("hobby");
        //字符流写入发布端文件
        BufferedWriter bw=new BufferedWriter(new FileWriter(realPath,true));
        bw.write(username+age+hobbies.toString());
        bw.newLine();
        bw.close();
        //服务器响应
        PrintWriter pw= resp.getWriter();
        pw.println("succeed");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
