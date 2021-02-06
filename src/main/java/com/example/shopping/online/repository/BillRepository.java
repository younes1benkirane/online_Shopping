package com.example.shopping.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.online.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{
	
	List<Bill> findByOrderByAmountAsc();

}
