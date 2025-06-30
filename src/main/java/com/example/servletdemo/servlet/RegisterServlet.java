package com.example.servletdemo.servlet;

import com.example.servletdemo.bean.User;
import com.example.servletdemo.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (new UserDAO().register(user)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("error", "注册失败，请重试！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
