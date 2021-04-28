package com.chatapp.back.controller;

import com.chatapp.back.model.User;
import com.chatapp.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}