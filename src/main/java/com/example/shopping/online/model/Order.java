package com.example.shopping.online.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="orders")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long idOrder;
	
	
	@Column(name="order_status")
	private status status;
	  
	
	 @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
	          cascade = CascadeType.ALL)
	private List<Product> products=new ArrayList<>();
	  
	@Column(name="order_shipment_amount")
	private Long shipmentAmount;
	  
	  
		
		
	Order() {}

	public Order(status statu, List<Product> products,Long shipmentAmount) {

	    this.status = statu;
	    this.products =  products;
	    this.shipmentAmount=shipmentAmount;
	  }

		  public status getStatus() {
		    return this.status;
		  }
		  
		  @JsonIgnore
		  public List<Product> getProducts() {
		    return this.products;
		  }

		  public Long getShipmentAmount() {
		    return this.shipmentAmount;
		  }
		  

		  public void setStatus(status status) {
		    this.status = status;
	     }

		  public void setProducts(List<Product> prodcuts) {
		    this.products = products;
		  }

	  public void setShipment(Long shipmentAmount) {
	    this.shipmentAmount = shipmentAmount;
	  }

		  @Override
	  public boolean equals(Object o) {

		    if (this == o)
		      return true;
		    if (!(o instanceof Order))
		      return false;
		    Order order = (Order) o;
		    return Objects.equals(this.status, order.status) && Objects.equals(this.products, order.products)
		        && Objects.equals(this.shipmentAmount, order.shipmentAmount);
		  }

		  @Override
		  public int hashCode() {
		    return Objects.hash(this.status, this.products, this.shipmentAmount);
		  }

		  @Override
		  public String toString() {
		    return "Order{" + "id=" + this.status + ", products='" + this.products + '\'' + ", shipmentAmount='" + this.shipmentAmount + '\'' + '}';
		  }
}
