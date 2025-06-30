package com.example.servletdemo.servlet;

import com.example.servletdemo.bean.Movie;
import com.example.servletdemo.dao.MovieDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "movieServlet", value = "/movie")
public class MovieServlet extends HttpServlet {
    MovieDAO dao = new MovieDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            List<Movie> list = dao.getAllMovies();
            request.setAttribute("movies", list);
            request.getRequestDispatcher("movieList.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Movie movie = dao.getMovieById(id);
            request.setAttribute("movie", movie);
            request.getRequestDispatcher("movieForm.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteMovie(id);
            response.sendRedirect("movie?action=list");
        } else if ("add".equals(action)) {
            request.getRequestDispatcher("movieForm.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Movie movie = new Movie();
        movie.setTitle(request.getParameter("title"));
        movie.setDirector(request.getParameter("director"));
        movie.setGenre(request.getParameter("genre"));
        movie.setRelease_year(Integer.parseInt(request.getParameter("release_year")));
        movie.setDescription(request.getParameter("description"));

        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            dao.addMovie(movie);
        } else {
            movie.setId(Integer.parseInt(id));
            dao.updateMovie(movie);
        }

        response.sendRedirect("movie?action=list");
    }
}
