package com.Recettes.recettes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "recettes")
public class Recette {

    @Id
    private String recipeId;
    private String titre;
    private String description;
    private String dureePreparation;
    private String dureeCuisson;

    @Field("tags")
    private List<Tag> tags = new ArrayList<>();

    @Field("ingredients")
    private List<Ingredient> ingredients = new ArrayList<>();

    @Field("etapes")
    private List<Etape> etapes = new ArrayList<>();

    @Field("comments")
    private List<Comment> comments = new ArrayList<>();

    @Field("authorId")
    private String authorId;

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDureePreparation() {
        return dureePreparation;
    }

    public void setDureePreparation(String dureePreparation) {
        this.dureePreparation = dureePreparation;
    }

    public String getDureeCuisson() {
        return dureeCuisson;
    }

    public void setDureeCuisson(String dureeCuisson) {
        this.dureeCuisson = dureeCuisson;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
