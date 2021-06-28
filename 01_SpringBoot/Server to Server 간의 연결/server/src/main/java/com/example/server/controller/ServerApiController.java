package com.example.server.controller;

import com.example.server.domain.Req;
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
    public Req<UserResponse> post(@RequestBody Req<UserResponse> user,
                             @PathVariable int userId,
                             @PathVariable String userName,
                             @RequestHeader("x-authorization") String authorization,
                             @RequestHeader("custom-header") String customHeader
    ) {
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("x-authorization : {}, custom-header: {}", authorization, customHeader);
        log.info("client req: {}", user);

        Req<UserResponse> response = new Req<>();
        response.setHeader(new Req.Header());
        response.setBody(user.getBody());


        return response;
    }
}
