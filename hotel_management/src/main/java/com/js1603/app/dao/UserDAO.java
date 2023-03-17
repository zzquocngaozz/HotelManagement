package com.js1603.app.dao;

import com.js1603.app.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(int userId, int status);

    public User getUserById(int userId);
    public User login(String email, String password);
    public boolean updatePassword(int userId, String password);
    public boolean checkEmailExist(String email);
    public int getUserNumber();

}
