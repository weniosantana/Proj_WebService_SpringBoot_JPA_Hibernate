package com.webservices.course.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservices.course.entities.Order;
import com.webservices.course.entities.User;
import com.webservices.course.repositories.OrderRepository;
import com.webservices.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jose", "jose@gmail.com", "119785732", "12345");
		User u2 = new User(null, "Joao", "joao@gmail.com", "119573474", "12345");
		
		Order o1 = new Order(null, Instant.parse("2024-02-16T09:55:42Z"), u1);
		Order o2 = new Order(null, Instant.parse("2024-02-16T09:58:12Z"), u2);
		Order o3 = new Order(null, Instant.parse("2024-02-16T10:03:37Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}
	
	
	
	
	
	
}
