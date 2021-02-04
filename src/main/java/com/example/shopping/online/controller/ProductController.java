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

import com.example.shopping.online.repository.ProductRepository;
import com.online.shopping.online.model.Product;

import lombok.Getter;
import lombok.Setter;


@RestController
public class ProductController {

	
	@Autowired
	@Getter
	@Setter
	private  ProductRepository productRepository;
	
	@GetMapping("/products")
	  List<Product> all() {
	    return productRepository.findAll();
	  }
	
	@GetMapping("/products/{id}")
	Optional<Product> one(@PathVariable Long id) {
	    return productRepository.findById(id);
	  }
	
	
	@GetMapping("/productsByName")
	List<Product> sortProductsByName () {
	    return productRepository.findAllOrderByNameAsc();
	  }
	
	@GetMapping("/productsByPrice")
	List<Product> sortProductsByPrice () {
	    return productRepository.findAllOrderByPriceAsc();
	  }
	
	@GetMapping("/productsByWeght")
	List<Product> sortProductsByWeight () {
	    return productRepository.findAllOrderByWeightAsc();
	  }
	
	@PostMapping("/products")
	Product product(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/products/{id}")
	  void deleteProductById(@PathVariable Long id) {
	    productRepository.deleteById(id);
	  }
	
	@DeleteMapping("/products")
	  void deleteProduct(@PathVariable Product product) {
	    productRepository.delete(product);
	  }
	
	
	
}
