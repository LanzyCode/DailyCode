package com.lanzycode.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map map = new HashMap();
        try {
            Part part = request.getPart("file");
            String index = request.getParameter("index");

            //获取输入流
            InputStream is = part.getInputStream();

            //创建输出流
            ServletContext servletContext = request.getServletContext();
            String realPath = servletContext.getRealPath("/upload");

            String fileName = UUID.randomUUID().toString();
            FileUtils.copyInputStreamToFile(is, new File(realPath + "/" + fileName));

            map.put("flag",true);
            map.put("fileName",fileName);
            if(index != null) {
                map.put("index",Integer.parseInt(index));
            }
        } catch (Exception e) {
            map.put("flag",false);
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
