package com.itheima.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Company;
import com.itheima.service.CompanyService;
import com.itheima.service.impl.CompanyServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/companyServlet")
public class CompanyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符集设置
        request.setCharacterEncoding("utf-8");
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
        } else if("findAll".equals(method)) {
            result = findAll(request, response);
        }else if("add".equals(method)) {
            result = add(request, response);
        } else if("update".equals(method)) {
            result = update(request,response);
        } else if("delete".equals(method)) {
            result = delete(request,response);
        } else if("findCompanyIdByCompanyName".equals(method)) {
            result = findCompanyIdByCompanyName(request,response);
        }

        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //将result双列集合转换为json串
        String json = mapper.writeValueAsString(result);
        //响应数据
        response.getWriter().write(json);
    }

    //创建service层类对象
    private CompanyService companyService = new CompanyServiceImpl();

    private Map findCompanyIdByCompanyName(HttpServletRequest request, HttpServletResponse response) {

        Map result = new HashMap();
        try {
            String catalogName = request.getParameter("name");

            String id = companyService.findCompanyIdByCompanyName(catalogName);
            result.put("flag",true);
            result.put("id",id);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","查询公司id失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询所有
     * @param request
     * @param response
     */
    private Map findAll(HttpServletRequest request, HttpServletResponse response) {

        //调用方法进行业务逻辑处理
        List<Company> list = companyService.findAll();

        Map result = new HashMap();
        result.put("list",list);

        return result;
    }

    /**
     * 分页查询
     * @param request
     * @param response
     */
    private Map findByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取请求数据
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");

        int currentPage = 1;
        if(currentPageStr != null && !"".equals(currentPageStr)) {
            currentPage = Integer.parseInt(currentPageStr);
        }

        int pageSize = 5;
        if(pageSizeStr != null && !"".equals(pageSizeStr)) {
            pageSize = Integer.parseInt(pageSizeStr);
        }


        //调用方法进行业务逻辑处理
        PageInfo pageInfo = companyService.findByPage(currentPage, pageSize);

        Map result = new HashMap();
        result.put("pageInfo",pageInfo);

        return result;
    }

    /**
     * 添加功能
     * @param request
     * @param response
     * @return
     */
    private Map add(HttpServletRequest request,HttpServletResponse response) {

        Map<String, String[]> params = request.getParameterMap();

        //创建Company对象
        Company company = new Company();

        Map result = new HashMap();

        //封装数据
        try {
            BeanUtils.populate(company,params);

            companyService.add(company);

            //添加成功
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

        Map<String, String[]> params = request.getParameterMap();

        //创建Company对象
        Company company = new Company();

        Map result = new HashMap();

        //封装数据
        try {
            BeanUtils.populate(company,params);

            companyService.update(company);

            //添加成功
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
            String id = request.getParameter("id");
            companyService.delete(id);
            result.put("flag",true);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","删除成功");
            e.printStackTrace();
        }
        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
