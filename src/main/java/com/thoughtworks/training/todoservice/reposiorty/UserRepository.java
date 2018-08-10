package com.thoughtworks.training.todoservice.reposiorty;

import com.thoughtworks.training.todoservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByName(String name);

    User findFirstByName(String name);
}
