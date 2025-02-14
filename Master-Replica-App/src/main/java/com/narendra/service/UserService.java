package com.narendra.service;

import com.narendra.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User save(User user);

    void update(User user);

    void delete(Integer id);
}
