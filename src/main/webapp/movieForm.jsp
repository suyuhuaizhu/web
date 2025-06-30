<%--
  Created by IntelliJ IDEA.
  User: jeffp
  Date: 2025/5/24
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servletdemo.bean.Movie" %>
<%
  Movie movie = (Movie) request.getAttribute("movie");
  boolean isEdit = (movie != null);
%>
<html>
<head>
  <title><%= isEdit ? "编辑电影" : "新增电影" %></title>
</head>
<body>
<h2><%= isEdit ? "编辑电影信息" : "新增电影" %></h2>
<form method="post" action="${pageContext.request.contextPath}/movie">
  <% if (isEdit) { %>
  <input type="hidden" name="id" value="<%= movie.getId() %>">
  <% } %>
  标题: <input type="text" name="title" value="<%= isEdit ? movie.getTitle() : "" %>"><br>
  导演: <input type="text" name="director" value="<%= isEdit ? movie.getDirector() : "" %>"><br>
  类型: <input type="text" name="genre" value="<%= isEdit ? movie.getGenre() : "" %>"><br>
  上映年份: <input type="text" name="release_year" value="<%= isEdit ? movie.getRelease_year() : "" %>"><br>
  简介: <br>
  <textarea name="description" rows="5" cols="50"><%= isEdit ? movie.getDescription() : "" %></textarea><br>
  <input type="submit" value="<%= isEdit ? "更新" : "添加" %>电影">
  <a href="movie?action=list">返回列表</a>
</form>
</body>
</html>
