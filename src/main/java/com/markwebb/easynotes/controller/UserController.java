package com.markwebb.easynotes.controller;

import com.markwebb.easynotes.model.User;
import com.markwebb.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getAllNotes() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User createNote(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getNoteById(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        System.out.println("");
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateNote(@PathVariable(value = "id") Long noteId,
        @Valid @RequestBody User userDetails) {
        User user = userRepository.findOne(noteId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setName(userDetails.getName());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteNote(@PathVariable(value = "id") Long noteId) {
        User user = userRepository.findOne(noteId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
