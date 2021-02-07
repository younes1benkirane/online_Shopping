package com.example.shopping.online.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.online.model.Order;
import com.example.shopping.online.repository.OrderRepository;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
public class OrderController {
	
	@Autowired
	  OrderRepository orderRepository;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		try {
		List<Order> orders = new ArrayList<>();

		orderRepository.findAll().forEach(orders::add);

		if (orders.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(orders, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") long id) {
		Optional<Order> OrdersData = orderRepository.findById(id);

		if (OrdersData.isPresent()) {
			return new ResponseEntity<>(OrdersData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		try {
			Order _order = orderRepository
					.save(new Order(order.getStatus(), order.getShipmentAmount(),order.getTotalAmount()));
			return new ResponseEntity<>(_order, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		/*
		 * @PostMapping("/updateOrders") void updateOrder(@PathVariable Long id) { Order
		 * order = orderRepository.findById(id).get(); order.setStatus(null);
		 * orderRepository.save(order); }
		 */
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<HttpStatus> deleteOrderById(@PathVariable("id") long id) {
		try {
			orderRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/order")
	public ResponseEntity<HttpStatus> deleteOrder(@RequestBody Order order) {
		try {
			orderRepository.delete(order);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/orders")
	public ResponseEntity<HttpStatus> deleteOrders() {
		try {
			orderRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

}
