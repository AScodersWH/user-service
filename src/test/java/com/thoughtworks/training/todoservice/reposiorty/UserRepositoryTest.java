package com.thoughtworks.training.todoservice.reposiorty;

import com.thoughtworks.training.todoservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void findUserByName() {
        userRepository.save(new User(null, "zhang", "123"));
        Optional<User> user = userRepository.findUserByName("zhang");
        assertTrue(user.isPresent());
        assertThat(user.get().getName(), is("zhang"));
    }
}