package com.lanzycode.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是过滤器");
        String username = servletRequest.getParameter("username");
        if ("lanzy".equals(username)){
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else{

        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被释放了");
    }
}
