package com.example.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(Arrays.asList(
			new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"),
			new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456")
		));
	}
}
