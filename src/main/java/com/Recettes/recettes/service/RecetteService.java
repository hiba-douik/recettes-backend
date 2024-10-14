package com.Recettes.recettes.service;

import com.Recettes.recettes.model.Recette;

import java.util.List;

public interface RecetteService {
    Recette createRecette(Recette recette);
    List<Recette> getAllRecettes();
    Recette getRecetteById(String id);
    Recette updateRecette(String id, Recette recetteDetails);
    void deleteRecette(String id);
    List<Recette> searchRecettes(String titre, List<String> tags, List<String> ingredients);
}
