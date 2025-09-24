package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {

    // Create user
    User saveUser(User user);

    // Get single user of given id
    User getUser(String userId);

    // Get all users
    List<User> getAllUsers();
}
