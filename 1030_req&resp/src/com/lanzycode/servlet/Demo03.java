package com.lanzycode.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/d3")
public class Demo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realPath = getServletContext().getRealPath("/img/demo.jpg");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));
        ServletOutputStream os = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while((len=(bis.read(bytes)))!=-1){
            os.write(bytes,0,len);
        }
        bis.close();
    }
}
