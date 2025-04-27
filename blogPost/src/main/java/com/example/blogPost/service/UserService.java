package com.example.blogPost.service;

import com.example.blogPost.dto.UserRegistrationRequest;
import com.example.blogPost.model.BlogUser;
import com.example.blogPost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public BlogUser registerUser(UserRegistrationRequest request) {
        BlogUser user = new BlogUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }
}
