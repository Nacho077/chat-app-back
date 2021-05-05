package com.chatapp.back.controller;

import com.chatapp.back.model.User;
import com.chatapp.back.model.UserDTO;
import com.chatapp.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}/contacts/{idNewContact}")
    public void addContact(@PathVariable Integer id, @PathVariable Integer idNewContact){
        userService.addContact(id, idNewContact);
    }

    @GetMapping("/{id}/contacts")
    public List<UserDTO> getContacts(@PathVariable Integer id){
        return userService.getContact(id);
    }
}