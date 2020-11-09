package com.lanzycode.jdbc;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e)
        {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
        try
        {
            System.out.println("start connecting");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","root","Cxcar836");
            //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

            System.out.println("Success connect Mysql server!");

            Statement stmt = connect.createStatement();

            ResultSet rs = stmt.executeQuery("select * from test.user");
            //name 为你表的名称
            while (rs.next())
            {
                System.out.println(rs.getString("name"));
            }
            rs.close();
            connect.close(); // 关闭连接
        }
        catch (Exception e)
        {
            System.out.print("get data error!");
            e.printStackTrace();
        }

    }
}
