package com.example.shopping.online.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name="bills")
public class Bill implements Serializable{
	
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
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="idbill")
	private Long idBill;

	@Column(name="bill_amount")
	private Long amount;
	
	@Column(name="bill_creation_date")
	private Date creationDate;
	
	
	
	@OneToOne
	private Order ordered;
	
	
	public Bill() {}

	public Bill(Long amount, Date creationDate,Order order) {

	    this.amount = amount;
	    this.creationDate = creationDate;
	    this.ordered=order;
	  }

	  public Long getAmount() {
	    return this.amount;
	  }

	  public Date getCreationDate() {
	    return this.creationDate;
	  }


	  public void setAmount(Long amount) {
	    this.amount = amount;
	  }

	  public void setCreationDate(Date creationDate) {
	    this.creationDate = creationDate;
	  }
	  
	  @JsonIgnore
	  public Order getOrdered() {
			return ordered;
		}

		public void setOrdered(Order ordered) {
			this.ordered = ordered;
		}

	public Long getIdBill() {
			return idBill;
		}

		public void setIdBill(Long idBill) {
			this.idBill = idBill;
		}

	@Override
	  public boolean equals(Object o) {

    if (this == o)
	      return true;
    if (!(o instanceof Bill))
	      return false;
	    Bill bill = (Bill) o;
	    return Objects.equals(this.amount, bill.amount) && Objects.equals(this.creationDate, bill.creationDate);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.amount, this.creationDate);
	  }

	  @Override
	  public String toString() {
	    return "Order{" + "amount=" + this.amount + ", creationDate='" + this.creationDate + '\'' + ", price='" + '\'' + '}';
	  }

}
