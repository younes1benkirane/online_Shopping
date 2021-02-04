package com.online.shopping.online.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Product {
	@Id
	@GeneratedValue
	private Long identifier;
	
	private String name;
	
	private Long price;
	
	private Long weight;
	
//	Product() {}
//
//	Product(String identifier, String name,Long price,Long weight) {
//
//	    this.identifier = identifier;
//	    this.name = name;
//	  }
//
//	  public String getIdentifier() {
//	    return this.identifier;
//	  }
//
//	  public String getName() {
//	    return this.name;
//	  }
//
//	  public Long getPrice() {
//	    return this.price;
//	  }
//	  
//	  public Long getWeight() {
//		    return this.weight;
//		  }
//
//	  public void setIdentifier(String identifier) {
//	    this.identifier = identifier;
//	  }
//
//	  public void setName(String name) {
//	    this.name = name;
//	  }
//
//	  public void setPrice(Long price) {
//	    this.price = price;
//	  }
//
//	  @Override
//	  public boolean equals(Object o) {
//
//	    if (this == o)
//	      return true;
//	    if (!(o instanceof Product))
//	      return false;
//	    Product product = (Product) o;
//	    return Objects.equals(this.identifier, product.identifier) && Objects.equals(this.name, product.name)
//	        && Objects.equals(this.price, product.price) && Objects.equals(this.weight, product.weight);
//	  }
//
//	  @Override
//	  public int hashCode() {
//	    return Objects.hash(this.identifier, this.name, this.price,this.price);
//	  }
//
//	  @Override
//	  public String toString() {
//	    return "Product{" + "id=" + this.identifier + ", name='" + this.name + '\'' + ", price='" + this.price +", weight='" + this.weight+ '\'' + '}';
//	  }
	
}

