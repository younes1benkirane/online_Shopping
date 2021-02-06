package com.example.shopping.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.online.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByOrderByNameAsc();
	
	List<Product>  findByOrderByPriceAsc();
	
	List<Product> findByOrderByWeightAsc();

}
