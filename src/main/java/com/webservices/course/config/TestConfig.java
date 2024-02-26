package com.webservices.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservices.course.entities.Category;
import com.webservices.course.entities.Order;
import com.webservices.course.entities.OrderItem;
import com.webservices.course.entities.Payment;
import com.webservices.course.entities.Product;
import com.webservices.course.entities.User;
import com.webservices.course.entities.enums.OrdersStatus;
import com.webservices.course.repositories.CategoryRepository;
import com.webservices.course.repositories.OrderItemRepository;
import com.webservices.course.repositories.OrderRepository;
import com.webservices.course.repositories.ProductRepository;
import com.webservices.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");  
		
		
		User u1 = new User(null, "Jose", "jose@gmail.com", "119785732", "12345");
		User u2 = new User(null, "Joao", "joao@gmail.com", "119573474", "12345");
		
		
		Order o1 = new Order(null, Instant.parse("2024-02-16T09:55:42Z"), OrdersStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-02-16T09:58:12Z"), OrdersStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-02-16T10:03:37Z"), OrdersStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Payment pay1 = new Payment(null, Instant.parse("2024-02-16T12:57:42Z"), o1);
		o1.setPayment(pay1); 
		
		orderRepository.save(o1);
		
	}
	
	
	
	
	
	
}
