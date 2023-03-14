package com.js1603.app.dao.impl;

import com.js1603.app.dao.UserDAO;
import com.js1603.app.model.User;
import com.js1603.app.util.DBContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends DBContext implements UserDAO {
    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = User.builder()
                        .userId(rs.getInt(1))
                        .userName(rs.getString(2))
                        .userEmail(rs.getString(3))
                        .userPassword(rs.getString(4))
                        .userRole(rs.getInt(5))
                        .userDob(rs.getString(6))
                        .userPhone(rs.getString(7))
                        .userGender(rs.getInt(8))
                        .userStatus(rs.getInt(9))
                        .build();
                if (user != null) {
                    userList.add(user);
                }
            }
            return userList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean addUser(User user) {
        String sql = "INSERT INTO `hotel_management`.`user`\n" +
                "(`user_name`,`user_email`,`user_password`,`user_role`,`user_dob`,`user_phone`,`user_gender`,`user_status`)\n" +
                "VALUES\n" +
                "(?,?,?,?,?,?,?,?);";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserEmail());
            ps.setString(3, user.getUserPassword());
            ps.setInt(4, user.getUserRole());
            ps.setString(5, user.getUserDob());
            ps.setString(6, user.getUserPhone());
            ps.setInt(7, user.getUserGender());
            ps.setInt(8,1);
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE `hotel_management`.`user`\n" +
                "SET\n" +
                "`user_name` = ?,\n" +
                "`user_email` = ?,\n" +
                "`user_password` =?,\n" +
                "`user_role` = ?,\n" +
                "`user_dob` = ?,\n" +
                "`user_phone` = ?,\n" +
                "`user_gender` = ?,\n" +
                "`user_status` = ?\n" +
                "WHERE `user_id` = ?;\n";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserEmail());
            ps.setString(3, user.getUserPassword());
            ps.setInt(4, user.getUserRole());
            ps.setString(5, user.getUserDob());
            ps.setString(6, user.getUserPhone());
            ps.setInt(7, user.getUserGender());
            ps.setInt(8,1);
            ps.setInt(9, user.getUserId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        String sql = "UPDATE `hotel_management`.`user`\n" +
                "SET`user_status` = 0\n" +
                "WHERE `user_id` = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            if (ps.executeUpdate() == 1) {
                System.out.println("Delete Success");

            }
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        UserDAOImpl impl = new UserDAOImpl();
        userList = impl.getAllUser();

        System.out.println(userList);
        impl.deleteUser(7);

    }
}