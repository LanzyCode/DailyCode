package com.lanzycode.servlet;

import com.lanzycode.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(getServletContext().getRealPath("/user.txt")));
        ArrayList<User> list=new ArrayList<>();
        String line;
        while((line=br.readLine())!=null){
            User user=new User();
            String[] arr=line.split(",");
            user.setUsername(arr[0]);
            user.setPassword(arr[1]);
            list.add(user);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();

        pw.write("<table border='1' width='50%' align='center'>");
        pw.write("<tr>");
        pw.write("<td>用户名</td><td>密码</td>");
        pw.write("</tr>");

        for (User user : list) {
//          pw.write(user.getUsername()+","+user.getPassword()+"<br/>");
            pw.write("<tr>");
            pw.write("<td>"+user.getUsername()+"</td><td>"+user.getPassword()+"</td>");
            pw.write("</tr>");
        }
        pw.write("</table>");
        br.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
