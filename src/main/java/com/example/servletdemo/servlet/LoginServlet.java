package com.example.servletdemo.servlet;

import com.example.servletdemo.bean.User;
import com.example.servletdemo.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new UserDAO().login(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("movie?action=list");
        } else {
            request.setAttribute("error", "用户名或密码错误！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
