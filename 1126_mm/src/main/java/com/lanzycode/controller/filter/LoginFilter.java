package com.lanzycode.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
/**
 * 登陆校验
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //类型转换
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        request.setCharacterEncoding("utf-8");

        //如果访问的是登陆相关的资源，直接放行
        String uri = request.getRequestURI();   //http://localhost/login.html    /login.html

        if("/userServlet".equals(uri) && "login".equals(request.getParameter("method"))) {
            chain.doFilter(req, resp);
            return;
        }

        if("/login.html".equals(uri) || uri.endsWith(".js") || uri.endsWith(".css")) {
            chain.doFilter(req, resp);
            return;
        }

        //从session中获取数据
        Object user = request.getSession().getAttribute("user");

        //判断user是否为null
        if(user == null) {//说明用户没有登陆
            //跳转到登陆页面
            response.sendRedirect(request.getContextPath() + "/login.html");
            return;
        }

        chain.doFilter(req, resp);
    }

    public void destroy() {
    }
}
