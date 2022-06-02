package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
     UserService userService;

    @PostMapping("/save")
    public User inserUser(@RequestBody User user){
       return userService.insertUser(user);
    }
    @GetMapping("/getById/{id}")
    public User getUser(@PathVariable("id") Integer id) throws InterruptedException {
        Thread.sleep(4000);
        return userService.getUser(id);
    }
    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
