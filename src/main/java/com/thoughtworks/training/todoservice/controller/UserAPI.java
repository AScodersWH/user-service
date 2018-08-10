package com.thoughtworks.training.todoservice.controller;

import com.thoughtworks.training.todoservice.model.User;
import com.thoughtworks.training.todoservice.service.UserService;
import groovy.util.logging.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<User> getAllList() {
        return userService.getAll();
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getOne(Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable int id) {
//        userService.deleteItem(id);
    }

}
