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
public class UserStatistics implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * 
	 */
	
	// Persistent Fields:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UsID")
    private int usId;
    
    
    @ManyToOne
   	@JoinColumn(name = "userId")
   	private user user;
    
    
    @Column(name = "NoOfBookUploaded")
    private int noOfBookUploaded;
    
    
    @Column(name = "NoOfBookTransac")
    private int noOfBookTransac;
    
    public int getUsId() {
		return usId;
	}

	public void setUsId(int usId) {
		this.usId = usId;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public int getNoOfBookUploaded() {
		return noOfBookUploaded;
	}

	public void setNoOfBookUploaded(int noOfBookUploaded) {
		this.noOfBookUploaded = noOfBookUploaded;
	}

	public int getNoOfBookTransac() {
		return noOfBookTransac;
	}

	public void setNoOfBookTransac(int noOfBookTransac) {
		this.noOfBookTransac = noOfBookTransac;
	}

	public int getNoOfBookDeleted() {
		return noOfBookDeleted;
	}

	public void setNoOfBookDeleted(int noOfBookDeleted) {
		this.noOfBookDeleted = noOfBookDeleted;
	}

	public int getNoOfBookPurchased() {
		return noOfBookPurchased;
	}

	public void setNoOfBookPurchased(int noOfBookPurchased) {
		this.noOfBookPurchased = noOfBookPurchased;
	}

	public double getRatingSeller() {
		return ratingSeller;
	}

	public void setRatingSeller(double ratingSeller) {
		this.ratingSeller = ratingSeller;
	}

	public double getRatingBuyer() {
		return ratingBuyer;
	}

	public void setRatingBuyer(double ratingBuyer) {
		this.ratingBuyer = ratingBuyer;
	}

	@Column(name = "NoOfBookDeleted")
    private int noOfBookDeleted;
    
    
    @Column(name = "NoOfBookPurchased")
    private int noOfBookPurchased;
    
    
    @Column(name = "RatingSeller")
    private double ratingSeller;
    
    @Column(name = "RatingBuyer")
    private double ratingBuyer;
    
    


	
}
