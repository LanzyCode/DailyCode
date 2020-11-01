package com.lanzycode.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/c3")
public class CookieServletDemo03 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw= response.getWriter();
        pw.write("请求时间：");
        Cookie cookie=new Cookie("time", System.currentTimeMillis()+"");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if ("time".equals(c.getName())){
                String value = c.getValue();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                response.getWriter().write(sdf.format(new Date(Long.parseLong(value))));
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
