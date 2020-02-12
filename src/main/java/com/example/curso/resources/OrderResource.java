package com.example.curso.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.Order;
import com.example.curso.entities.User;
import com.example.curso.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		return ResponseEntity.ok().body(orderService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(Long id) {
		return ResponseEntity.ok().body(orderService.findById(id));
	}
}
