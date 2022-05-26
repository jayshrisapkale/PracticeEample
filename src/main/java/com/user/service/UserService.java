package com.user.service;

import com.user.entity.User;

import java.util.List;

public interface UserService {
    User insertUser(User user);

    User getUser(Integer id);

    List<User> getAllUser();
}
