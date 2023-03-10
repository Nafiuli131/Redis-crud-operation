package com.example.rediscrud.service;

import com.example.rediscrud.entity.User;
import com.example.rediscrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public ResponseEntity<User> addUser(User user) {
        User user1 = userRepository.save(user);
        return ResponseEntity.ok(user1);
    }

    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getByiD(Long id) {
        return userRepository.findById(id);
    }

    public ResponseEntity<String> deleteUser(Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
