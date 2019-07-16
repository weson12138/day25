package com.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置编码 （）

        // 2.获取数据

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //3.验证用户名是否不为空
        if(username!=null && !"".equals(username.trim())){
            //创建Cookie对象
            Cookie cookie = new Cookie("username",username);
            // 将Cookie加入响应对象中
            resp.addCookie(cookie);
            //跳转到首页
            req.getRequestDispatcher("index.jsp").forward(req,resp);

        }else{
            //验证失败
            req.setAttribute("msg","用户名不能为空");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
