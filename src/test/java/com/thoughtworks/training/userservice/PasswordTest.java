package com.thoughtworks.training.userservice;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PasswordTest {

    @Test
    public void passwordTest() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("password"));
        String encodePass = encoder.encode("password");
        assertTrue(encoder.matches("password", encodePass));
        assertFalse(encoder.matches("passwordxx", encodePass));
    }
}
