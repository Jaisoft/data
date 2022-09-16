package com.jaisoft.datajdbc.repository;

import com.jaisoft.datajdbc.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void when_creat_user_then_get_user_id(){

        User user = new User();
        user.setUserName("Jaime");
        user.setUserEmail("jaime.gomez.moraleda@gmail.com");
        User userCreated = userRepository.save(user);
        System.err.println(userCreated);
        assertTrue(userCreated != null);


    }

}