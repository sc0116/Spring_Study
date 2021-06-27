package com.example.server.controller;

import com.example.server.domain.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public UserResponse hello(@RequestParam String name, @RequestParam int age) {
        UserResponse user = new UserResponse();
        user.setName(name);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public UserResponse post(@RequestBody UserResponse user, @PathVariable int userId, @PathVariable String userName) {
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("client req: {}", user);

        return user;
    }
}
