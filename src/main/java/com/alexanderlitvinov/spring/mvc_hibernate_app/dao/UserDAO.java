package com.alexanderlitvinov.spring.mvc_hibernate_app.dao;

import com.alexanderlitvinov.spring.mvc_hibernate_app.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
