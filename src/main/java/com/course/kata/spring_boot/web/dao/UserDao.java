package com.course.kata.spring_boot.web.dao;

import com.course.kata.spring_boot.web.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
