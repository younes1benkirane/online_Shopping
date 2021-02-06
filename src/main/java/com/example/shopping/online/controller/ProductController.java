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

import com.example.shopping.online.model.Product;
import com.example.shopping.online.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
public class ProductController {

	
	@Autowired
	  ProductRepository productRepository;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
		List<Product> products = new ArrayList<>();

		productRepository.findAll().forEach(products::add);

		if (products.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(products, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getOrderById(@PathVariable("id") long id) {
		Optional<Product> productsData = productRepository.findById(id);

		if (productsData.isPresent()) {
			return new ResponseEntity<>(productsData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/productsByName")
	public ResponseEntity<List<Product>> SortProductsByName() {
		try {
			List<Product> products = productRepository.findByOrderByNameAsc();

			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	
	@GetMapping("/productsByPrice")
	public ResponseEntity<List<Product>> sortProductsByPrice() {
			try {
				List<Product> products = productRepository.findByOrderByPriceAsc();

				if (products.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(products, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	  }
	
	@GetMapping("/productsByWeght")
		public ResponseEntity<List<Product>> sortProductsByWeight() {
			try {
				List<Product> products = productRepository.findByOrderByWeightAsc();

				if (products.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(products, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	  }
	  
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		try {
			Product _product = productRepository
					.save(new Product(product.getName(), product.getPrice(),product.getWeight(),product.getOrder()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProductById(@PathVariable("id") long id) {
		try {
			productRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/product")
	public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Product product) {
		try {
			productRepository.delete(product);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/products")
	public ResponseEntity<HttpStatus> deleteProducts() {
		try {
			productRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
