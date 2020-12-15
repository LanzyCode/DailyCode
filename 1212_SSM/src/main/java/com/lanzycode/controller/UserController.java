package com.lanzycode.controller;

import com.lanzycode.domain.User;
import com.lanzycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{uuid}")
    public User get(@PathVariable Integer uuid){
        return userService.get(uuid);
    }
}
