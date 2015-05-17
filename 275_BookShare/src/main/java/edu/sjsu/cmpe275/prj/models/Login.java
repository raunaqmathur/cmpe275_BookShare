package edu.sjsu.cmpe275.prj.models;


import java.io.Serializable;


import javax.persistence.Entity;


@Entity
public class Login implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * 
	 */
	
	// Persistent Fields:
   
    private int userId;
    
    
    
    
    private String password;




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
    
	
    
   


	
}
