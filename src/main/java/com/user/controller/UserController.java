package com.user.controller;

import com.user.config.JwtConfig;
import com.user.entity.User;
import com.user.request.UserRequest;
import com.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;
    private final JwtConfig jwtConfig;
    @PostMapping
    public User createUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserRequest userRequest) {
        return userService.login(userRequest);
    }
}
