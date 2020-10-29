package com.lanzycode.web.servletdemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext c = getServletContext();
        String encoding = c.getInitParameter("Encoding");
        System.out.println(encoding);

        String cp = c.getContextPath();
        System.out.println(cp);

        String realPath = c.getRealPath("/");
        System.out.println(realPath);

        String realPath1 = c.getRealPath("/WEB-INF/hello.html");
        System.out.println(realPath1);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
