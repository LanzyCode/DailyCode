package com.lanzycode.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.lanzycode.domain.User;
import com.lanzycode.service.UserService;
import com.lanzycode.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符集设置

        response.setContentType("application/json;charset=utf-8");

        //获取名为method的请求参数
        String method = request.getParameter("method");

        //注册Date转换器
        ConvertUtils.register(new Converter(){

            public Object convert(Class aClass, Object o) {
                if(o == null) {
                    return null;
                }

                String str = (String)o;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse(str);
                    return date;
                } catch (ParseException e) {

                    e.printStackTrace();
                    return null;
                }
            }
        }, Date.class);
        Map result = null;
        if("findByPage".equals(method)) {
            result = findByPage(request,response);
        } else if("add".equals(method)) {
            result = add(request, response);
        } else if("update".equals(method)) {
            result = update(request,response);
        } else if("delete".equals(method)) {
            result = delete(request,response);
        } else if("login".equals(method)) {
            result = login(request,response);
        }else if("logout".equals(method)) {
            logout(request,response);
            return;
        } else if("findUsername".equals(method)) {
            result = findUsername(request,response);
        }

        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //将result双列集合转换为json串
        String json = mapper.writeValueAsString(result);
        //响应数据
        response.getWriter().write(json);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.getSession().removeAttribute("user");

        response.sendRedirect(request.getContextPath() + "/login.html");
    }

    private UserService userService = new UserServiceImpl();

    private Map findUsername(HttpServletRequest request, HttpServletResponse response) {
        Map result = new HashMap();
        User user = (User) request.getSession().getAttribute("user");

        result.put("username",user.getUserName());
        return result;
    }


    private Map login(HttpServletRequest request, HttpServletResponse response) {
        Map result = new HashMap();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = userService.login(username,password);
            if(user == null) {
                result.put("flag",false);
                result.put("message","用户名或者密码错误");
            } else {
                result.put("flag",true);
                request.getSession().setAttribute("user",user);
            }
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","服务器异常");
            e.printStackTrace();
        }

        return result;
    }

    private Map delete(HttpServletRequest request, HttpServletResponse response) {

        Map result = new HashMap();

        try {
            String userId = request.getParameter("userId");

            userService.delete(userId);
            result.put("flag",true);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","添加失败");
            e.printStackTrace();
        }
        return result;
    }

    private Map update(HttpServletRequest request, HttpServletResponse response) {
        Map result = new HashMap();

        try {
            User user = new User();
            BeanUtils.populate(user,request.getParameterMap());

            userService.update(user);
            result.put("flag",true);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","修改失败");
            e.printStackTrace();
        }
        return result;
    }

    private Map add(HttpServletRequest request, HttpServletResponse response) {
        Map result = new HashMap();

        try {
            User user = new User();
            BeanUtils.populate(user,request.getParameterMap());

            userService.add(user);
            result.put("flag",true);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","添加失败");
            e.printStackTrace();
        }
        return result;
    }



    private Map findByPage(HttpServletRequest request, HttpServletResponse response) {

        Map result = new HashMap();
        try {
            //获取请求数据
            String currentPageStr = request.getParameter("currentPage");

            int currentPage = 1;
            if (currentPageStr != null && !"".equals(currentPageStr)) {
                currentPage = Integer.parseInt(currentPageStr);
            }

            PageInfo pageInfo = userService.findByPage(currentPage);
            result.put("flag",true);
            result.put("pageInfo",pageInfo);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","查询失败");
            e.printStackTrace();
        }
        return result;
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
