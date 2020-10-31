package com.lanzycode.info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet("/add2")
public class InfoServletMethon2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Student stu=new Student();
        for (String name : parameterMap.keySet()) {
            String[] value=parameterMap.get(name);
            try {
                Method writeMethod = new PropertyDescriptor(name, stu.getClass()).getWriteMethod();
                writeMethod.invoke(stu, (Object) value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(stu);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
