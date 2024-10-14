package com.Recettes.recettes.repository;

import com.Recettes.recettes.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByUsernameContaining(String username);
}
