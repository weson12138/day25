package com.Filter;


import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter{
    private String encoding;
    // 初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("EncodingFilter init...");
        //读取配置文件中配置的编码方式
         encoding = filterConfig.getInitParameter("encoding");
    }


    // 执行过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.设置请求的编码
        servletRequest.setCharacterEncoding("encoding");
        // 2.设置响应的编码
        servletResponse.setCharacterEncoding(encoding);
        // 浏览器以什么编码执行
        servletResponse.setContentType("text/html;charset=utf-8");
        // 3.继续执行客户端的请求

        long Stime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long time = System.currentTimeMillis();

        System.out.println(time-Stime);
//        // 获得当前时间的毫秒数
//        long Etime = System.currentTimeMillis();
    }


    //销毁
    @Override
    public void destroy() {
          System.out.println("EncodingFilter destroy...");
    }
}
