package com.example.shopping.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.online.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAllOrderByNameAsc();
	
	List<Product>  findAllOrderByPriceAsc();
	
	List<Product> findAllOrderByWeightAsc();

}
