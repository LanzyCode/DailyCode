package com.itheima.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Company;
import com.itheima.domain.Dept;
import com.itheima.service.DeptService;
import com.itheima.service.impl.DeptServiceImpl;
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
import java.util.List;
import java.util.Map;

@WebServlet("/deptServlet")
public class DeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符集设置
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        //获取名为method的请求参数
        String method = request.getParameter("method");

        Map result = null;
        if("findAll".equals(method)) {
            result = findAll(request,response);
        } else if("add".equals(method)) {
            result = add(request, response);
        } else if("update".equals(method)) {
            result = update(request,response);
        } else if("delete".equals(method)) {
            result = delete(request,response);
        }

        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //将result双列集合转换为json串
        String json = mapper.writeValueAsString(result);
        //响应数据
        response.getWriter().write(json);
    }

    DeptService deptService = new DeptServiceImpl();

    /**
     * 分页查询
     * @param request
     * @param response
     */
    private Map findAll(HttpServletRequest request, HttpServletResponse response) {

        Map result = new HashMap();
        try {
            //获取请求数据
            List<Dept> list = deptService.findAll();
            result.put("flag",true);
            result.put("list",list);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","查询失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 添加功能
     * @param request
     * @param response
     * @return
     */
    private Map add(HttpServletRequest request,HttpServletResponse response) {

        Map result = new HashMap();
        try {
            Dept dept = new Dept();
            Map<String, String[]> params = request.getParameterMap();

            BeanUtils.populate(dept,params);

            deptService.add(dept);

            result.put("flag",true);

        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","添加失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改功能
     * @param request
     * @param response
     * @return
     */
    private Map update(HttpServletRequest request,HttpServletResponse response) {

        Map result = new HashMap();
        try {
            Dept dept = new Dept();
            Map<String, String[]> params = request.getParameterMap();

            BeanUtils.populate(dept,params);

            deptService.update(dept);

            result.put("flag",true);

        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","修改失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除功能
     * @param request
     * @param response
     * @return
     */
    private Map delete(HttpServletRequest request,HttpServletResponse response) {

        Map result = new HashMap();
        try {
            String deptId = request.getParameter("deptId");
            deptService.delete(deptId);

            result.put("flag",true);

        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","删除失败");
            e.printStackTrace();
        }
        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
