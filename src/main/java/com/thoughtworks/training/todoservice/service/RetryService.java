package com.thoughtworks.training.todoservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thoughtworks.training.todoservice.model.User;
import com.thoughtworks.training.todoservice.utils.SpellChecker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RetryService {
    @Autowired
    public SpellChecker spellChecker;
    @HystrixCommand(fallbackMethod = "checkAllFallback")
    @Retryable(maxAttempts = 2002,backoff = @Backoff(1))
    public List<User> checkAll(List<User> users) {
        spellChecker.check(users,User::getName,User::setSuggestion);
        return users;
    }
//    @Recover
//    public List<Todo> recoverAll(RuntimeException e,List<Todo> todos){
//        log.info("recover");
//        return todos;
//    }

    public List<User> checkAllFallback(List<User> users){
        log.info("checkAllFallback");
        return users;

    }

}
