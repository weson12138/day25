<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
    // 1.获取客户浏览器的所以Cookie
    %>
</head>
<body>
    <form action = "loginServlet" method="post">
        用户名：<input name="username" value=""/><br/>
        密码：<input type="password" name="password"/><br/>
        <input type="submit" value="登录" />
    </form>

</body>
</html>
