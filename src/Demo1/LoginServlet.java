package Demo1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");

        // 获取数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 判断用户名密码 合法性
        if(username != null && !"".equals(username)
                && password != null && !"".equals(password)){
            // 实例化用户
            User user = new User(username,password);
            //  将对象啊存入会话中
            HttpSession session = req.getSession();
            // 通过方法将用户对象存入
            session.setAttribute("userInfo",user);
            // 重定向到IndexServlet
            resp.sendRedirect("indexServlet");
        }else{
            req.setAttribute("msg","用户名或密码有误");
            req.getRequestDispatcher("loginHtmlServlet").forward(req,resp);
        }
    }
}
