package com.example.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.enums.OrderStatus;
import com.example.curso.entities.Order;
import com.example.curso.entities.User;
import com.example.curso.repositories.OrderRepository;
import com.example.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
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
	}
}
