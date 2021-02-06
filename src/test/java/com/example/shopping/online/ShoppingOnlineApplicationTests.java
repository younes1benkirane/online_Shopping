package com.example.shopping.online;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.shopping.online.controller.BillController;
import com.example.shopping.online.model.Bill;
import com.example.shopping.online.model.status;
import com.example.shopping.online.repository.BillRepository;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnit4.class)
public class ShoppingOnlineApplicationTests {

	@InjectMocks
	BillController billController;
	
	@Mock
	BillRepository billRepository;
	
	
	@Test
    public void testRequirements() 
    {
		List<Bill> bills=billRepository.findAll();
		for(Bill bill:bills) {
		if(bill.getOrder()!=null && (bill.getOrder().getProducts()!=null && bill.getOrder().getProducts().size()>0) ) {
		Long totalPrice =bill.getOrder().getProducts().stream().map(p -> p.getPrice()).reduce(null, null);
		Long weight=bill.getOrder().getProducts().stream().map(p -> p.getWeight()).reduce(null, null);
		if(totalPrice!=null && totalPrice>1000) {
		bill.setAmount((totalPrice*5)/100);
		}
		if(weight!=null ) {
			bill.getOrder().setShipment(weight*3);
		}
		
		}
		if(bill.getOrder().getStatus()!=null && status.paid.equals(bill.getOrder().getStatus())) {
			bill.setCreationDate(new Date());
			billRepository.save(bill);
		}
		when(bill.getOrder().getProducts().stream().map(p -> p.getPrice()).reduce(null, null)).thenReturn( 1200L);
		assertEquals(bill.getAmount(),60L);
		when(bill.getOrder().getProducts().stream().map(c -> c.getWeight()).reduce(null, null)).thenReturn( 1600L);
		assertEquals(bill.getOrder().getShipmentAmount(),4800L);
		assertEquals(bill.getOrder().getProducts().size(),1);
		}
	
		
		
	
		
    }
    
	

}
