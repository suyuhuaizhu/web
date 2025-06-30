<%--
  Created by IntelliJ IDEA.
  User: jeffp
  Date: 2025/5/24
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servletdemo.bean.Movie" %>
<%
    List<Movie> movies = (List<Movie>) request.getAttribute("movies");
%>
<html>
<head>
    <title>电影列表</title>
</head>
<body>
<h2>电影管理系统 - 列表</h2>
<a href="movie?action=add">新增电影</a> |
<%--<a href="logout.jsp">退出登录</a>--%>
<table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>导演</th>
        <th>类型</th>
        <th>年份</th>
        <th>简介</th>
        <th>操作</th>
    </tr>
    <%
        if (movies != null) {
            for (Movie m : movies) {
    %>
    <tr>
        <td><%= m.getId() %></td>
        <td><%= m.getTitle() %></td>
        <td><%= m.getDirector() %></td>
        <td><%= m.getGenre() %></td>
        <td><%= m.getRelease_year() %></td>
        <td><%= m.getDescription() %></td>
        <td>
            <a href="movie?action=edit&id=<%= m.getId() %>">编辑</a> |
            <a href="movie?action=delete&id=<%= m.getId() %>" onclick="return confirm('确定要删除吗？')">删除</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
