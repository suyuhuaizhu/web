<%--
  Created by IntelliJ IDEA.
  User: jeffp
  Date: 2025/5/24
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
</head>
<body>
<h2>用户登录</h2>
<form method="post" action="${pageContext.request.contextPath}/login">
  用户名: <input type="text" name="username"><br>
  密&nbsp;&nbsp;码: <input type="password" name="password"><br>
  <input type="submit" value="登录">
</form>
<a href="register.jsp">还没有账号？点击注册</a>
<br>
<p style="color:red">${error}</p>
</body>
</html>
