package com.Recettes.recettes.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String recipeId;
    private String title;
    private String description;
    private List<String> ingredients = new ArrayList<>();
    private List<String> instructions = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();


    public Recipe() {}

    public Recipe(String recipeId, String title, String description) {
        this.recipeId = recipeId;
        this.title = title;
        this.description = description;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
