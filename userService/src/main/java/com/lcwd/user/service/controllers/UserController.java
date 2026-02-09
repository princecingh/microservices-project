package com.lcwd.user.service.controllers;


import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


  //create user - post
  //get all user - get
  //get single user - get
     @PostMapping
    public ResponseEntity<User> createUser( @RequestBody User user){
         System.out.println("user controller called");
         System.out.println(user);
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }







}
