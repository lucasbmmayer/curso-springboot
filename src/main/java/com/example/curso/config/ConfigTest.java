package com.example.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.Category;
import com.example.curso.entities.Order;
import com.example.curso.entities.Product;
import com.example.curso.entities.User;
import com.example.curso.entities.enums.OrderStatus;
import com.example.curso.repositories.CategoryRepository;
import com.example.curso.repositories.OrderRepository;
import com.example.curso.repositories.ProductRepository;
import com.example.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(Arrays.asList(
			new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"),
			new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456")
		));
		orderRepository.saveAll(Arrays.asList(
			new Order(null, Instant.parse("2019-06-20T19:53:07Z"), userRepository.findById(1L).get(), OrderStatus.PAID),
			new Order(null, Instant.parse("2019-07-21T03:42:10Z"), userRepository.findById(2L).get(), OrderStatus.WAITING_PAYMENT),
			new Order(null, Instant.parse("2019-07-22T15:21:22Z"), userRepository.findById(1L).get(), OrderStatus.WAITING_PAYMENT)
		));
		categoryRepository.saveAll(Arrays.asList(
			new Category(null, "Electronics"),
			new Category(null, "Books"),
			new Category(null, "Computers")
		));
		
		var p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		p1.getCategories().add(categoryRepository.findById(2L).get());
		var p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		p2.getCategories().add(categoryRepository.findById(1L).get());
		p2.getCategories().add(categoryRepository.findById(3L).get());
		var p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		p3.getCategories().add(categoryRepository.findById(3L).get());
		var p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		p4.getCategories().add(categoryRepository.findById(3L).get());
		var p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		p5.getCategories().add(categoryRepository.findById(2L).get());
		
		productRepository.saveAll(Arrays.asList(
			p1,p2,p3,p4,p5
		));
	}
}
