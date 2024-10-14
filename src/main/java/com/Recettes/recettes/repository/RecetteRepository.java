package com.Recettes.recettes.repository;

import com.Recettes.recettes.model.Recette;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecetteRepository extends MongoRepository<Recette, String> {

    @Query("{ 'titre': { $regex: ?0, $options: 'i' } }")
    List<Recette> findByTitreContaining(String titre);

    List<Recette> findByTagsIn(List<String> tags);

    List<Recette> findByIngredientsIn(List<String> ingredients);

    List<Recette> findByTitreContainingOrTagsInOrIngredientsIn(String titre, List<String> tags, List<String> ingredients);
}
