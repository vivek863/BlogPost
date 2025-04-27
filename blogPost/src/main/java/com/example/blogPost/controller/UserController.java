package com.example.blogPost.controller;

import com.example.blogPost.dto.UserRegistrationRequest;
import com.example.blogPost.model.User;
import com.example.blogPost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationRequest request) {
        userService.registerUser(request);
        return "User registered successfully!";
    }
}
