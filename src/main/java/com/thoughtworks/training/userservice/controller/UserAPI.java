package com.thoughtworks.training.userservice.controller;

import com.thoughtworks.training.userservice.model.User;
import com.thoughtworks.training.userservice.service.UserService;
import groovy.util.logging.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j
@RestController
public class UserAPI {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getAllList() { return userService.getAll(); }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable int id) { userService.deleteUser(id); }


    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void register(@RequestBody User user) { userService.addUser(user); }

}
