package com.jaisoft.datajpa.repository;

import com.jaisoft.datajpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void test_repository(){
        User user = new User();
        user.setUserName("Pepe");
        User userCreated = userRepository.save(user);
        assertTrue(userCreated != null);
    }

}