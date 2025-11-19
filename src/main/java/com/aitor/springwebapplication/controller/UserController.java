package com.aitor.springwebapplication.controller;

import com.aitor.springwebapplication.dto.UserRequestTo;
import com.aitor.springwebapplication.dto.UserResponseTo;
import com.aitor.springwebapplication.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Validated
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/")
    public List<UserResponseTo> getAllUsers(){
        return new LinkedList<>();
    }

    @GetMapping("/{id}")
    public UserResponseTo getById(@PathVariable String id){
        return new UserResponseTo("asd", "dfs", "dfsd");
    }

    @PostMapping("/")
    public UserResponseTo getById(@RequestBody UserRequestTo user){
        return new UserResponseTo("asd", "dfs", "dfsd");
    }

    @PutMapping("/{id}")
    public UserResponseTo put(@PathVariable String id, @RequestBody User user){
        return new UserResponseTo("asd", "dfs", "dfsd");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {

    }
}
