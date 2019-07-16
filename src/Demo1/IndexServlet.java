package Demo1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 判断用户是否登陆

        // 获得会话的对象
        HttpSession session = req.getSession();
        // 从会话中获得用户信息
        User userInfo = (User) session.getAttribute("userInfo");
        if(userInfo != null ){
            PrintWriter out = resp.getWriter();
            out.println("Welcome");
        }else{
            req.setAttribute("msg","必须登陆才能访问");
            req.getRequestDispatcher("loginHtmlServlet").forward(req,resp);
        }
    }
}
