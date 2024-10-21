package com.Recettes.recettes.repository;

import com.Recettes.recettes.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByUserId(String userId);
    Optional<User> findByEmail(String email); // Ajout pour chercher par email
    Optional<User> findByUsername(String username);
}