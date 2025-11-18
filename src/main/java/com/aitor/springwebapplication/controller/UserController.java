package com.aitor.springwebapplication.controller;

import com.aitor.springwebapplication.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/")
    public List<User> getAllUsers(){
        return new LinkedList<>();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return new User(id);
    }
}
