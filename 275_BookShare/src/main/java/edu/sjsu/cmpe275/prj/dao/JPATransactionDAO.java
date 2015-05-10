package edu.sjsu.cmpe275.prj.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.transaction;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPATransactionDAO implements TransactionDAO{

	
	/*
	 * Function to add address
	 * 
	 */
	
	public int insert(transaction transaction) 
	{
		System.out.println("in transaction jpa");
		int transactionId= 0;
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			transactionId = db.Insert(transaction);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return transactionId;
	}

	
	/*
	  * function to update address tuple n the database 
	  * 
	  */
	public void update(transaction transaction) {
		
		
				try {
					DBCrud<transaction> db = new DBCrud<transaction>();
					db.update(transaction);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}

	
	/*
	 * Function to delete address from databse
	 * 
	 */
	public void delete(transaction transaction) {
		
		
		
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			db.delete(transaction);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


	/*
	 * Function to delete address from database
	 * 
	 */
	


	public transaction getTransaction(int transactionId) {
		transaction result = new transaction();
		
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			result = db.get(result,transactionId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}


	public List<transaction> getTransactionByUser(int userId) {
		List<transaction> lstTransac = new ArrayList<transaction>();
		

		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			lstTransac = db.getTransactionByUser(userId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return lstTransac;
	}
	
	public List<transaction> getTransactionByUserAsBuyer(int buyerId) {
		List<transaction> lstTransac = new ArrayList<transaction>();
		

		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			lstTransac = db.getTransactionByUserAsBuyer(buyerId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return lstTransac;
	}

	public transaction getCurrentTransactionByUser(int userId) {
		transaction lstTransac = new transaction();
		

		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			lstTransac = db.getCurrentTransactionByUser(userId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return lstTransac;
	}
	
}
