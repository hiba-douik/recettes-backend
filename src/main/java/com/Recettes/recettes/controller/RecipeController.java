package com.Recettes.recettes.controller;

import com.Recettes.recettes.model.Recipe;
import com.Recettes.recettes.service.RecipeService;
import com.Recettes.recettes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}")
    public ResponseEntity<Recipe> createRecipe(@PathVariable String userId, @RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.createRecipe(userId, recipe);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable String userId, @PathVariable String recipeId) {
        Recipe recipe = recipeService.getRecipeById(userId, recipeId);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Recipe>> getUserRecipes(@PathVariable String userId) {
        List<Recipe> recipes = userService.getRecipesByUserId(userId);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @PutMapping("/{userId}/{recipeId}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable String userId, @PathVariable String recipeId, @RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeService.updateRecipe(userId, recipeId, recipe);
        return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{recipeId}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String userId, @PathVariable String recipeId) {
        recipeService.deleteRecipe(userId, recipeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}