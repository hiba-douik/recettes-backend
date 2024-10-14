package com.Recettes.recettes.service;

import com.Recettes.recettes.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(String id);
    User updateUser(String id, User userDetails);
    void deleteUser(String id);
    List<User> searchUsers(String username);
}
