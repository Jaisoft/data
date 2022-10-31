package com.example.springbootmongodbmongobee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
    UserRepository userRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		    User user = new User();
			user.setUserName("Jaime");
            User insertedUser = userRepository.save(user);
            System.out.println(insertedUser.getUserName());
		
	}

}
