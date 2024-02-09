package com.webservices.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservices.course.entities.User;
import com.webservices.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jose", "jose@gmail.com", "119785732", "12345");
		User u2 = new User(null, "Joao", "joao@gmail.com", "119573474", "12345");
		User u3 = new User(null, "Maria", "maria@gmail.com", "119674734", "12345");
		
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		
	}
	
	
	
	
	
	
}
