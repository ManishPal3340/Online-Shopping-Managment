package com.shopingsystem.service;


//package com.onlineshop.service;

import com.shopingsystem.dao.UserDAO;
import com.shopingsystem.model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    public User login(String username) {
        return userDAO.getUserByUsername(username);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
