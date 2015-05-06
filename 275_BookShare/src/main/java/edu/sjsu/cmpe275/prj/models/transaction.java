package edu.sjsu.cmpe275.prj.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class transaction implements Serializable {
	
	
	private static final long serialVersionUID = 1L;



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TransactionID")
    private int transactionId;
    
    
    
    @ManyToOne
   	@JoinColumn(name = "bookId")
   	private book book;
    
    @ManyToOne
   	@JoinColumn(name = "userId")
   	private user user;
    
    
  
    
    
    
    
    @Column(name = "price")
    private double price;

    @Column(name = "TransactionTime")
    private Date transactionTime;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public book getBook() {
		return book;
	}

	public void setBook(book book) {
		this.book = book;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
    
    


	
}
