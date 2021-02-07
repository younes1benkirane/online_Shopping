package com.example.shopping.online;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.shopping.online.controller.OrderController;
import com.example.shopping.online.model.Bill;
import com.example.shopping.online.model.Order;
import com.example.shopping.online.model.Product;
import com.example.shopping.online.model.status;
import com.example.shopping.online.repository.OrderRepository;


@ExtendWith(MockitoExtension.class)
@RunWith(EasyMockRunner.class)
public class ShoppingOnlineApplicationTests {

	
	
	
	
	
	OrderRepository orderRepository = mock(OrderRepository.class);
	
	@TestSubject
	OrderController orderController = new OrderController();
	
	
		
		@Test
	    public void testRequirementOneKO() throws Exception
	    {
			
			Order ordre=new Order(status.pending, 1000L,1200L);
			ordre.setIdOrder(1L);
			Product product=new Product("lait", 8L, 2L,ordre);
			product.setIdentifier(0L);
			Product produit=new Product("baguette", 6L, 1L,ordre);
			produit.setIdentifier(1L);
			Product produit1=new Product("tomate", 80L, 40L,ordre);
			produit1.setIdentifier(2L);
			Product produit2=new Product("pommes de terre",30L,20L,ordre);
			produit2.setIdentifier(3L);
			Product produit3=new Product("bananes", 40L, 20L,ordre);
			produit3.setIdentifier(4L);
			Product produit4=new Product("clementine", 50L, 25L,ordre);
			produit4.setIdentifier(5L);
			Product produit5=new Product("orange",50L,25L,ordre);
			produit5.setIdentifier(6L);
			Product produit6=new Product("oignons",200L,200L,ordre);
			produit6.setIdentifier(7L);
			List<Product> products=new ArrayList<>();
			products.addAll(Arrays.asList(product,produit,produit1,produit2,produit3,produit4,produit5,produit6));
			ordre.setProducts(products);
			Bill bill=new Bill(1200L,new Date(),ordre);
			bill.setIdBill(1L);
			Optional<Long> totalPrice =bill.getOrdered().getProducts().stream().map(p -> p.getPrice()).reduce((x, y) -> x + y);
			assertNotNull(totalPrice);
			assert(totalPrice.get()<1000);
			assertEquals(bill.getAmount(), 1200L);
	    }
		
		@Test
	    public void testRequirementOneOK() throws Exception
	    {
			
			Order ordre=new Order(status.pending, 1000L,1200L);
			ordre.setIdOrder(1L);
			Product product=new Product("lait", 8L, 2L,ordre);
			product.setIdentifier(0L);
			Product produit=new Product("baguette", 6L, 1L,ordre);
			produit.setIdentifier(1L);
			Product produit1=new Product("tomate", 80L, 40L,ordre);
			produit1.setIdentifier(2L);
			Product produit2=new Product("pommes de terre",30L,20L,ordre);
			produit2.setIdentifier(3L);
			Product produit3=new Product("bananes", 40L, 20L,ordre);
			produit3.setIdentifier(4L);
			Product produit4=new Product("clementine", 50L, 25L,ordre);
			produit4.setIdentifier(5L);
			Product produit5=new Product("orange",50L,25L,ordre);
			produit5.setIdentifier(6L);
			Product produit6=new Product("oignons",200L,200L,ordre);
			produit6.setIdentifier(7L);
			Product produit7=new Product("kiwi", 750L, 250L,ordre);
			produit7.setIdentifier(8L);
			List<Product> products=new ArrayList<>();
			products.addAll(Arrays.asList(product,produit,produit1,produit2,produit3,produit4,produit5,produit6,produit7));
			ordre.setProducts(products);
			Bill bill=new Bill(1200L,new Date(),ordre);
			bill.setIdBill(1L);
			Optional<Long> totalPrice =bill.getOrdered().getProducts().stream().map(p -> p.getPrice()).reduce((x, y) -> x + y);
			assertNotNull(totalPrice);
			assert(totalPrice.get()>1000);
			bill.setAmount((long) (bill.getAmount()*(0.95)));
			System.out.println(bill.getAmount());
			assertEquals(bill.getAmount(), 1140L);
	    }
		
		@Test
		public void testRequirement2_OK() throws Exception{
			
			Order ordre=new Order(status.pending, 1000L,1200L);
			ordre.setIdOrder(1L);
			Product product=new Product("lait", 8L, 2L,ordre);
			product.setIdentifier(0L);
			Product produit=new Product("baguette", 6L, 1L,ordre);
			produit.setIdentifier(1L);
			Product produit1=new Product("tomate", 80L, 40L,ordre);
			produit1.setIdentifier(2L);
			Product produit2=new Product("pommes de terre",30L,20L,ordre);
			produit2.setIdentifier(3L);
			Product produit3=new Product("bananes", 40L, 20L,ordre);
			produit3.setIdentifier(4L);
			Product produit4=new Product("clementine", 50L, 25L,ordre);
			produit4.setIdentifier(5L);
			Product produit5=new Product("orange",50L,25L,ordre);
			produit5.setIdentifier(6L);
			Product produit6=new Product("oignons",200L,200L,ordre);
			produit6.setIdentifier(7L);
			Product produit7=new Product("kiwi", 750L, 250L,ordre);
			produit7.setIdentifier(8L);
			List<Product> products=new ArrayList<>();
			products.addAll(Arrays.asList(product,produit,produit1,produit2,produit3,produit4,produit5,produit6,produit7));
			ordre.setProducts(products);
			Bill bill=new Bill(1200L,new Date(),ordre);
			bill.setIdBill(1L);
			Optional<Long> totalWeight =bill.getOrdered().getProducts().stream().map(p -> p.getWeight()).reduce((x, y) -> x + y);
			assertNotNull(totalWeight);
			ordre.setShipmentAmount (totalWeight.get()*3);
			System.out.println(ordre.getShipmentAmount());
			assertEquals(ordre.getShipmentAmount(), totalWeight.get()*3);
		}
		
		@Test
		public void testRequirement2_KO() throws Exception{
			
			Order ordre=new Order(status.pending, 1000L,1200L);
			ordre.setIdOrder(1L);
			Product product=new Product("lait", 8L, 2L,ordre);
			product.setIdentifier(0L);
			Product produit=new Product("baguette", 6L, 1L,ordre);
			produit.setIdentifier(1L);
			Product produit1=new Product("tomate", 80L, 40L,ordre);
			produit1.setIdentifier(2L);
			Product produit2=new Product("pommes de terre",30L,20L,ordre);
			produit2.setIdentifier(3L);
			Product produit3=new Product("bananes", 40L, 20L,ordre);
			produit3.setIdentifier(4L);
			Product produit4=new Product("clementine", 50L, 25L,ordre);
			produit4.setIdentifier(5L);
			Product produit5=new Product("orange",50L,25L,ordre);
			produit5.setIdentifier(6L);
			Product produit6=new Product("oignons",200L,200L,ordre);
			produit6.setIdentifier(7L);
			Product produit7=new Product("kiwi", 750L, 250L,ordre);
			produit7.setIdentifier(7L);
			List<Product> products=new ArrayList<>();
			products.addAll(Arrays.asList(product,produit,produit1,produit2,produit3,produit4,produit5,produit6,produit7));
			ordre.setProducts(products);
			Bill bill=new Bill(1200L,new Date(),ordre);
			bill.setIdBill(1L);
			Optional<Long> totalWeight =bill.getOrdered().getProducts().stream().map(p -> p.getWeight()).reduce((x, y) -> x + y);
			assertNotNull(totalWeight);
			ordre.setShipmentAmount (80L);
			System.out.println(ordre.getShipmentAmount());
			assertNotEquals(ordre.getShipmentAmount(), totalWeight.get()*3);
		}
	
		@Test
		public void testRequirement3_KO() throws Exception{
			
			Order ordre=new Order(status.pending, 1000L,1200L);
			ordre.setIdOrder(1L);
			Bill bill;
			if(status.paid.equals(ordre.getStatus())) {
				bill=new Bill();
			}else {
				bill=null;
			}
			assertThatNullPointerException();
		}
		
		@Test
		public void testRequirement3_OK() throws Exception{
			
			Order ordre=new Order(status.paid, 1000L,1200L);
			ordre.setIdOrder(1L);
			Bill bill;
			if(status.paid.equals(ordre.getStatus())) {
				bill=new Bill();
			}else {
				bill=null;
			}
			assertNotNull(bill);
		}
		
		@Test
		public void testRequirement5_KO() throws Exception{
			
			Order ordre=new Order(status.pending, 1000L,1200L);
			ordre.setIdOrder(1L);
			List<Product> produits=new ArrayList<>();
			ordre.setProducts(produits);
			assertNotEquals(ordre.getProducts().size(), 1);
		}
		
		
		@Test
		public void testRequirement5_OK() throws Exception{
			
			Order ordre=new Order(status.pending, 1000L,1200L);
			ordre.setIdOrder(1L);
			List<Product> produits=new ArrayList<>();
			Product product=new Product("lait", 8L, 2L,ordre);
			product.setIdentifier(0L);
			Product produit=new Product("baguette", 6L, 1L,ordre);
			product.setIdentifier(1L);
			produits.addAll(Arrays.asList(product,produit));
			ordre.setProducts(produits);
			assertTrue(ordre.getProducts().size()>=1 );
		}
		
		@Test
		public void testRequirement4_KO() throws Exception{
			
			Order ordre=new Order(status.pending, 1000L,1200L);
			ordre.setIdOrder(0L);
			Order ordre2=new Order(status.pending, 1000L,1200L);
			ordre2.setIdOrder(2L);
			if(!status.paid.equals(ordre.getStatus())) {

			    orderController.deleteOrder(ordre);

			    verify(orderRepository, times(ordre.getIdOrder().intValue())).delete(ordre2);
			}	
			
				
		}
		
    
    
	

}
