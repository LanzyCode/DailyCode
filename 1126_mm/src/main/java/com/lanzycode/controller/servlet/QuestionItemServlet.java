package com.lanzycode.controller.servlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanzycode.domain.QuestionItem;
import com.lanzycode.service.QuestionItemService;
import com.lanzycode.service.impl.QuestionItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/questionItemServlet")
public class QuestionItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符集设置
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        //获取名为method的请求参数
        String method = request.getParameter("method");

        Map result = null;
        if("findByQuestionId".equals(method)) {
            result = findByQuestionId(request,response);
        }else if("update".equals(method)) {
            result = update(request,response);
        }

        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //将result双列集合转换为json串
        String json = mapper.writeValueAsString(result);
        //响应数据
        response.getWriter().write(json);
    }

    QuestionItemService questionItemService = new QuestionItemServiceImpl();

    /**
     * 分页查询
     * @param request
     * @param response
     */
    private Map findByQuestionId(HttpServletRequest request, HttpServletResponse response) {
        Map result = new HashMap();
        try {
            String questionId = request.getParameter("questionId");
            //调用方法进行业务逻辑处理
            List<QuestionItem> list = questionItemService.findByQuestionId(questionId);

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
     * 修改功能
     * @param request
     * @param response
     * @return
     */
    private Map update(HttpServletRequest request,HttpServletResponse response) {
        Map result = new HashMap();
        //封装数据
        try {

            String questionId = request.getParameter("questionId");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

            ObjectMapper mapper = new ObjectMapper();
            List<QuestionItem> items = mapper.readValue(br, new TypeReference<List<QuestionItem>>() {});

            questionItemService.update(questionId,items);
            //添加成功
            result.put("flag",true);

        } catch (Exception e) {
            result.put("flag",false);
            result.put("message","修改失败");
            e.printStackTrace();
        }
        return result;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
