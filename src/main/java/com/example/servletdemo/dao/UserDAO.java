package com.example.servletdemo.dao;

import com.example.servletdemo.bean.User;
import com.example.servletdemo.util.DBUtil;
import java.sql.*;

public class UserDAO {
    public boolean register(User user) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO user(username, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public User login(String username, String password) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
