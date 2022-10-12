package com.course.kata.spring_boot.web.service;

import com.course.kata.spring_boot.web.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(int id);
    void deleteUserById(int id);
}
