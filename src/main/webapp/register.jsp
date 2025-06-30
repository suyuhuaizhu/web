<%--
  Created by IntelliJ IDEA.
  User: jeffp
  Date: 2025/5/24
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>注册</title></head>
<body>
<h2>用户注册</h2>
<form method="post" action="${pageContext.request.contextPath}/register">
    用户名: <input type="text" name="username" required><br>
    密码: <input type="password" name="password" required><br>
    <input type="submit" value="注册">
</form>
<a href="login.jsp">已有账号？返回登录</a>
<p style="color:red">${error}</p>
</body>
</html>

