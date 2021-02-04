package com.example.shopping.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.online.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
