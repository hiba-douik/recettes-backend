package com.Recettes.recettes.service.impl;

import com.Recettes.recettes.model.Recipe;
import com.Recettes.recettes.model.User;
import com.Recettes.recettes.repository.UserRepository;
import com.Recettes.recettes.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(ObjectId id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }



    @Override
    public User updateUser(ObjectId id, User user) {
        User existingUser = getUserById(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }


    @Override
    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }

    @Override
    public User addRecipeToUser(ObjectId userId, Recipe recipe) {
        User user = getUserById(userId);
        user.getRecipes().add(recipe);
        return userRepository.save(user);
    }

    @Override
    public User removeRecipeFromUser(ObjectId userId, String recipeId) {
        User user = getUserById(userId);
        user.getRecipes().removeIf(recipe -> recipe.getRecipeId().equals(recipeId));
        return userRepository.save(user);
    }
}
