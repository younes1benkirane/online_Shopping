package com.online.shopping.online.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;

import ch.qos.logback.core.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

	
	private status status;
	  
	  
	private List<Product> products;
	  
	 
	private String shipment;
	  
	  
		
		/**
		 * 
		 */
//		Order() {}
//
//		Order(String status, List<Product> products,String shipment) {
//
//		    this.status = status;
//		    this.products =  products;
//		    this.shipment=shipment;
//		  }
//
//		  public String getStatus() {
//		    return this.status;
//		  }
//
//		  public List<Product> getProducts() {
//		    return this.products;
//		  }
//
//		  public String getShipment() {
//		    return this.shipment;
//		  }
//		  
//
//		  public void setStatus(String status) {
//		    this.status = status;
//		  }
//
//		  public void setProducts(List<Product> prodcuts) {
//		    this.products = products;
//		  }
//
//		  public void setShipment(String shipment) {
//		    this.shipment = shipment;
//		  }
//
//		  @Override
//		  public boolean equals(Object o) {
//
//		    if (this == o)
//		      return true;
//		    if (!(o instanceof Order))
//		      return false;
//		    Order order = (Order) o;
//		    return Objects.equals(this.status, order.status) && Objects.equals(this.products, order.products)
//		        && Objects.equals(this.shipment, order.shipment);
//		  }
//
//		  @Override
//		  public int hashCode() {
//		    return Objects.hash(this.status, this.products, this.shipment);
//		  }
//
//		  @Override
//		  public String toString() {
//		    return "Order{" + "id=" + this.status + ", products='" + this.products + '\'' + ", shipment='" + this.shipment + '\'' + '}';
//		  }
}
