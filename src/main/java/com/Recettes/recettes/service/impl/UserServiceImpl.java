package com.Recettes.recettes.service.impl;

import com.Recettes.recettes.model.User;
import com.Recettes.recettes.model.Recipe;
import com.Recettes.recettes.repository.UserRepository;
import com.Recettes.recettes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String userId, User updatedUser) {
        User existingUser = getUserByUserId(userId);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setImage(updatedUser.getImage());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String userId) {
        User user = getUserByUserId(userId);
        userRepository.delete(user);
    }

    @Override
    public List<Recipe> getRecipesByUserId(String userId) {
        User user = getUserByUserId(userId);
        return user.getRecipes();
    }
}
