package com.minet.crypto.repository;

import com.minet.crypto.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("John");
        user.setUserEmail("John@example.com");
        user.setPassword("secret");
        user.setStatus("active");

        userRepository.save(user);

        User savedUser = userRepository.findById(user.getId()).orElseThrow();
        assertNotNull(savedUser);
        assertEquals("John", savedUser.getUserName());

    }

}
