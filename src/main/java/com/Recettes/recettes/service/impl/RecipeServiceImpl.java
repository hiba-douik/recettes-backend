package com.Recettes.recettes.service.impl;

import com.Recettes.recettes.model.Recipe;
import com.Recettes.recettes.model.User;
import com.Recettes.recettes.repository.UserRepository;
import com.Recettes.recettes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Recipe createRecipe(String userId, Recipe recipe) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        recipe.setRecipeId(UUID.randomUUID().toString());
        user.getRecipes().add(recipe);
        userRepository.save(user);
        return recipe;
    }

    @Override
    public Recipe getRecipeById(String userId, String recipeId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getRecipes().stream()
                .filter(recipe -> recipe.getRecipeId().equals(recipeId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    @Override
    public List<Recipe> getAllRecipes(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getRecipes();
    }

    @Override
    public Recipe updateRecipe(String userId, String recipeId, Recipe updatedRecipe) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Recipe recipe = user.getRecipes().stream()
                .filter(r -> r.getRecipeId().equals(recipeId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        recipe.setTitle(updatedRecipe.getTitle());
        recipe.setDescription(updatedRecipe.getDescription());
        recipe.setIngredients(updatedRecipe.getIngredients());
        recipe.setInstructions(updatedRecipe.getInstructions());

        userRepository.save(user);
        return recipe;
    }

    @Override
    public void deleteRecipe(String userId, String recipeId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.getRecipes().removeIf(recipe -> recipe.getRecipeId().equals(recipeId));
        userRepository.save(user);
    }
}