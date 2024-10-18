package com.Recettes.recettes.controller;

import com.Recettes.recettes.model.User;
import com.Recettes.recettes.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        return userService.getUserById(objectId);
    }



    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        System.out.println("Fetched Users: " + users.size());
        return ResponseEntity.ok(users);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable ObjectId id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ObjectId id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
