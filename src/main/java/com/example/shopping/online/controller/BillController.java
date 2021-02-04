package com.example.shopping.online.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.online.repository.BillRepository;
import com.online.shopping.online.model.Bill;
import lombok.Getter;
import lombok.Setter;


@RestController
public class BillController {
	
	@Autowired
	@Getter
	@Setter
	private  BillRepository billRepository;
	
	@GetMapping("/billsByAmount")
	  List<Bill> BillsByAmount() {
	    return billRepository.findAllOrderByAmountAsc();
	  }
	


}
