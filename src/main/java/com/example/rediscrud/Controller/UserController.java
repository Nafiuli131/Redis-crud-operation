package com.example.rediscrud.Controller;

import com.example.rediscrud.entity.User;
import com.example.rediscrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/redis")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id ){
        return userService.getByiD(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
