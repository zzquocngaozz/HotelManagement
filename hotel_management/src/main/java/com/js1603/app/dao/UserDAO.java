package com.js1603.app.dao;

import com.js1603.app.model.Room;
import com.js1603.app.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(int userId);
}
