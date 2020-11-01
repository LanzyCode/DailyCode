package com.lanzycode.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;

@WebServlet("/c1")
public class CookieServletDemo01 extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Cookie cookie = new Cookie("username", "passwd");
        response.addCookie(cookie);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
}
