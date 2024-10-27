package com.projeto_DIO.api_demoDIO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projeto_DIO.api_demoDIO.model.User;
import com.projeto_DIO.api_demoDIO.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    // Método para adicionar usuários de teste
    @PostMapping("/addTestUsers")
    public List<User> addTestUsers() {
        List<User> users = List.of(
            new User("User 1", "user1@email.com"), // Certifique-se de que o User possui um construtor que aceita o nome
            new User("User 2", "user1@email.com"),
            new User("User 3", "user1@email.com")
        );
        return userRepository.saveAll(users);
    }
}
