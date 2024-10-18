package com.Recettes.recettes.service;

import com.Recettes.recettes.model.Recipe;
import org.bson.types.ObjectId;

import java.util.List;

public interface RecipeService {
    Recipe createRecipe(ObjectId userId, Recipe recipe);
    Recipe getRecipeById(ObjectId userId, String recipeId);
    List<Recipe> getAllRecipes(ObjectId userId);
    Recipe updateRecipe(ObjectId userId, String recipeId, Recipe recipe);
    void deleteRecipe(ObjectId userId, String recipeId);
}
