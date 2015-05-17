package edu.sjsu.cmpe275.prj.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class bid implements Serializable {
	
	/**
	 * 
	 */
	

	// Persistent Fields:
	
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "BID")
	    private int bId;
	
	
  
	
	 @ManyToOne
	@JoinColumn(name = "buyerId")
	private user buyer;

    
	   @ManyToOne
	   @JoinColumn(name = "sellerId")
	    private user seller;
	
    
	   @JoinColumn(name = "bookid")
	    private book book;
    
    
    
    @Column(name = "Price")
    private double price;
	

   
    
    @Column(name = "BookTime")
    private Date bookTime;
    
    public Date getBookTime() {
		return bookTime;
	}


	public void setBookTime(Date date) {
		this.bookTime = date;
	}


	@Column(name = "Active")
    private int active;

	public int getbId() {
		return bId;
	}


	public void setbId(int bId) {
		this.bId = bId;
	}


	public user getBuyer() {
		return buyer;
	}


	public void setBuyer(user buyer) {
		this.buyer = buyer;
	}


	public user getSeller() {
		return seller;
	}


	public void setSeller(user seller) {
		this.seller = seller;
	}


	public book getBook() {
		return book;
	}


	public void setBook(book book) {
		this.book = book;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	

	
}
