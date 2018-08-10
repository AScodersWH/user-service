package com.thoughtworks.training.todoservice.service;

import com.thoughtworks.training.todoservice.model.User;
import com.thoughtworks.training.todoservice.reposiorty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public RetryService retryService;

    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    public List<User> getAll() {
        return  retryService.checkAll(userRepository.findAll());
    }

    public User loginCheck(String name, String password) {
        User user = userRepository.findFirstByName(name);
        if(new BCryptPasswordEncoder().matches(password, user.getPassword())){
            return user;
        }
        return null;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }


    public User verify(User user) {
        return userRepository.findFirstByName(user.getName());
    }
}
