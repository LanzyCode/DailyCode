package com.itheima.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,乱码处理
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        //2,获取请求数据
        Map<String, String[]> map = request.getParameterMap();

        //3,创建学生对象
        Student stu = new Student();

        Map result = new HashMap();

        try {
            BeanUtils.populate(stu,map);

            //创建service对象
            StudentService studentService = new StudentServiceImpl();
            //调用方法进行业务逻辑处理
            studentService.addStudent(stu);

            result.put("flag",true);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","添加失败");
            e.printStackTrace();
        }

        //将map转换为json串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        //响应数据
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
