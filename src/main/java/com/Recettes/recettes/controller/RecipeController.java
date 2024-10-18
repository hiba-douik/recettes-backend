package com.Recettes.recettes.controller;

import com.Recettes.recettes.model.Recipe;
import com.Recettes.recettes.service.RecipeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public Recipe createRecipe(@PathVariable ObjectId userId, @RequestBody Recipe recipe) {
        return recipeService.createRecipe(userId, recipe);
    }

    @GetMapping("/{recipeId}")
    public Recipe getRecipeById(@PathVariable ObjectId userId, @PathVariable String recipeId) {
        return recipeService.getRecipeById(userId, recipeId);
    }

    @GetMapping
    public List<Recipe> getAllRecipes(@PathVariable ObjectId userId) {
        return recipeService.getAllRecipes(userId);
    }

    @PutMapping("/{recipeId}")
    public Recipe updateRecipe(@PathVariable ObjectId userId, @PathVariable String recipeId, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(userId, recipeId, recipe);
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable ObjectId userId, @PathVariable String recipeId) {
        recipeService.deleteRecipe(userId, recipeId);
        return ResponseEntity.noContent().build();
    }
}
