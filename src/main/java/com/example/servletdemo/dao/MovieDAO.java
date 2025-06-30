package com.example.servletdemo.dao;


import com.example.servletdemo.bean.Movie;
import com.example.servletdemo.util.DBUtil;
import java.sql.*;
import java.util.*;

public class MovieDAO {
    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM movie");
            while (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setDirector(rs.getString("director"));
                m.setGenre(rs.getString("genre"));
                m.setRelease_year(rs.getInt("release_year"));
                m.setDescription(rs.getString("description"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Movie getMovieById(int id) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM movie WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setDirector(rs.getString("director"));
                m.setGenre(rs.getString("genre"));
                m.setRelease_year(rs.getInt("release_year"));
                m.setDescription(rs.getString("description"));
                return m;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addMovie(Movie movie) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO movie (title, director, genre, release_year, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getDirector());
            ps.setString(3, movie.getGenre());
            ps.setInt(4, movie.getRelease_year());
            ps.setString(5, movie.getDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMovie(Movie movie) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "UPDATE movie SET title=?, director=?, genre=?, release_year=?, description=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getDirector());
            ps.setString(3, movie.getGenre());
            ps.setInt(4, movie.getRelease_year());
            ps.setString(5, movie.getDescription());
            ps.setInt(6, movie.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMovie(int id) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM movie WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

