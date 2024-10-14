package com.Recettes.recettes.controller;

import com.Recettes.recettes.model.Recette;
import com.Recettes.recettes.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recettes")
public class RecetteController {

    @Autowired
    private RecetteRepository recetteRepository;

    @PostMapping
    public ResponseEntity<Recette> createRecette(@RequestBody Recette recette) {
        Recette savedRecette = recetteRepository.save(recette);
        return new ResponseEntity<>(savedRecette, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Recette>> getAllRecettes() {
        List<Recette> recettes = recetteRepository.findAll();
        return new ResponseEntity<>(recettes, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Recette> getRecetteById(@PathVariable String id) {
        Optional<Recette> recette = recetteRepository.findById(id);
        return recette.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Recette> updateRecette(@PathVariable String id, @RequestBody Recette recetteDetails) {
        Optional<Recette> optionalRecette = recetteRepository.findById(id);
        if (optionalRecette.isPresent()) {
            Recette recette = optionalRecette.get();
            recette.setTitre(recetteDetails.getTitre());
            recette.setDescription(recetteDetails.getDescription());
            recette.setDureePreparation(recetteDetails.getDureePreparation());
            recette.setDureeCuisson(recetteDetails.getDureeCuisson());
            recette.setTags(recetteDetails.getTags());
            recette.setIngredients(recetteDetails.getIngredients());
            recette.setEtapes(recetteDetails.getEtapes());
            recette.setComments(recetteDetails.getComments());
            recette.setAuthorId(recetteDetails.getAuthorId());

            Recette updatedRecette = recetteRepository.save(recette);
            return new ResponseEntity<>(updatedRecette, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable String id) {
        if (recetteRepository.existsById(id)) {
            recetteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/search")
    public ResponseEntity<List<Recette>> searchRecettes(
            @RequestParam(required = false) String titre,
            @RequestParam(required = false) List<String> tags,
            @RequestParam(required = false) List<String> ingredients) {

        List<Recette> filteredRecettes = recetteRepository.findByTitreContainingOrTagsInOrIngredientsIn(titre, tags, ingredients);
        return new ResponseEntity<>(filteredRecettes, HttpStatus.OK);
    }
}
