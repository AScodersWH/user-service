package com.thoughtworks.training.todoservice.controller;

import com.thoughtworks.training.todoservice.model.User;
import com.thoughtworks.training.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Verification {
    @Autowired
    private UserService userService;

    @PostMapping("/verify")
    public User verify(@RequestBody User user) {
        return userService.verify(user);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        return userService.loginCheck(user.getName(), user.getPassword());
    }
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        String passwordEncode = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(passwordEncode);
        userService.addUser(user);
    }

}
