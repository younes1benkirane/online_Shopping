package com.example.shopping.online.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name="products")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy =GenerationType.IDENTITY)
	 */
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long identifier;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_price")
	private Long price;
	
	@Column(name="product_weight")
	private Long weight;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
	private Order ordre;
	
	Product() {}

	public Product(String name,Long price,Long weight,Order ordre) {
		this.name = name;
	    this.price=price;
	    this.weight=weight;
	    this.ordre=ordre;
	  }

	  public Long getIdentifier() {
	    return this.identifier;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public Long getPrice() {
	    return this.price;
	  }
	  
	  public Long getWeight() {
	    return this.weight;
		  }
	  
	  
	  @JsonIgnore
	  public Order getOrder() {
		return ordre;
	}

	public void setIdentifier(Long identifier) {
	    this.identifier = identifier;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public void setPrice(Long price) {
	    this.price = price;
	  }
	  
		public void setWeight(Long weight) {
		this.weight = weight;
	}

		public void setOrder(Order order) {
			this.ordre = order;
		}

	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Product))
	      return false;
	    Product product = (Product) o;
	    return Objects.equals(this.identifier, product.identifier) && Objects.equals(this.name, product.name)
	        && Objects.equals(this.price, product.price) && Objects.equals(this.weight, product.weight);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.identifier, this.name, this.price,this.price);
	  }

	  @Override
	  public String toString() {
	    return "Product{" + "id=" + this.identifier + ", name='" + this.name + '\'' + ", price='" + this.price +", weight='" + this.weight+ '\'' + '}';
	  }
	
}

