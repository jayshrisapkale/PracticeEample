package com.example.user.controller;

import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
UserService userService;

@GetMapping("/get")
    public int getUser(){
    return userService.multi(2,4);
}

}
