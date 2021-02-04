package com.online.shopping.online.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;

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
public class Bill {

	private Long amount;
	
	private Date creationDate;
	
	
//	Bill() {}
//
//	Bill(Long amount, Date creationDate) {
//
//	    this.amount = amount;
//	    this.creationDate = creationDate;
//	  }
//
//	  public Long getAmount() {
//	    return this.amount;
//	  }
//
//	  public Date getCreationDate() {
//	    return this.creationDate;
//	  }
//
//
//	  public void setAmount(Long amount) {
//	    this.amount = amount;
//	  }
//
//	  public void setCreationDate(Date creationDate) {
//	    this.creationDate = creationDate;
//	  }
//
//
//	  @Override
//	  public boolean equals(Object o) {
//
//	    if (this == o)
//	      return true;
//	    if (!(o instanceof Bill))
//	      return false;
//	    Bill bill = (Bill) o;
//	    return Objects.equals(this.amount, bill.amount) && Objects.equals(this.creationDate, bill.creationDate);
//	  }
//
//	  @Override
//	  public int hashCode() {
//	    return Objects.hash(this.amount, this.creationDate);
//	  }
//
//	  @Override
//	  public String toString() {
//	    return "Order{" + "amount=" + this.amount + ", creationDate='" + this.creationDate + '\'' + ", price='" + '\'' + '}';
//	  }
}
