package com.socialmedia.controller;

import com.socialmedia.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {
    @PostMapping
    ResponseEntity<User> handleUserCreation(@RequestBody(required = true) User user);
}
