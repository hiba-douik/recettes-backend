package com.Recettes.recettes.service;

import com.Recettes.recettes.model.Recipe;
import com.Recettes.recettes.model.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(ObjectId id);
    List<User> getAllUsers();
    User updateUser(ObjectId id, User user);
    void deleteUser(ObjectId id);
    User addRecipeToUser(ObjectId userId, Recipe recipe);
    User removeRecipeFromUser(ObjectId userId, String recipeId);
}
