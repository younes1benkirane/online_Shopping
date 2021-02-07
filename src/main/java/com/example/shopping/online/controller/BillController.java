package com.example.shopping.online.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.online.model.Bill;
import com.example.shopping.online.repository.BillRepository;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
public class BillController {
	
	@Autowired
	BillRepository billRepository;
	
	@GetMapping("/billsByAmount")
	public ResponseEntity<List<Bill>> SortBillsByAmount() {
		try {
			List<Bill> bills = billRepository.findByOrderByAmountAsc();

			if (bills.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(bills, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	
	@PostMapping("/bills")
	public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
		try {
			Bill _bill = billRepository
					.save(new Bill(bill.getAmount(), bill.getCreationDate(),bill.getOrdered()));
			return new ResponseEntity<>(_bill, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	


}
