package com.Recettes.recettes.service.impl;

import com.Recettes.recettes.model.Recette;
import com.Recettes.recettes.repository.RecetteRepository;
import com.Recettes.recettes.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteServiceImpl implements RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    @Override
    public Recette createRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    @Override
    public List<Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    @Override
    public Recette getRecetteById(String id) {
        return recetteRepository.findById(id).orElse(null);
    }

    @Override
    public Recette updateRecette(String id, Recette recetteDetails) {
        Recette recette = getRecetteById(id);
        if (recette != null) {
            recette.setTitre(recetteDetails.getTitre());
            recette.setDescription(recetteDetails.getDescription());
            recette.setDureePreparation(recetteDetails.getDureePreparation());
            recette.setDureeCuisson(recetteDetails.getDureeCuisson());
            recette.setTags(recetteDetails.getTags());
            recette.setIngredients(recetteDetails.getIngredients());
            recette.setEtapes(recetteDetails.getEtapes());
            recette.setComments(recetteDetails.getComments());
            recette.setAuthorId(recetteDetails.getAuthorId());
            return recetteRepository.save(recette);
        }
        return null;
    }

    @Override
    public void deleteRecette(String id) {
        recetteRepository.deleteById(id);
    }

    @Override
    public List<Recette> searchRecettes(String titre, List<String> tags, List<String> ingredients) {
        return recetteRepository.findByTitreContainingOrTagsInOrIngredientsIn(titre, tags, ingredients);
    }
}
