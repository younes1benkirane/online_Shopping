package com.example.shopping.online.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.online.repository.OrderRepository;
import com.online.shopping.online.model.Order;
import lombok.Getter;
import lombok.Setter;

@RestController
public class OrderController {
	
	@Autowired
	@Getter
	@Setter
	private  OrderRepository orderRepository;
	
	@GetMapping("/orders")
	  List<Order> all() {
	    return orderRepository.findAll();
	  }
	
	@GetMapping("/orders/{id}")
	Optional<Order> one(@PathVariable Long id) {
	    return orderRepository.findById(id);
	  }
	
	
	@PostMapping("/orders")
	Order order(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	@DeleteMapping("/orders/{id}")
	  void deleteOrderById(@PathVariable Long id) {
	    orderRepository.deleteById(id);
	  }
	
	@DeleteMapping("/products")
	  void deleteOrder(@PathVariable Order order) {
	    orderRepository.delete(order);
	  }
	
	
	

}
