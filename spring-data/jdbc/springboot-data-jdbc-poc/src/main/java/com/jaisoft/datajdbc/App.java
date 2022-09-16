package com.jaisoft.datajdbc;

import com.jaisoft.datajdbc.model.User;
import com.jaisoft.datajdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class App implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUserName("Jaime");
		user.setUserEmail("jaime.gomez.moraleda@gmail.com");
		User userCreated = userRepository.save(user);
		System.err.println(userCreated);
	}
}
