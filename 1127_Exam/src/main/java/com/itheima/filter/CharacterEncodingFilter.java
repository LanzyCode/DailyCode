package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 拦截器-乱码过滤器-Filter
 * @Author b0w3n
 * @Date 2020/5/20-15:39
 */
@WebFilter(value = "/*",initParams = {@WebInitParam(name = "encoding",value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {
    //初始化拦截器配置对象
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将ServletRequest与ServletResponse转换为HttpServletRequest与HttpServletResponse对象.
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取initParams的字符集并且指定解码和编码方式.
        request.setCharacterEncoding(filterConfig.getInitParameter("encoding"));
        response.setContentType("text/html;charset=UTF-8");
        //放行数据 -> 通过拦截器的doFilter方法.
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
