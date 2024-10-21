package com.Recettes.recettes.service;

import com.Recettes.recettes.model.Recipe;
import java.util.List;

public interface RecipeService {
    Recipe createRecipe(String userId, Recipe recipe);
    Recipe getRecipeById(String userId, String recipeId);
    List<Recipe> getAllRecipes(String userId);
    Recipe updateRecipe(String userId, String recipeId, Recipe updatedRecipe);
    void deleteRecipe(String userId, String recipeId);
}