package com.example.curso.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
}
