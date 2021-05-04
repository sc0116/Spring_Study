package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {

        return account;
    }

    // JSON
    // req -> object mapper -> object -> method -> object -> object mapper -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {

        return user; //200 OK
    }

    //ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
