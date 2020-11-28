package com.itheima.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Catalog;
import com.itheima.domain.Company;
import com.itheima.service.CatalogService;
import com.itheima.service.impl.CatalogServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/catalogServlet")
public class CatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符集设置
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        //获取名为method的请求参数
        String method = request.getParameter("method");

        Map result = null;
        if("findByPage".equals(method)) {
            result = findByPage(request,response);
        } else if("findAll".equals(method)) {
            result = findAll(request, response);
        } else if("add".equals(method)) {
            result = add(request, response);
        } else if("update".equals(method)) {
            result = update(request,response);
        } else if("delete".equals(method)) {
            result = delete(request,response);
        } else if("findCatalogIdByCatalogName".equals(method)) {
            result = findCatalogIdByCatalogName(request,response);
        }

        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //将result双列集合转换为json串
        String json = mapper.writeValueAsString(result);
        //响应数据
        response.getWriter().write(json);
    }


    private CatalogService catalogService = new CatalogServiceImpl();

    private Map findCatalogIdByCatalogName(HttpServletRequest request, HttpServletResponse response) {

        Map result = new HashMap();
        try {
            String catalogName = request.getParameter("name");

            String catalogId = catalogService.findCatalogIdByCatalogName(catalogName);
            result.put("flag",true);
            result.put("id",catalogId);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","查询类别失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 分页查询
     * @param request
     * @param response
     */
    private Map findAll(HttpServletRequest request, HttpServletResponse response) {

        Map result = new HashMap();
        try {
            //调用方法进行业务逻辑处理
            List<Catalog> list = catalogService.findAll();

            result.put("flag",true);
            result.put("list", list);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message", "查询失败");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 分页查询
     * @param request
     * @param response
     */
    private Map findByPage(HttpServletRequest request, HttpServletResponse response) {

        Map result = new HashMap();
        try {
            //获取请求数据
            String currentPageStr = request.getParameter("currentPage");

            int currentPage = 1;
            if (currentPageStr != null && !"".equals(currentPageStr)) {
                currentPage = Integer.parseInt(currentPageStr);
            }

            //调用方法进行业务逻辑处理
            PageInfo pageInfo = catalogService.findByPage(currentPage);

            result.put("flag",true);
            result.put("pageInfo", pageInfo);
        } catch (Exception e) {
            result.put("flag",false);
            result.put("message", "查询失败");
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
        //封装数据
        try {
            Map<String, String[]> params = request.getParameterMap();
            //创建Catalog对象
            Catalog catalog = new Catalog();
            BeanUtils.populate(catalog,params);

            catalogService.add(catalog);
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

        Map result = new HashMap();

        //封装数据
        try {
            Map<String, String[]> params = request.getParameterMap();
            Catalog catalog = new Catalog();
            BeanUtils.populate(catalog,params);

            catalogService.update(catalog);

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
            catalogService.delete(id);
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
