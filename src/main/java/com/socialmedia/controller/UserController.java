package com.socialmedia.controller;

import com.socialmedia.model.User;
import com.socialmedia.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("user-creation")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @PostMapping
    public ResponseEntity<User> handleUserCreation(@RequestBody(required = true) final User user) {

        final User createdUser = userService.createUser(user);

        if (user == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }
}
