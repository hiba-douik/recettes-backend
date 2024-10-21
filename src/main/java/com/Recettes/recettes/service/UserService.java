package com.Recettes.recettes.service;

import com.Recettes.recettes.model.User;
import com.Recettes.recettes.model.Recipe;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserByUserId(String userId);
    List<User> getAllUsers();
    User updateUser(String userId, User user);
    void deleteUser(String userId);
    List<Recipe> getRecipesByUserId(String userId);
    boolean authenticateUser(String email, String password, String username); // Mis à jour pour inclure username
}
